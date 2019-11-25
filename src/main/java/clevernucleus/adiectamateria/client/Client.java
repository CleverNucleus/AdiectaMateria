package clevernucleus.adiectamateria.client;

import clevernucleus.adiectamateria.common.Common;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.FMLClientHandler;

public class Client extends Common {
	
	@Override
	public void spawnParticle(World par0, BlockPos par1, EnumParticleTypes par2, int par3) {}
	
	@Override
	public void displayBook(EntityPlayer par0) {
		//FMLClientHandler.instance().displayGuiScreen(par0, new GuiBook());
	}
}
