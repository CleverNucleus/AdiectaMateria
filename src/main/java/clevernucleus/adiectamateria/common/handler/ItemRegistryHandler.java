package clevernucleus.adiectamateria.common.handler;

import clevernucleus.adiectamateria.common.block.BlockUnit;
import clevernucleus.adiectamateria.common.item.ItemUnit;
import clevernucleus.adiectamateria.common.util.interfaces.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class ItemRegistryHandler {
	
	/**
	 * Registers items to the game.
	 * @param par0 RegistryEvent.Register Item item being registered
	 */
	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> par0) {
		par0.getRegistry().registerAll(ItemUnit.ITEMS.toArray(new Item[0]));
	}
	
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> par0) {
		par0.getRegistry().registerAll(BlockUnit.BLOCKS.toArray(new Block[0]));
	}
	
	/**
	 * Registers and creates a model for each item/block registered.
	 * @param par0 ModelRegistryEvent event
	 */
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent par0) {
		for(Item var : ItemUnit.ITEMS) {
			if(var instanceof IHasModel) {
				((IHasModel)var).registerModels();
			}
		}
		
		for(Block var : BlockUnit.BLOCKS) {
			if(var instanceof IHasModel) {
				((IHasModel)var).registerModels();
			}
		}
	}
}
