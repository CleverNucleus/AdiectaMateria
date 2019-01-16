package clevernucleus.adiectamateria;

import clevernucleus.adiectamateria.proxy.CommonProxy;
import clevernucleus.adiectamateria.util.RegistryHandler;
import clevernucleus.adiectamateria.util.Util;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * @name AdiectaMateria
 * @author CleverNucleus
 * @license Apache 2.0
 */

@Mod(modid = Util.MODID, name = Util.NAME, version = Util.VERSION, dependencies = Util.DEPENDENCIES)
public class Core {
	
	@SidedProxy(serverSide = Util.SERVER_PROXY_CLASS, clientSide = Util.CLIENT_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@Mod.Instance(Util.MODID)
	public static Core instance;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent par0) {
		RegistryHandler.preInitRegistries();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent par0) {
		RegistryHandler.initRegistries();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent par0) {
		
	}
}
