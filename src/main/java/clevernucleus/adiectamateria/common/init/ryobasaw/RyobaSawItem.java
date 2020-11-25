package clevernucleus.adiectamateria.common.init.ryobasaw;

import java.util.Map;

import clevernucleus.adiectamateria.common.init.Registry;
import clevernucleus.adiectamateria.common.util.Dual;
import clevernucleus.adiectamateria.common.util.Util;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTier;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class RyobaSawItem extends AxeItem {
	private static final Map<Block, Dual<Dual<IItemProvider, Integer>, Dual<IItemProvider, Integer>>> RECIPES = Util.map(var -> {
		var.put(Registry.WOVEN_TILE, Dual.get(() -> {
			Dual<IItemProvider, Integer> var0 = Dual.make(Registry.SHOJI_PANEL, Integer.valueOf(12));
			Dual<IItemProvider, Integer> var1 = Dual.make(Registry.FINE_SHOJI_PANEL, Integer.valueOf(12));
			
			return Dual.make(var0, var1);
		}));
		var.put(Blocks.ICE, Dual.get(() -> {
			Dual<IItemProvider, Integer> var0 = Dual.make(Items.SNOWBALL, Integer.valueOf(4));
			Dual<IItemProvider, Integer> var1 = Dual.make(Items.SNOWBALL, Integer.valueOf(4));
			
			return Dual.make(var0, var1);
		}));
	});
	
	public RyobaSawItem(Properties par0) {
		super(ItemTier.GOLD, 3F, -2.4F, par0);
	}
	
	private void cutBlock(World par0, final BlockPos par1, final Dual<IItemProvider, Integer> par2) {
		ItemEntity var0 = new ItemEntity(par0, par1.getX(), par1.getY(), par1.getZ(), new ItemStack(par2.a(), par2.b().intValue()));
		
		par0.setBlockState(par1, Blocks.AIR.getDefaultState(), 11);
		par0.addEntity(var0);
	}
	
	@Override
	public ActionResultType onItemUse(ItemUseContext par0) {
		World var0 = par0.getWorld();
		BlockPos var1 = par0.getPos();
		Block var2 = var0.getBlockState(var1).getBlock();
		
		if(RECIPES.containsKey(var2)) {
			if(var0.isRemote) return ActionResultType.PASS;
			
			PlayerEntity var3 = par0.getPlayer();
			
			if(var3 != null) {
				Dual<Dual<IItemProvider, Integer>, Dual<IItemProvider, Integer>> var4 = RECIPES.get(var2);
				
				this.cutBlock(var0, var1, !var3.isCrouching() ? var4.a() : var4.b());
				
				par0.getItem().damageItem(1, var3, var -> {
					var.sendBreakAnimation(par0.getHand());
				});
				
				var0.playSound((PlayerEntity)null, var1, SoundEvents.ENTITY_SHEEP_SHEAR, SoundCategory.BLOCKS, 1.0F, 1.0F);
			}
			
			return ActionResultType.SUCCESS;
		}
		
		return super.onItemUse(par0);
	}
}
