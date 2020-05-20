package clevernucleus.adiectamateria.common.init.endercrate;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class EnderCrateBlock extends Block {
	public EnderCrateBlock(Properties par0) {
		super(par0);
	}
	
	@Override
	public boolean hasTileEntity(BlockState par0) {
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(BlockState par0, IBlockReader par1) {
		return new EnderCrateTileEntity();
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
