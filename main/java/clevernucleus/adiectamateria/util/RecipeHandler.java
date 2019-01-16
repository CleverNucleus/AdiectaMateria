package clevernucleus.adiectamateria.util;

import java.util.ArrayList;
import java.util.List;

import clevernucleus.adiectamateria.Objects;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * @name AdiectaMateria
 * @author CleverNucleus
 * @license Apache 2.0
 */
public class RecipeHandler {
	
	/**
	 * Method to load custom recipes; all recipes in this method are auto registered.
	 */
	public static void registerRecipes() {
		CraftingHandler.addDyeRecipe(0, Items.DYE, 6, Objects.ITEM_PULVIS_DUST, Items.DYE);
		
		CraftingHandler.addMeatRecipe(0, Items.ROTTEN_FLESH, 1, Items.SUGAR);
		
		CraftingHandler.addShapelessRecipe(0, Items.FLINT, 1, Objects.ITEM_PULVIS_DUST);
		CraftingHandler.addShapelessRecipe(1, Items.FLINT, 1, Blocks.GRAVEL, Blocks.GRAVEL, Blocks.GRAVEL);
		CraftingHandler.addShapelessRecipe(2, Items.FLINT, 3, Objects.ITEM_PULVIS_DUST, Items.COAL, Items.COAL);
		CraftingHandler.addShapelessRecipe(0, Items.COAL, 3, Objects.ITEM_PULVIS_DUST, Objects.ITEM_PULVIS_DUST);
		CraftingHandler.addShapelessRecipe(0, Items.REDSTONE, 3, Objects.ITEM_PULVIS_DUST, Objects.ITEM_PULVIS_DUST, Objects.ITEM_PULVIS_DUST);
		CraftingHandler.addShapelessRecipe(0, Items.GLOWSTONE_DUST, 3, Objects.ITEM_PULVIS_DUST, Items.REDSTONE, Items.REDSTONE);
		CraftingHandler.addShapelessRecipe(0, Items.GUNPOWDER, 3, Objects.ITEM_PULVIS_DUST, Items.FLINT, Items.FLINT);
		CraftingHandler.addShapelessRecipe(0, Items.CLAY_BALL, 3, Objects.ITEM_PULVIS_DUST, Items.GUNPOWDER, Items.COAL);
		CraftingHandler.addShapelessRecipe(0, Items.SNOWBALL, 1, Objects.ITEM_PULVIS_DUST, Items.CLAY_BALL);
		CraftingHandler.addShapelessRecipe(0, Items.SLIME_BALL, 1, Objects.ITEM_PULVIS_DUST, Items.SNOWBALL);
		CraftingHandler.addShapelessRecipe(0, Items.FEATHER, 3, Objects.ITEM_PULVIS_DUST, Items.FLINT, Items.PAPER);
		CraftingHandler.addShapelessRecipe(0, Items.STRING, 1, Objects.ITEM_PULVIS_DUST, Items.FEATHER);
		CraftingHandler.addShapelessRecipe(0, Items.SUGAR, 3, Objects.ITEM_PULVIS_DUST, Items.GUNPOWDER, Items.WHEAT_SEEDS);
		CraftingHandler.addShapelessRecipe(0, Items.REEDS, 1, Objects.ITEM_PULVIS_DUST, Items.SUGAR);
		CraftingHandler.addShapelessRecipe(0, Items.WHEAT_SEEDS, 1, Objects.ITEM_PULVIS_DUST, Items.WHEAT);
		CraftingHandler.addShapelessRecipe(0, Items.QUARTZ, 3, Objects.ITEM_PULVIS_DUST, Items.FLINT, Items.GLOWSTONE_DUST);
		CraftingHandler.addShapelessRecipe(0, Items.BONE, 1, Objects.ITEM_PULVIS_DUST, Items.STICK);
		CraftingHandler.addShapelessRecipe(0, Items.STICK, 1, Objects.ITEM_PULVIS_DUST, Items.BONE);
		CraftingHandler.addShapelessRecipe(0, Items.SPIDER_EYE, 1, Objects.ITEM_PULVIS_DUST, Items.SLIME_BALL, Items.REDSTONE);
		CraftingHandler.addShapelessRecipe(0, Items.ENDER_EYE, 1, Objects.ITEM_PULVIS_DUST, Items.SPIDER_EYE);
		CraftingHandler.addShapelessRecipe(0, Items.ENDER_PEARL, 1, Objects.ITEM_PULVIS_DUST, Items.ENDER_EYE);
		CraftingHandler.addShapelessRecipe(0, Items.GHAST_TEAR, 1, Objects.ITEM_PULVIS_DUST, Items.GOLD_NUGGET, Items.GLOWSTONE_DUST);
		CraftingHandler.addShapelessRecipe(0, Blocks.DIRT, 1, Objects.ITEM_PULVIS_DUST, Blocks.SAND);
		CraftingHandler.addShapelessRecipe(0, Blocks.GRAVEL, 1, Objects.ITEM_PULVIS_DUST, Blocks.DIRT);
		CraftingHandler.addShapelessRecipe(0, Blocks.COBBLESTONE, 1, Objects.ITEM_PULVIS_DUST, Blocks.GRAVEL);
		CraftingHandler.addShapelessRecipe(0, Blocks.NETHERRACK, 1, Objects.ITEM_PULVIS_DUST, Blocks.COBBLESTONE);
		CraftingHandler.addShapelessRecipe(0, Blocks.SOUL_SAND, 1, Objects.ITEM_PULVIS_DUST, Blocks.NETHERRACK);
		CraftingHandler.addShapelessRecipe(0, Blocks.END_STONE, 1, Objects.ITEM_PULVIS_DUST, Blocks.SOUL_SAND);
		CraftingHandler.addShapelessRecipe(0, Blocks.SAND, 1, Objects.ITEM_PULVIS_DUST, Blocks.END_STONE);
		
		CraftingHandler.addShapedRecipe(0, "AAA", Objects.ITEM_RICE_PAPER, 2, Objects.ITEM_RICE_SEEDS);
		CraftingHandler.addShapedRecipe(0, "ABA", "BCB", "ABA", Objects.BLOCK_RICE, 4, Items.STICK, Objects.ITEM_RICE_PAPER, Items.CLAY_BALL);
		CraftingHandler.addShapedRecipe(1, "ABA", "BCB", "ABA", Objects.BLOCK_RICE, 4, Objects.ITEM_RICE_PAPER, Items.STICK, Items.CLAY_BALL);
		CraftingHandler.addShapedRecipe(0, "ABA", "BCB", "ABA", Objects.ITEM_INFINITE_LAVA, 1, Objects.ITEM_ALTERA_DUST, Blocks.DIAMOND_BLOCK, Items.LAVA_BUCKET);
		CraftingHandler.addShapedRecipe(1, "ABA", "BCB", "ABA", Objects.ITEM_INFINITE_LAVA, 1, Blocks.DIAMOND_BLOCK, Objects.ITEM_ALTERA_DUST, Items.LAVA_BUCKET);
		CraftingHandler.addShapedRecipe(0, "ABA", "BCB", "ABA", Objects.ITEM_INFINITE_WATER, 1, Objects.ITEM_ALTERA_DUST, Blocks.DIAMOND_BLOCK, Items.WATER_BUCKET);
		CraftingHandler.addShapedRecipe(1, "ABA", "BCB", "ABA", Objects.ITEM_INFINITE_WATER, 1, Blocks.DIAMOND_BLOCK, Objects.ITEM_ALTERA_DUST, Items.WATER_BUCKET);
		CraftingHandler.addShapedRecipe(0, "ABA", "BCB", "ABA", Objects.ITEM_ORB_DAY, 1, Objects.ITEM_ALTERA_DUST, Blocks.DIAMOND_BLOCK, Items.GLOWSTONE_DUST);
		CraftingHandler.addShapedRecipe(1, "ABA", "BCB", "ABA", Objects.ITEM_ORB_DAY, 1, Blocks.DIAMOND_BLOCK, Objects.ITEM_ALTERA_DUST, Items.GLOWSTONE_DUST);
		CraftingHandler.addShapedRecipe(0, "ABA", "BCB", "ABA", Objects.ITEM_ORB_NIGHT, 1, Objects.ITEM_ALTERA_DUST, Blocks.DIAMOND_BLOCK, Items.REDSTONE);
		CraftingHandler.addShapedRecipe(1, "ABA", "BCB", "ABA", Objects.ITEM_ORB_NIGHT, 1, Blocks.DIAMOND_BLOCK, Objects.ITEM_ALTERA_DUST, Items.REDSTONE);
		CraftingHandler.addShapedRecipe(0, "ABA", "BCB", "ABA", Objects.ITEM_ORB_ELEC, 1, Objects.ITEM_ALTERA_DUST, Blocks.DIAMOND_BLOCK, Items.GUNPOWDER);
		CraftingHandler.addShapedRecipe(1, "ABA", "BCB", "ABA", Objects.ITEM_ORB_ELEC, 1, Blocks.DIAMOND_BLOCK, Objects.ITEM_ALTERA_DUST, Items.GUNPOWDER);
		CraftingHandler.addShapedRecipe(0, "ABA", "BCB", "ABA", Objects.ITEM_ORB_FIRE, 1, Objects.ITEM_ALTERA_DUST, Blocks.DIAMOND_BLOCK, Items.BLAZE_POWDER);
		CraftingHandler.addShapedRecipe(1, "ABA", "BCB", "ABA", Objects.ITEM_ORB_FIRE, 1, Blocks.DIAMOND_BLOCK, Objects.ITEM_ALTERA_DUST, Items.BLAZE_POWDER);
		CraftingHandler.addShapedRecipe(0, "ABA", "BCB", "ABA", Objects.ITEM_ORB_RAIN, 1, Objects.ITEM_ALTERA_DUST, Blocks.DIAMOND_BLOCK, Items.QUARTZ);
		CraftingHandler.addShapedRecipe(1, "ABA", "BCB", "ABA", Objects.ITEM_ORB_RAIN, 1, Blocks.DIAMOND_BLOCK, Objects.ITEM_ALTERA_DUST, Items.QUARTZ);
		CraftingHandler.addShapedRecipe(0, "ABA", "BCB", "ABA", Objects.ITEM_ORB_ENDER, 1, Objects.ITEM_ALTERA_DUST, Blocks.DIAMOND_BLOCK, Items.ENDER_PEARL);
		CraftingHandler.addShapedRecipe(1, "ABA", "BCB", "ABA", Objects.ITEM_ORB_ENDER, 1, Blocks.DIAMOND_BLOCK, Objects.ITEM_ALTERA_DUST, Items.ENDER_PEARL);
		CraftingHandler.addShapedRecipe(0, "AAA", "AAA", "AAA", Objects.ITEM_RYE_COOKED, 1, Objects.ITEM_RYE_RAW);
		CraftingHandler.addShapedRecipe(0, "AAA", "AAA", "AAA", Items.SKULL, 1, Items.BONE);
		CraftingHandler.addShapedRecipe(0, "AAA", "ABA", "AAA", Objects.BLOCK_SAND_LAMP, 1, Blocks.SAND, Objects.ITEM_PULVIS_DUST);
		CraftingHandler.addShapedRecipe(0, " A ", "ABA", " A ", Objects.ITEM_GREATER_APPLE, 1, Items.NETHER_STAR, Items.APPLE);
		CraftingHandler.addShapedRecipe(0, "ABC", "DEF", "GHI", Objects.ITEM_GOD_JUICE, 1, Items.APPLE, Items.BEETROOT, Items.BREAD, Items.CARROT, Items.EGG, Items.MELON, Items.POTATO, Items.SUGAR, Items.GLASS_BOTTLE);
		
		CraftingHandler.addSmeltingRecipe(Objects.ITEM_RYE_RAW, 1, Objects.ITEM_RICE_SEEDS);
		CraftingHandler.addSmeltingRecipe(Items.LEATHER, 1, Items.ROTTEN_FLESH);
		CraftingHandler.addSmeltingRecipe(Items.BLAZE_ROD, 1, Items.STICK);
		CraftingHandler.addSmeltingRecipe(Objects.ITEM_PULVIS_DUST, 1, Items.FLINT);
		CraftingHandler.addSmeltingRecipe(Objects.ITEM_ALTERA_DUST, 1, Objects.ITEM_PULVIS_DUST);
		
		if(Loader.isModLoaded(Util.MODID_AE2)) {
			GameRegistry.addShapelessRecipe(new ResourceLocation("adiectamateria:ae2"), new ResourceLocation("adiectamateria:block"), new ItemStack(Item.getByNameOrId("appliedenergistics2:sky_stone_block"), 6), new Ingredient[] {Ingredient.fromItem(Objects.ITEM_PULVIS_DUST), Ingredient.fromItem(ItemBlock.getItemFromBlock(Blocks.STONE)), Ingredient.fromItem(Items.GLOWSTONE_DUST)});
			GameRegistry.addShapelessRecipe(new ResourceLocation("adiectamateria:ae2_0"), new ResourceLocation("adiectamateria:item"), new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 0), new Ingredient[] {Ingredient.fromItem(Items.QUARTZ), Ingredient.fromItem(Items.REDSTONE)});
			GameRegistry.addShapelessRecipe(new ResourceLocation("adiectamateria:ae2_1"), new ResourceLocation("adiectamateria:item"), new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 1), new Ingredient[] {Ingredient.fromStacks(new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 0)), Ingredient.fromItem(Items.REDSTONE)});
			GameRegistry.addShapelessRecipe(new ResourceLocation("adiectamateria:ae2_2"), new ResourceLocation("adiectamateria:item"), new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 7), new Ingredient[] {Ingredient.fromStacks(new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 1)), Ingredient.fromItem(Items.REDSTONE)});
			GameRegistry.addShapelessRecipe(new ResourceLocation("adiectamateria:ae2_3"), new ResourceLocation("adiectamateria:item"), new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 23), new Ingredient[] {Ingredient.fromStacks(new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 1)), Ingredient.fromItem(Items.REDSTONE), Ingredient.fromItem(Items.IRON_INGOT)});
			GameRegistry.addShapelessRecipe(new ResourceLocation("adiectamateria:ae2_4"), new ResourceLocation("adiectamateria:item"), new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 22), new Ingredient[] {Ingredient.fromStacks(new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 1)), Ingredient.fromItem(Items.REDSTONE), Ingredient.fromItem(Items.GOLD_INGOT)});
			GameRegistry.addShapelessRecipe(new ResourceLocation("adiectamateria:ae2_5"), new ResourceLocation("adiectamateria:item"), new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 24), new Ingredient[] {Ingredient.fromStacks(new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 1)), Ingredient.fromItem(Items.REDSTONE), Ingredient.fromItem(Items.DIAMOND)});
			GameRegistry.addShapedRecipe(new ResourceLocation("adiectamateria:ae2_6"), new ResourceLocation("adiectamateria:item"), new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 10), new Object[] {"ABA", "ABA", "ABA", 'A', new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 0), 'B', new ItemStack(Items.REDSTONE)});
			GameRegistry.addShapedRecipe(new ResourceLocation("adiectamateria:ae2_7"), new ResourceLocation("adiectamateria:item"), new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 12), new Object[] {"ABA", "ABA", "ABA", 'A', new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 7), 'B', new ItemStack(Items.REDSTONE)});
			GameRegistry.addShapedRecipe(new ResourceLocation("adiectamateria:ae2_8"), new ResourceLocation("adiectamateria:item"), new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 11), new Object[] {"ABA", "ABA", "ABA", 'A', new ItemStack(Items.QUARTZ), 'B', new ItemStack(Items.REDSTONE)});
		}
		
		if(Loader.isModLoaded(Util.MODID_CM3)) {
			GameRegistry.addShapedRecipe(new ResourceLocation("adiectamateria:cm3"), new ResourceLocation("adiectamateria:block"), new ItemStack(Item.getByNameOrId("compactmachines3:wallbreakable"), 1), new Object[] {"ABA", "BCB", "ABA", 'A', new ItemStack(Blocks.REDSTONE_BLOCK), 'B', new ItemStack(Blocks.DIAMOND_BLOCK), 'C', new ItemStack(Items.ENDER_PEARL)});
			GameRegistry.addShapedRecipe(new ResourceLocation("adiectamateria:cm3_0"), new ResourceLocation("adiectamateria:block"), new ItemStack(Item.getByNameOrId("compactmachines3:wallbreakable"), 1), new Object[] {"BAB", "ACA", "BAB", 'A', new ItemStack(Blocks.REDSTONE_BLOCK), 'B', new ItemStack(Blocks.DIAMOND_BLOCK), 'C', new ItemStack(Items.ENDER_PEARL)});
			GameRegistry.addShapedRecipe(new ResourceLocation("adiectamateria:cm3_1"), new ResourceLocation("adiectamateria:block"), new ItemStack(Item.getByNameOrId("compactmachines3:machine"), 1, 0), new Object[] {"AAA", "ABA", "AAA", 'A', new ItemStack(Item.getByNameOrId("compactmachines3:wallbreakable")), 'B', new ItemStack(Blocks.REDSTONE_BLOCK)});
			GameRegistry.addShapedRecipe(new ResourceLocation("adiectamateria:cm3_2"), new ResourceLocation("adiectamateria:block"), new ItemStack(Item.getByNameOrId("compactmachines3:machine"), 1, 1), new Object[] {"AAA", "ABA", "AAA", 'A', new ItemStack(Item.getByNameOrId("compactmachines3:wallbreakable")), 'B', new ItemStack(Item.getByNameOrId("compactmachines3:machine"), 1, 0)});
			GameRegistry.addShapedRecipe(new ResourceLocation("adiectamateria:cm3_3"), new ResourceLocation("adiectamateria:block"), new ItemStack(Item.getByNameOrId("compactmachines3:machine"), 1, 2), new Object[] {"AAA", "ABA", "AAA", 'A', new ItemStack(Item.getByNameOrId("compactmachines3:wallbreakable")), 'B', new ItemStack(Item.getByNameOrId("compactmachines3:machine"), 1, 1)});
			GameRegistry.addShapedRecipe(new ResourceLocation("adiectamateria:cm3_4"), new ResourceLocation("adiectamateria:block"), new ItemStack(Item.getByNameOrId("compactmachines3:machine"), 1, 3), new Object[] {"AAA", "ABA", "AAA", 'A', new ItemStack(Item.getByNameOrId("compactmachines3:wallbreakable")), 'B', new ItemStack(Item.getByNameOrId("compactmachines3:machine"), 1, 2)});
			GameRegistry.addShapedRecipe(new ResourceLocation("adiectamateria:cm3_5"), new ResourceLocation("adiectamateria:block"), new ItemStack(Item.getByNameOrId("compactmachines3:machine"), 1, 4), new Object[] {"AAA", "ABA", "AAA", 'A', new ItemStack(Item.getByNameOrId("compactmachines3:wallbreakable")), 'B', new ItemStack(Item.getByNameOrId("compactmachines3:machine"), 1, 3)});
			GameRegistry.addShapedRecipe(new ResourceLocation("adiectamateria:cm3_6"), new ResourceLocation("adiectamateria:block"), new ItemStack(Item.getByNameOrId("compactmachines3:machine"), 1, 5), new Object[] {"AAA", "ABA", "AAA", 'A', new ItemStack(Item.getByNameOrId("compactmachines3:wallbreakable")), 'B', new ItemStack(Item.getByNameOrId("compactmachines3:machine"), 1, 4)});
		}
		
		if(Loader.isModLoaded(Util.MODID_TC)) {
			GameRegistry.addShapedRecipe(new ResourceLocation("adiectamateria:tf"), new ResourceLocation("adiectamateria:item"), new ItemStack(Items.SKULL, 1, 1), new Object[] {"AAA", "ABA", "AAA", 'A', new ItemStack(Item.getByNameOrId("tconstruct:materials"), 1, 17), 'B', new ItemStack(Items.SKULL, 1, 0)});
			GameRegistry.addShapedRecipe(new ResourceLocation("adiectamateria:tf"), new ResourceLocation("adiectamateria:item"), new ItemStack(Items.NETHER_STAR, 1, 0), new Object[] {"AAA", "AAA", "AAA", 'A', new ItemStack(Item.getByNameOrId("tconstruct:materials"), 1, 17)});
			GameRegistry.addSmelting(new ItemStack(Items.BONE, 1, 0), new ItemStack(Item.getByNameOrId("tconstruct:materials"), 1, 17), 0.7F);
		}
		
		if(Loader.isModLoaded(Util.MODID_TC6)) {
			GameRegistry.addShapedRecipe(new ResourceLocation("adiectamateria:tc6"), new ResourceLocation("adiectamateria:item"), new ItemStack(Item.getByNameOrId("thaumcraft:primordial_pearl"), 1, 0), new Object[] {"AAA", "ABA", "AAA", 'B', new ItemStack(Items.ENDER_PEARL, 1, 0), 'A', new ItemStack(Items.NETHER_STAR, 1, 0)});
		}
		
		if(Loader.isModLoaded(Util.MODID_TF)) {
			GameRegistry.addSmelting(new ItemStack(Items.BLAZE_ROD, 1, 0), new ItemStack(Item.getByNameOrId("thermalfoundation:material"), 1, 2050), 0.7F);
			GameRegistry.addSmelting(new ItemStack(Item.getByNameOrId("thermalfoundation:material"), 1, 2050), new ItemStack(Item.getByNameOrId("thermalfoundation:material"), 1, 2052), 0.7F);
			GameRegistry.addSmelting(new ItemStack(Item.getByNameOrId("thermalfoundation:material"), 1, 2052), new ItemStack(Item.getByNameOrId("thermalfoundation:material"), 1, 2048), 0.7F);
		}
		
		if(Loader.isModLoaded(Util.MODID_AV) && Loader.isModLoaded(Util.MODID_TF)) {
			GameRegistry.addShapelessRecipe(new ResourceLocation("adiectamateria:av1"), new ResourceLocation("adiectamateria:item"), new ItemStack(Item.getByNameOrId("avaritia:singularity"), 1, 12), new Ingredient[] {Ingredient.fromStacks(new ItemStack(Item.getByNameOrId("avaritia:singularity"), 1, 1)), Ingredient.fromStacks(new ItemStack(Item.getByNameOrId("avaritia:singularity"), 1, 3))});
			GameRegistry.addShapelessRecipe(new ResourceLocation("adiectamateria:av1_0"), new ResourceLocation("adiectamateria:item"), new ItemStack(Item.getByNameOrId("avaritia:singularity"), 1, 13), new Ingredient[] {Ingredient.fromStacks(new ItemStack(Item.getByNameOrId("avaritia:singularity"), 1, 1)), Ingredient.fromStacks(new ItemStack(Item.getByNameOrId("thermalfoundation:storage"), 1, 6))});
			GameRegistry.addShapelessRecipe(new ResourceLocation("adiectamateria:av1_1"), new ResourceLocation("adiectamateria:item"), new ItemStack(Item.getByNameOrId("avaritia:singularity"), 1, 14), new Ingredient[] {Ingredient.fromStacks(new ItemStack(Item.getByNameOrId("avaritia:singularity"), 1, 1)), Ingredient.fromStacks(new ItemStack(Item.getByNameOrId("thermalfoundation:storage"), 1, 7))});
			GameRegistry.addShapedRecipe(new ResourceLocation("adiectamateria:av1_2"), new ResourceLocation("adiectamateria:item"), new ItemStack(Item.getByNameOrId("avaritia:ultimate_stew"), 1), new Object[] {"A", "B", 'A', new ItemStack(Objects.ITEM_GOD_JUICE), 'B', new ItemStack(Items.CAULDRON)});
		}
		
		if(Loader.isModLoaded(Util.MODID_JM)) {
			GameRegistry.addShapedRecipe(new ResourceLocation("adiectamateria:jm1"), new ResourceLocation("adiectamateria:item"), new ItemStack(Items.DIAMOND), new Object[] {"AAA", "AAA", "AAA", 'A', new ItemStack(Item.getByNameOrId("jjmeteor:blue_meteor_powder"), 1)});
			GameRegistry.addShapedRecipe(new ResourceLocation("adiectamateria:jm1_0"), new ResourceLocation("adiectamateria:item"), new ItemStack(Items.DIAMOND), new Object[] {"AAA", "AAA", "AAA", 'A', new ItemStack(Item.getByNameOrId("jjmeteor:red_meteor_powder"), 1)});
		}
	}
}
