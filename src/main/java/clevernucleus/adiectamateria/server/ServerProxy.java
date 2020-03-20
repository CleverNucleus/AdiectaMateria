package clevernucleus.adiectamateria.server;

import java.util.Random;

import clevernucleus.adiectamateria.common.util.IProxy;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ServerProxy implements IProxy {
	
	@Override
	public void registerItemRenderer(Item par0, int par1, String par2) {}
	
	@Override
	public void spawnParticle(World par0, BlockPos par1, EnumParticleTypes par2, int par3, boolean par4) {
		if(par4) return;
		
		WorldServer var0 = (WorldServer) par0;
		Random var1 = new Random();
        IBlockState var2 = var0.getBlockState(par1);
        
		if(par3 == 0) {
			par3 = 15;
        }
        
        if(var2.getMaterial() != Material.AIR) {
            for(int var = 0; var < par3; ++var) {
                double d0 = var1.nextGaussian() * 0.02D;
                double d1 = var1.nextGaussian() * 0.02D;
                double d2 = var1.nextGaussian() * 0.02D;
                
                var0.spawnParticle(par2, (double)((float)par1.getX() + var1.nextFloat()), (double)par1.getY() + (double)var1.nextFloat() * var2.getBoundingBox(var0, par1).maxY, (double)((float)par1.getZ() + var1.nextFloat()), 1, d0, d1, d2, 0.05D);
            }
        } else {
            for(int var = 0; var < par3; ++var) {
                double d0 = var1.nextGaussian() * 0.02D;
                double d1 = var1.nextGaussian() * 0.02D;
                double d2 = var1.nextGaussian() * 0.02D;
                
                var0.spawnParticle(par2, (double)((float)par1.getX() + var1.nextFloat() + 1.0F), ((double)par1.getY() + (double)var1.nextFloat()) + 1.0D, (double)((float)par1.getZ() + var1.nextFloat() + 1.0F), 1, d0, d1, d2, 0.05D, new int[0]);
            }
        }
	}
	
	@Override
	public void displayBook(EntityPlayer par0, boolean par1) {}
	
	@Override
	public EntityPlayer getPlayer() {
		return null;
	}
}
