package clevernucleus.adiectamateria.common.init.ryobasaw;

import java.util.Map;

import clevernucleus.adiectamateria.common.init.Registry;
import clevernucleus.adiectamateria.common.util.PairResult;
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
	private static final Map<Block, PairResult<IItemProvider>> RECIPES = Util.map(var -> {
		var.put(Registry.WOVEN_TILE, PairResult.make(PairResult.P(Registry.FINE_SHOJI_PANEL, 12), PairResult.P(Registry.SHOJI_PANEL, 12)));
		var.put(Blocks.ICE, PairResult.make(PairResult.P(Items.SNOWBALL, 4)));
	});
	
	public RyobaSawItem(Properties par0) {
		super(ItemTier.GOLD, 3F, -2.4F, par0);
	}
	
	private void cutBlock(World par0, BlockPos par1, final PairResult.Pair<IItemProvider> par2) {
		ItemEntity var0 = new ItemEntity(par0, par1.getX(), par1.getY(), par1.getZ(), new ItemStack(par2.key(), par2.value()));
		
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
				this.cutBlock(var0, var1, RECIPES.get(var2).get(var3.isCrouching()));
				
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
