package clevernucleus.adiectamateria.client.event;

import clevernucleus.adiectamateria.common.AdiectaMateria;
import clevernucleus.adiectamateria.common.init.Registry;
import clevernucleus.adiectamateria.common.init.spindle.SpindleItem;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.ItemModelsProperties;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = AdiectaMateria.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class RegistryEvents {
	
	@SubscribeEvent
	public static void onClientLoad(final FMLClientSetupEvent par0) {
		RenderTypeLookup.setRenderLayer(Registry.RICE, RenderType.getCutout());
		ItemModelsProperties.registerProperty(Registry.SPINDLE, new ResourceLocation(AdiectaMateria.MODID, "full"), (var0, var1, var2) -> ((SpindleItem)var0.getItem()).isFull(var0) ? 1.0F : 0.0F);
	}
}
