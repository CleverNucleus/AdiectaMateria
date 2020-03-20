package clevernucleus.adiectamateria.common.block;

import java.util.Random;

import net.minecraft.block.BlockCrops;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;

public class BlockDeadCrop extends BlockCrops {
	private static final PropertyBool STAGE = PropertyBool.create("stage");
	private static final AxisAlignedBB[] BOUNDS = new AxisAlignedBB[] {new AxisAlignedBB(0.125D, 0.0D, 0.125D, 0.875D, 0.125D, 0.875D), new AxisAlignedBB(0.125D, 0.0D, 0.125D, 0.875D, 0.25D, 0.875D), new AxisAlignedBB(0.125D, 0.0D, 0.125D, 0.875D, 0.375D, 0.875D), new AxisAlignedBB(0.125D, 0.0D, 0.125D, 0.875D, 0.5D, 0.875D), new AxisAlignedBB(0.125D, 0.0D, 0.125D, 0.875D, 0.625D, 0.875D), new AxisAlignedBB(0.125D, 0.0D, 0.125D, 0.875D, 0.75D, 0.875D), new AxisAlignedBB(0.125D, 0.0D, 0.125D, 0.875D, 0.875D, 0.875D), new AxisAlignedBB(0.125D, 0.0D, 0.125D, 0.875D, 1.0D, 0.875D)};
	
	public BlockDeadCrop(String par0) {
		super();
		
		this.setDefaultState(this.blockState.getBaseState().withProperty(this.getAgeProperty(), Integer.valueOf(0)).withProperty(this.getStageProperty(), Boolean.valueOf(false)));
		this.setUnlocalizedName(par0);
		this.setRegistryName(par0);
		
		BlockInit.BLOCKS.add(this);
	}
	
	@Override
	public void updateTick(World par0, BlockPos par1, IBlockState par2, Random par3) {
        if(!par0.isAreaLoaded(par1, 1)) return;
        if(par0.getLightFromNeighbors(par1.up()) >= 9) {
        	IBlockState var0 = par0.getBlockState(par1.down());
    		IBlockState var1 = par0.getBlockState(par1.up());
    		
    		int var2 = this.getAge(par2);
    		boolean var3 = this.getStage(par2);
    		
    		if(par0.isAirBlock(par1.up()) && !var3) {
    			if(var0.getBlock() == Blocks.FARMLAND) {
    				if(var2 < this.getMaxAge()) {
    					if(net.minecraftforge.common.ForgeHooks.onCropsGrowPre(par0, par1, par2, true)) {
    						par0.setBlockState(par1, this.withAge(var2 + 1).withProperty(this.getStageProperty(), Boolean.valueOf(false)));
    						net.minecraftforge.common.ForgeHooks.onCropsGrowPost(par0, par1, par2, par0.getBlockState(par1));
    					}
    				} else if(var2 == this.getMaxAge()) {
    					if(net.minecraftforge.common.ForgeHooks.onCropsGrowPre(par0, par1, par2, true)) {
    						par0.setBlockState(par1.up(), this.withAge(0).withProperty(this.getStageProperty(), Boolean.valueOf(false)));
    						net.minecraftforge.common.ForgeHooks.onCropsGrowPost(par0, par1, par2, par0.getBlockState(par1));
    					}
    				}
    			} else if(var0.getBlock() == this) {
    				if(par0.getBlockState(par1.down(2)).getBlock() == Blocks.FARMLAND) {
    					if(var2 < this.getMaxAge()) {
        					if(net.minecraftforge.common.ForgeHooks.onCropsGrowPre(par0, par1, par2, true)) {
        						par0.setBlockState(par1, this.withAge(var2 + 1).withProperty(this.getStageProperty(), Boolean.valueOf(false)));
        						net.minecraftforge.common.ForgeHooks.onCropsGrowPost(par0, par1, par2, par0.getBlockState(par1));
        					}
        				} else if(var2 == this.getMaxAge()) {
        					if(net.minecraftforge.common.ForgeHooks.onCropsGrowPre(par0, par1, par2, true)) {
        						par0.setBlockState(par1.up(), this.withAge(0).withProperty(this.getStageProperty(), Boolean.valueOf(true)));
        						net.minecraftforge.common.ForgeHooks.onCropsGrowPost(par0, par1, par2, par0.getBlockState(par1));
        					}
        				}
    				}
    			}
    		}
        }
    }
	
	@Override
	public void grow(World par0, BlockPos par1, IBlockState par2) {
        int i = this.getAge(par2) + this.getBonemealAgeIncrease(par0);
        int j = this.getMaxAge();
        boolean k = this.getStage(par2);
        
        if(i > j) {
            i = j;
        }
        
        par0.setBlockState(par1, this.withAge(i).withProperty(this.getStageProperty(), k), 2);
    }
	
	@Override
	public boolean canGrow(World par0, BlockPos par1, IBlockState par2, boolean par3) {
        return !this.isMaxAge(par2) && !this.getStage(par2);
    }
	
	protected PropertyBool getStageProperty() {
		return STAGE;
	}
	
	protected boolean getStage(IBlockState par0) {
		return ((Boolean)par0.getValue(this.getStageProperty())).booleanValue();
	}
	
	public IBlockState withStage(boolean par0) {
		return this.getDefaultState().withProperty(this.getStageProperty(), Boolean.valueOf(par0));
	}
	
	@Override
	protected boolean canSustainBush(IBlockState par0) {
        return par0.getBlock() == Blocks.FARMLAND || par0.getBlock() == this;
    }
	
	@Override
	public boolean canSustainPlant(IBlockState par0, IBlockAccess par1, BlockPos par2, EnumFacing par3, IPlantable par4) {
		return par4 == this;
	}
	
	@Override
	public void dropBlockAsItemWithChance(World par0, BlockPos par1, IBlockState par2, float par3, int par4) {
		if(this.getStage(par2)) return;
		
		super.dropBlockAsItemWithChance(par0, par1, par2, par3, par4);
	}
	
	@Override
	protected Item getSeed() {
		return Items.BONE;
	}
	
	@Override 
	protected Item getCrop() {
		return Items.BONE;
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState par0, IBlockAccess par1, BlockPos par2) {
		return !((Boolean)par0.getValue(this.getStageProperty())).booleanValue() ? BOUNDS[((Integer)par0.getValue(this.getAgeProperty())).intValue()] : BOUNDS[1];
	}
	
	@Override
	public IBlockState getStateFromMeta(int par0) {
		IBlockState var0 = this.withStage(par0 > 7);
		
        return var0.withProperty(this.getAgeProperty(), Integer.valueOf(par0 - (par0 > 7 ? 8 : 0)));
    }
	
	@Override
    public int getMetaFromState(IBlockState par0) {
		int var0 = this.getAge(par0);
		boolean var1 = this.getStage(par0);
		
		return var1 ? var0 + 8 : var0;
    }
    
	@Override
	protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[] {AGE, STAGE});
    }
}
