package clevernucleus.adiectamateria.client.event;

import clevernucleus.adiectamateria.common.block.BlockInit;
import clevernucleus.adiectamateria.common.item.ItemInit;
import clevernucleus.adiectamateria.common.util.IItemModel;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@EventBusSubscriber(value = Side.CLIENT)
public class ModelRegistryHandler {
	
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent par0) {
		for(Item var : ItemInit.ITEMS) {
			if(var instanceof IItemModel) {
				((IItemModel)var).registerModels();
			}
		}
		
		for(Block var : BlockInit.BLOCKS) {
			if(var instanceof IItemModel) {
				((IItemModel)var).registerModels();
			}
		}
	}
}
