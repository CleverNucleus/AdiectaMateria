package clevernucleus.adiectamateria.client;

import clevernucleus.adiectamateria.common.util.interfaces.IProxy;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy implements IProxy {
	
	@Override
	public void preInit(FMLPreInitializationEvent par0) {}
	
	@Override
	public void registerItemRenderer(Item par0, int par1, String par2) {
		ModelLoader.setCustomModelResourceLocation(par0, par1, new ModelResourceLocation(par0.getRegistryName(), par2));
	}
	
	@Override
	public EntityPlayer getPlayer() {
		return Minecraft.getMinecraft().player;
	}
}
