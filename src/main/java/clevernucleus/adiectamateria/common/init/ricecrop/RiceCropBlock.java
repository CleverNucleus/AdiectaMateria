package clevernucleus.adiectamateria.common.init.ricecrop;

import java.util.Random;

import clevernucleus.adiectamateria.common.init.Registry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropsBlock;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class RiceCropBlock extends CropsBlock implements IWaterLoggable {
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[] {Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)};
	
	public RiceCropBlock(Properties par0) {
		super(par0);
		
		this.setDefaultState(this.stateContainer.getBaseState().with(this.getAgeProperty(), Integer.valueOf(0)).with(WATERLOGGED, Boolean.valueOf(false)));
	}
	
	@Override
	protected IItemProvider getSeedsItem() {
		return Registry.RICE.asItem();
	}
	
	@Override
	protected boolean isValidGround(BlockState par0, IBlockReader par1, BlockPos par2) {
		return par0.getBlock() == Registry.PADDY;
	}
	
	@Override
	public boolean isValidPosition(BlockState par0, IWorldReader par1, BlockPos par2) {
		BlockPos var0 = par2.down();
		
		return this.isValidGround(par1.getBlockState(var0), par1, var0) && par1.getBlockState(par2.up()).getBlock() == Blocks.AIR && par1.getFluidState(par2).getFluid() == Fluids.WATER;
	}
	
	@Override
	public void tick(BlockState par0, ServerWorld par1, BlockPos par2, Random par3) {
		if(!par1.isAreaLoaded(par2, 1)) return;
		
		IFluidState var0 = par1.getFluidState(par2);
		
		if(par1.getLightSubtracted(par2, 0) >= 9) {
			int var1 = this.getAge(par0);
			
			if(var1 < this.getMaxAge()) {
				float var2 = getGrowthChance(this, par1, par2);
				
	            if(net.minecraftforge.common.ForgeHooks.onCropsGrowPre(par1, par2, par0, par3.nextInt((int)(5.0F / var2) + 1) == 0)) {
	            	par1.setBlockState(par2, this.withAge(var1 + 1).with(WATERLOGGED, Boolean.valueOf(var0.getFluid() == Fluids.WATER)), 2);
	                net.minecraftforge.common.ForgeHooks.onCropsGrowPost(par1, par2, par0);
	            }
			}
		}
	}
	
	@Override
	public void grow(World par0, BlockPos par1, BlockState par2) {
		IFluidState var0 = par0.getFluidState(par1);
		
		int var1 = this.getAge(par2) + this.getBonemealAgeIncrease(par0);
	    int var2 = this.getMaxAge();
	    
	    if(var1 > var2) {
	    	var1 = var2;
	    }
	    
	    par0.setBlockState(par1, this.withAge(var1).with(WATERLOGGED, Boolean.valueOf(var0.getFluid() == Fluids.WATER)), 2);
	}
	
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext par0) {
		IFluidState var0 = par0.getWorld().getFluidState(par0.getPos());
		
		return this.getDefaultState().with(WATERLOGGED, Boolean.valueOf(var0.getFluid() == Fluids.WATER));
	}
	
	@Override
	public IFluidState getFluidState(BlockState par0) {
		return par0.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : Fluids.EMPTY.getDefaultState();
	}
	
	@Override
	protected void fillStateContainer(Builder<Block, BlockState> par0) {
		par0.add(AGE, WATERLOGGED);
	}
	
	@Override
	public VoxelShape getShape(BlockState par0, IBlockReader par1, BlockPos par2, ISelectionContext par3) {
		return SHAPE_BY_AGE[par0.get(this.getAgeProperty())];
	}
}
