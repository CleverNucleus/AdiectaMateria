package clevernucleus.adiectamateria.common.init.enderbush;

import java.util.Random;

import clevernucleus.adiectamateria.common.util.Util;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class EnderBerry extends Block {
	public static final IntegerProperty AGE = BlockStateProperties.AGE_0_1;
	private static final VoxelShape SHAPE = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 13.0D, 14.0D);
	
	public EnderBerry(Properties par0) {
		super(par0);
		
		this.setDefaultState(this.stateContainer.getBaseState().with(AGE, Integer.valueOf(0)));
	}
	
	private static boolean hasWater(IWorldReader par0, BlockPos par1) {
		for(BlockPos var : BlockPos.getAllInBoxMutable(par1.add(-4, 0, -4), par1.add(4, 1, 4))) {
			if(par0.getFluidState(var).isTagged(FluidTags.WATER)) {
				return true;
			}
		}
		
		return net.minecraftforge.common.FarmlandWaterManager.hasBlockWaterTicket(par0, par1);
	}
	
	@Override
	public boolean isValidPosition(BlockState par0, IWorldReader par1, BlockPos par2) {
		return par1.getBlockState(par2.down()).getBlock() == Blocks.STONE;
	}
	
	@Override
	public BlockState updatePostPlacement(BlockState par0, Direction par1, BlockState par2, IWorld par3, BlockPos par4, BlockPos par5) {
		return !par0.isValidPosition(par3, par4) ? Blocks.AIR.getDefaultState() : par0;
	}
	
	@Override
	public VoxelShape getShape(BlockState par0, IBlockReader par1, BlockPos par2, ISelectionContext par3) {
		return SHAPE;
	}
	
	@Override
	public void onEntityCollision(BlockState par0, World par1, BlockPos par2, Entity par3) {
		if(par1.isRemote) return;
		
		par1.playSound((PlayerEntity)null, par2, SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.BLOCKS, 1.0F, 1.0F);
		par3.teleportKeepLoaded((double)(par2.getX() + (Util.RANDOM_NEGATIVE.get() * Util.RANDOM.nextInt(10))), (double)(par2.getY() + (Util.RANDOM_NEGATIVE.get() * Util.RANDOM.nextInt(2))), (double)(par2.getZ() + (Util.RANDOM_NEGATIVE.get() * Util.RANDOM.nextInt(10))));
	}
	
	@Override
	public ActionResultType onBlockActivated(BlockState par0, World par1, BlockPos par2, PlayerEntity par3, Hand par4, BlockRayTraceResult par5) {
		if(par0.get(AGE) == 0) return ActionResultType.PASS;
		if(!par1.isRemote) {
			ItemEntity var0 = new ItemEntity(par1, par2.getX(), par2.getY(), par2.getZ(), new ItemStack(this));
			
			par1.playSound((PlayerEntity)null, par2, SoundEvents.BLOCK_GRASS_BREAK, SoundCategory.BLOCKS, 1.0F, 1.0F);
			par1.setBlockState(par2, par0.with(AGE, Integer.valueOf(0)), 2);
			par1.addEntity(var0);
		}
		
		return ActionResultType.SUCCESS;
	}
	
	@Override
	public void tick(BlockState par0, ServerWorld par1, BlockPos par2, Random par3) {
		int var0 = par0.get(AGE);
		
		if(!hasWater(par1, par2) && !par1.isRainingAt(par2.up())) {
			if(var0 == 0 && Util.RANDOM.nextInt(100) < 20) {
				par1.setBlockState(par2, par0.with(AGE, Integer.valueOf(1)), 2);
			}
		}
	}
	
	@Override
	protected void fillStateContainer(Builder<Block, BlockState> par0) {
		par0.add(AGE);
	}
	
	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState par0, World par1, BlockPos par2, Random par3) {
		for(int var = 0; var < 3; var++) {
			int var0 = par3.nextInt(2) * 2 - 1;
	        int var1 = par3.nextInt(2) * 2 - 1;
	        
	        double var2 = (double)par2.getX() + 0.5D + 0.25D * (double)var0;
	        double var3 = (double)((float)par2.getY() + par3.nextFloat());
	        double var4 = (double)par2.getZ() + 0.5D + 0.25D * (double)var1;
	        double var5 = (double)(par3.nextFloat() * (float)var0);
	        double var6 = ((double)par3.nextFloat() - 0.5D) * 0.125D;
	        double var7 = (double)(par3.nextFloat() * (float)var1);
	        
	        par1.addParticle(ParticleTypes.PORTAL, var2, var3, var4, var5, var6, var7);
	    }
	}
}
