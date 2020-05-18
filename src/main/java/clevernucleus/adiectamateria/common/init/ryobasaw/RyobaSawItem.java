package clevernucleus.adiectamateria.common.init.ryobasaw;

import clevernucleus.adiectamateria.common.init.Registry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTier;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class RyobaSawItem extends AxeItem {
	public RyobaSawItem(Properties par0) {
		super(ItemTier.GOLD, 3F, -2.4F, par0);
	}
	
	private void cutBlock(World par0, BlockPos par1, Item par2) {
		ItemEntity var0 = new ItemEntity(par0, par1.getX(), par1.getY(), par1.getZ(), new ItemStack(par2, 12));
		
		par0.setBlockState(par1, Blocks.AIR.getDefaultState(), 11);
		par0.addEntity(var0);
	}
	
	@Override
	public ActionResultType onItemUse(ItemUseContext par0) {
		World var0 = par0.getWorld();
		BlockPos var1 = par0.getPos();
		Block var2 = var0.getBlockState(var1).getBlock();
		
		if(var2 == Registry.WOVEN_TILE) {
			PlayerEntity var3 = par0.getPlayer();
			Item var4 = (var3.isCrouching() ? Registry.FINE_SHOJI_PANEL.asItem() : Registry.SHOJI_PANEL.asItem());
			
			if(var3 != null) {
				if(!var0.isRemote) {
					cutBlock(var0, var1, var4);
					
					par0.getItem().damageItem(1, var3, var -> {
						var.sendBreakAnimation(par0.getHand());
					});
				}
				
				var0.playSound(var3, var1, SoundEvents.ENTITY_SHEEP_SHEAR, SoundCategory.BLOCKS, 1.0F, 1.0F);
			}
			
			return ActionResultType.SUCCESS;
		}
		
		return super.onItemUse(par0);
	}
}
