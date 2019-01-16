package clevernucleus.adiectamateria;

import clevernucleus.adiectamateria.proxy.CommonProxy;
import clevernucleus.adiectamateria.util.RegistryHandler;
import clevernucleus.adiectamateria.util.Util;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * @name AdiectaMateria
 * @author CleverNucleus
 * @license Apache 2.0
 */

@Mod(modid = Util.MODID, name = Util.NAME, version = Util.VERSION)
public class Core {
	
	@SidedProxy(serverSide = Util.SERVER_PROXY_CLASS, clientSide = Util.CLIENT_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@Mod.Instance(Util.MODID)
	public static Core instance;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent par0) {}
	
	@EventHandler
	public void init(FMLInitializationEvent par0) {
		RegistryHandler.initRegistries();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent par0) {}
}
