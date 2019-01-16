package clevernucleus.adiectamateria.util;

import java.util.Random;

import clevernucleus.adiectamateria.Objects;
import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * @name AdiectaMateria
 * @author CleverNucleus
 * @license Apache 2.0
 */
@EventBusSubscriber
public class EventHandler {
	
	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> par0) {
		par0.getRegistry().registerAll(Objects.ITEMS.toArray(new Item[0]));
	}
	
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> par0) {
		par0.getRegistry().registerAll(Objects.BLOCKS.toArray(new Block[0]));
	}
	
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent par0) {
		for(Item var0 : Objects.ITEMS) {
			if(var0 instanceof IModel) {
				((IModel)var0).registerModels();
			}
		}
		
		for(Block var0 : Objects.BLOCKS) {
			if(var0 instanceof IModel) {
				((IModel)var0).registerModels();
			}
		}
	}
}
