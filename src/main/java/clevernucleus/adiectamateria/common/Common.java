package clevernucleus.adiectamateria.common;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Common {
	public static Common proxy(boolean par0) {
		try {
			return par0 ? getSide("clevernucleus.adiectamateria.client.Client") : getSide("clevernucleus.adiectamateria.server.Server");
		} catch(Exception parE) {
			return new Common();
		}
	}
	
	public void spawnParticle(World par0, BlockPos par1, EnumParticleTypes par2, int par3) {}
	
	public void displayBook(EntityPlayer par0) {}
	
	private static Common getSide(String par0) throws Exception {
		return (Common)((Object)Class.forName(par0).newInstance());
	}
}
