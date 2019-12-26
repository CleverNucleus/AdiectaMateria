package clevernucleus.adiectamateria.common;

import clevernucleus.adiectamateria.common.handler.UseHandler;
import clevernucleus.adiectamateria.common.util.interfaces.IConstants;
import clevernucleus.adiectamateria.common.util.interfaces.IProxy;
import clevernucleus.adiectamateria.common.util.recipes.Recipes;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class AdiectaMateria implements IConstants {
	
	@Mod(modid = MODID, name = NAME, version = VERSION)
	public static class Core {
		
		@SidedProxy(clientSide = PROXY_CLIENT, serverSide = PROXY_SERVER)
		public static IProxy proxy;
		
		@EventHandler
		public void preInit(FMLPreInitializationEvent par0) {
			proxy.preInit(par0);
			
			MinecraftForge.EVENT_BUS.register(new UseHandler());
		}
		
		@EventHandler
		public void init(FMLInitializationEvent par0) {
			Recipes.registerRecipes();
		}
	}
}
