package clevernucleus.adiectamateria.objects;

import clevernucleus.adiectamateria.Objects;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/**
 * @name AdiectaMateria
 * @author CleverNucleus
 * @license Apache 2.0
 */
public class BlockRiceCrop extends BlockCrops {
	
	private static final AxisAlignedBB[] var0 = new AxisAlignedBB[] {new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.125D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.25D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.375D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.5625D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.8125D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D)};
	
	public BlockRiceCrop(String par0) {
		this.setUnlocalizedName(par0);
		this.setRegistryName(par0);
		
		Objects.BLOCKS.add(this);
		Objects.ITEMS.add(new ItemBlock(this).setRegistryName(getRegistryName()));
	}
	
	/**
	 * Fired when a right-click action is received, asks if the block (crop) is fully grown; if yes, then
	 * the growth stage is reset to 0, and the cropDrops and seedDrops are spawned.
	 */
	@Override
	public boolean onBlockActivated(World par0, BlockPos par1, IBlockState par2, EntityPlayer par3, EnumHand par4, EnumFacing par5, float par6, float par7, float par8) {
		if(!par0.isRemote) {
			if(this.isMaxAge(par2)) {
				par0.spawnEntity(new EntityItem(par0, par1.getX(), par1.getY(), par1.getZ(), new ItemStack(Objects.ITEM_RICE_SEEDS, 2)));
				par0.setBlockState(par1, this.withAge(0));
				return true;
			}
		}
		return false;
	}
	
	/**
	 * The item that is used to plant this block (crop).
	 */
	@Override
	protected Item getSeed() {
		return Objects.ITEM_RICE_SEEDS;
	}
	
	/**
	 * The item dropped from the block (crop) when harvested - can be the same as getSeed().
	 */
	@Override 
	protected Item getCrop() {
		return Objects.ITEM_RICE_SEEDS;
	}
	
	/**
	 * Determines the bounding box (size) of the block (crop) based on its growth stage.
	 */
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState par0, IBlockAccess par1, BlockPos par2) {
		return var0[((Integer)par0.getValue(this.getAgeProperty())).intValue()];
	}
}
