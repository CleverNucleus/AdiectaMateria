package clevernucleus.adiectamateria.server;

import clevernucleus.adiectamateria.common.util.interfaces.IProxy;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ServerProxy implements IProxy {
	
	@Override
	public void preInit(FMLPreInitializationEvent par0) {}
	
	@Override
	public void registerItemRenderer(Item par0, int par1, String par2) {}
	
	@Override
	public EntityPlayer getPlayer() {
		return null;
	}
}
