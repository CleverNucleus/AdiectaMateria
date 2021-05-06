package clevernucleus.adiectamateria.common.init.mudbrick;

import java.util.Random;

import clevernucleus.adiectamateria.common.init.Registry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.server.ServerWorld;

public class MudbrickBlock extends Block {
	public static final IntegerProperty AGE = BlockStateProperties.AGE_3;
	
	public MudbrickBlock(Properties par0) {
		super(par0);
		
		this.registerDefaultState(this.stateDefinition.any().setValue(AGE, Integer.valueOf(0)));
	}
	
	private static boolean hasWater(IWorldReader par0, BlockPos par1) {
		for(BlockPos var : BlockPos.betweenClosed(par1.offset(-4, 0, -4), par1.offset(4, 1, 4))) {
			if(par0.getFluidState(var).is(FluidTags.WATER)) {
				return true;
			}
		}
		
		return net.minecraftforge.common.FarmlandWaterManager.hasBlockWaterTicket(par0, par1);
	}
	
	@Override
	public void tick(BlockState par0, ServerWorld par1, BlockPos par2, Random par3) {
		int var0 = par0.getValue(AGE);
		
		if(!hasWater(par1, par2) && !par1.isRainingAt(par2.above())) {
			if(var0 < 3) {
				par1.setBlock(par2, par0.setValue(AGE, Integer.valueOf(var0 + 1)), 2);
			} else {
				par1.setBlock(par2, Registry.DRY_MUDBRICK.defaultBlockState(), 2);
			}
		} else {
			if(var0 > 0) {
				par1.setBlock(par2, par0.setValue(AGE, Integer.valueOf(var0 - 1)), 2);
			}
		}
	}
	
	@Override
	protected void createBlockStateDefinition(Builder<Block, BlockState> par0) {
		par0.add(AGE);
	}
}
