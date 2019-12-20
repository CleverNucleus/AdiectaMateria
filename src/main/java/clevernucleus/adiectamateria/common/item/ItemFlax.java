package clevernucleus.adiectamateria.common.item;

import clevernucleus.adiectamateria.common.AdiectaMateria.Core;
import clevernucleus.adiectamateria.common.block.BlockInit;
import clevernucleus.adiectamateria.common.util.interfaces.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.block.BlockDoublePlant.EnumPlantType;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemFlax extends Item implements IHasModel {
    public ItemFlax(String par0) {
        this.setUnlocalizedName(par0);
		this.setRegistryName(par0);
		this.setCreativeTab(ItemCreativeTab.MODTAB);
		
		ItemInit.ITEMS.add(this);
    }
    
    @Override
	public EnumActionResult onItemUse(EntityPlayer par0, World par1, BlockPos par2, EnumHand par3, EnumFacing par4, float par5, float par6, float par7) {
		ItemStack var0 = par0.getHeldItem(par3);
		EnumActionResult var2 = EnumActionResult.FAIL;
		
		if(par1.getBlockState(par2).getBlock() == Blocks.FARMLAND && par1.isAirBlock(par2.up())) {
			var2 = EnumActionResult.SUCCESS;
		}
		
		if(var2 == EnumActionResult.SUCCESS) {
			if(!par1.isRemote) {
				par1.setBlockState(par2.up(), BlockInit.FLAX_CROP.getDefaultState());
				
				if(!par0.capabilities.isCreativeMode) {
		            var0.damageItem(1, par0);
		        }
			}
			
			par1.playSound(par0, par2, SoundEvents.BLOCK_GRASS_BREAK, SoundCategory.BLOCKS, 1.0F, 1.0F);
		}
		
		return var2;
	}
    
    @Override
	public void registerModels() {
		Core.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
