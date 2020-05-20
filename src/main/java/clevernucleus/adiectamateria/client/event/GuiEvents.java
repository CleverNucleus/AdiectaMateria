package clevernucleus.adiectamateria.client.event;

import clevernucleus.adiectamateria.common.AdiectaMateria;
import clevernucleus.adiectamateria.common.init.Registry;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AdiectaMateria.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class GuiEvents {

	@SubscribeEvent
	public static void onDrawTooltip(final ItemTooltipEvent par0) {
		if(par0.getItemStack().getItem() == Registry.ENDER_CRATE.asItem()) {
			if(!par0.getItemStack().hasTag()) return;
			
			int var0 = par0.getItemStack().getTag().getCompound("BlockEntityTag").getCompound("contents").getList("Items", 10).size();
			
			par0.getToolTip().add(new StringTextComponent(TextFormatting.GRAY + "" + var0 + "/" + AdiectaMateria.SIZE + I18n.format("text.slots")));
		}
	}
}
