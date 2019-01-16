package clevernucleus.adiectamateria.objects;

import clevernucleus.adiectamateria.Core;
import clevernucleus.adiectamateria.Objects;
import clevernucleus.adiectamateria.util.IModel;
import clevernucleus.adiectamateria.util.Util;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;

/**
 * @name AdiectaMateria
 * @author CleverNucleus
 * @license Apache 2.0
 */

public class ItemRiceSeeds extends Item implements IModel, IPlantable {
	
	public ItemRiceSeeds(String par0) {
		this.setUnlocalizedName(par0);
		this.setRegistryName(par0);
		this.setCreativeTab(Objects.TAB_ADIECTAMATERIA);
		
		Objects.ITEMS.add(this);
	}
	
    /**
     * Fired when the item is right-clicked on a block - not to be confused with onItemRightClick().
     */
	@Override
	public EnumActionResult onItemUse(EntityPlayer par0, World par1, BlockPos par2, EnumHand par3, EnumFacing par4, float par5, float par6, float par7) {
		ItemStack var0 = par0.getHeldItem(par3);
		IBlockState var1 = par1.getBlockState(par2);
		
		if(par4 == EnumFacing.UP && par0.canPlayerEdit(par2.offset(par4), par4, var0) && var1.getBlock().canSustainPlant(var1, par1, par2, EnumFacing.UP, this) && par1.isAirBlock(par2.up())) {
			par1.setBlockState(par2.up(), Objects.BLOCK_RICE_CROP.getDefaultState());
			var0.shrink(1);
			
			return EnumActionResult.SUCCESS;
		}
		else return EnumActionResult.FAIL;
	}
	
	/**
	 * Determines the plant type for this crop; e.g. a cactus has the EnumPlantType Desert.
	 */
	@Override
	public EnumPlantType getPlantType(IBlockAccess par0, BlockPos par1) {
		return EnumPlantType.Crop;
	}
	
	/**
	 * Determines the block and its state that should be placed (planted).
	 */
	@Override
	public IBlockState getPlant(IBlockAccess par0, BlockPos par1) {
		return Objects.BLOCK_RICE_CROP.getDefaultState();
	}
	
    /**
     * Registers the item model to be displayed in the inventory.
     */
	@Override
	public void registerModels() {
		Core.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
