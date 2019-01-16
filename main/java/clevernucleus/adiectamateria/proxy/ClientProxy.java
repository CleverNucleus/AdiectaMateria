package clevernucleus.adiectamateria.proxy;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

/**
 * @name AdiectaMateria
 * @author CleverNucleus
 * @license Apache 2.0
 */
public class ClientProxy extends CommonProxy {
	public void registerItemRenderer(Item par0, int par1, String par2) {
		ModelLoader.setCustomModelResourceLocation(par0, par1, new ModelResourceLocation(par0.getRegistryName(), par2));
	}
}
