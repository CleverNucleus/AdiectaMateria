package clevernucleus.adiectamateria.util;

import clevernucleus.adiectamateria.Core;
import clevernucleus.adiectamateria.Objects;
import clevernucleus.adiectamateria.objects.ItemTrinket;
import net.minecraft.util.WeightedRandomChestContent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ChestGenHooks;

/**
 * @name AdiectaMateria
 * @author CleverNucleus
 * @license Apache 2.0
 */

public class RegistryHandler {
	
	/**
	 * Registers all objects added to the list array looping through it.
	 */
	public static void preInitRegistries() {
		for(Item var0 : Objects.ITEMS) {
			GameRegistry.registerItem(var0, var0.getUnlocalizedName().substring(5));
		}
		
		for(Block var0 : Objects.BLOCKS) {
			GameRegistry.registerBlock(var0, var0.getUnlocalizedName().substring(5));
		}
	}
	
	/**
	 * Registers all objects added to the list array looping through it.
	 */
	public static void initRegistries() {
		CraftingHandler.implementCraftingRecipes();
		CraftingHandler.implementSmeltingRecipes();
		CraftingHandler.implementForeignModRecipes();
		
		for(Item var0 : ItemTrinket.trinket) {
			ItemTrinket.TRINKET.add(var0);
		}
		
		for(Item var0 : ItemTrinket.TRINKET) {
			ChestGenHooks.addItem(ChestGenHooks.DUNGEON_CHEST, new WeightedRandomChestContent(new ItemStack(var0), 1, 1, 1));
			ChestGenHooks.addItem(ChestGenHooks.MINESHAFT_CORRIDOR, new WeightedRandomChestContent(new ItemStack(var0), 1, 1, 1));
			ChestGenHooks.addItem(ChestGenHooks.PYRAMID_DESERT_CHEST, new WeightedRandomChestContent(new ItemStack(var0), 1, 1, 1));
			ChestGenHooks.addItem(ChestGenHooks.PYRAMID_JUNGLE_CHEST, new WeightedRandomChestContent(new ItemStack(var0), 1, 1, 1));
			ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CORRIDOR, new WeightedRandomChestContent(new ItemStack(var0), 1, 1, 1));
			ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CROSSING, new WeightedRandomChestContent(new ItemStack(var0), 1, 1, 1));
			ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_LIBRARY, new WeightedRandomChestContent(new ItemStack(var0), 1, 1, 1));
			ChestGenHooks.addItem(ChestGenHooks.VILLAGE_BLACKSMITH, new WeightedRandomChestContent(new ItemStack(var0), 1, 1, 1));
		}
		
		Core.proxy.registerEvents();
	}
}
