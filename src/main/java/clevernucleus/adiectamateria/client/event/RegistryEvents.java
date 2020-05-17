package clevernucleus.adiectamateria.client.event;

import clevernucleus.adiectamateria.common.AdiectaMateria;
import clevernucleus.adiectamateria.common.init.Registry;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = AdiectaMateria.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class RegistryEvents {
	
	@SubscribeEvent
	public static void onClientLoad(final FMLClientSetupEvent par0) {
		RenderTypeLookup.setRenderLayer(Registry.RICE, RenderType.getCutout());
	}
}
