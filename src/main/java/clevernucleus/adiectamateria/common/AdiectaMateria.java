package clevernucleus.adiectamateria.common;

import clevernucleus.adiectamateria.common.event.SeedLootHandler;
import clevernucleus.adiectamateria.common.recipe.Recipes;
import clevernucleus.adiectamateria.common.util.IProxy;
import clevernucleus.adiectamateria.common.util.Util;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Util.MODID, name = Util.NAME, version = Util.VERSION)
public class AdiectaMateria {
	
	@SidedProxy(clientSide = Util.PROXY_CLIENT, serverSide = Util.PROXY_SERVER)
	public static IProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent par0) {
		MinecraftForge.EVENT_BUS.register(new SeedLootHandler());
	}
	
	@EventHandler
	public void init(FMLInitializationEvent par0) {
		Recipes.registerRecipes();
	}
}
