package clevernucleus.adiectamateria.util;

import net.minecraftforge.common.MinecraftForge;

/**
 * @name AdiectaMateria
 * @author CleverNucleus
 * @license Apache 2.0
 */
public class RegistryHandler {
	public static void initRegistries() {
		NoiseHandler.registerSounds();
		RecipeHandler.registerRecipes();
		MinecraftForge.EVENT_BUS.register(new DropHandler());
	}
}
