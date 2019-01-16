package clevernucleus.adiectamateria.proxy;

import clevernucleus.adiectamateria.util.EventHandler;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

/**
 * @name AdiectaMateria
 * @author CleverNucleus
 * @license Apache 2.0
 */

public class CommonProxy {
	public void registerEvents() {
		MinecraftForge.EVENT_BUS.register(new EventHandler());
	}
	
	public World getClientWorld() {
		return null;
	}
}
