package clevernucleus.adiectamateria.common.util.interfaces;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public interface IProxy {
	void preInit(FMLPreInitializationEvent par0);
	void registerItemRenderer(Item par0, int par1, String par2);
	
	EntityPlayer getPlayer();
}
