package clevernucleus.adiectamateria.common.init.MudBrick;

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
	public static final IntegerProperty AGE = BlockStateProperties.AGE_0_3;
	
	public MudbrickBlock(Properties par0) {
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
	public void tick(BlockState par0, ServerWorld par1, BlockPos par2, Random par3) {
		int var0 = par0.get(AGE);
		
		if(!hasWater(par1, par2) && !par1.isRainingAt(par2.up())) {
			if(var0 < 3) {
				par1.setBlockState(par2, par0.with(AGE, Integer.valueOf(var0 + 1)), 2);
			} else {
				par1.setBlockState(par2, Registry.DRY_MUDBRICK.getDefaultState(), 2);
			}
		} else {
			if(var0 > 0) {
				par1.setBlockState(par2, par0.with(AGE, Integer.valueOf(var0 - 1)), 2);
			}
		}
	}
	
	@Override
	protected void fillStateContainer(Builder<Block, BlockState> par0) {
		par0.add(AGE);
	}
}
