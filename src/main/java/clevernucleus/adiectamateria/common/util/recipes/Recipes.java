package clevernucleus.adiectamateria.common.util.recipes;

import clevernucleus.adiectamateria.common.block.BlockInit;
import clevernucleus.adiectamateria.common.item.ItemInit;
import clevernucleus.adiectamateria.common.util.Component;
import clevernucleus.adiectamateria.common.util.interfaces.IConstants;
import net.minecraft.block.BlockColored;
import net.minecraft.block.BlockNewLog;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockSand;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.BlockStone;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Loader;

public class Recipes {
	public static void registerRecipes() {
		
		/** Smelting */
		Smelting.addRecipe(new ItemStack(Items.FLINT), new ItemStack(ItemInit.MELTY_FLINT));
		Smelting.addRecipe(new ItemStack(Items.GOLD_NUGGET), new ItemStack(Items.GHAST_TEAR));
		Smelting.addRecipe(new ItemStack(ItemInit.RICE), new ItemStack(ItemInit.RICE_COOKED));
		Smelting.addRecipe(new ItemStack(Items.ROTTEN_FLESH), new ItemStack(Items.LEATHER));
		Smelting.addRecipe(new ItemStack(Blocks.ICE), new ItemStack(Items.SNOWBALL, 4));
		Smelting.addRecipe(new ItemStack(Blocks.DIRT), new ItemStack(BlockInit.MUD_BRICK));
		
		if(Loader.isModLoaded(IConstants.MODID_TC)) {
			Smelting.addRecipe(new ItemStack(Items.BONE), new ItemStack(Item.getByNameOrId("tconstruct:materials"), 1, 17));
		}
		
		if(Loader.isModLoaded(IConstants.MODID_TF)) {
			Smelting.addRecipe(new ItemStack(Items.BLAZE_ROD), new ItemStack(Item.getByNameOrId("thermalfoundation:material"), 1, 2050));
			Smelting.addRecipe(new ItemStack(Item.getByNameOrId("thermalfoundation:material"), 1, 2050), new ItemStack(Item.getByNameOrId("thermalfoundation:material"), 1, 2052));
			Smelting.addRecipe(new ItemStack(Item.getByNameOrId("thermalfoundation:material"), 1, 2052), new ItemStack(Item.getByNameOrId("thermalfoundation:material"), 1, 2048));
		}
		
		/** Crafting */
		Crafting.addShapelessRecipe(0, new ItemStack(Items.FLINT, 1), new ItemStack(ItemInit.MELTY_FLINT));
		Crafting.addShapelessRecipe(0, new ItemStack(Items.FLINT, 2), new ItemStack(ItemInit.MELTY_FLINT), new ItemStack(Blocks.GRAVEL));
		Crafting.addShapelessRecipe(1, new ItemStack(Items.STRING, 3), new ItemStack(ItemInit.FLAX));
		Crafting.addShapelessRecipe(2, new ItemStack(Items.PAPER, 3), new ItemStack(ItemInit.PAPERY_SHEET));
		Crafting.addShapedRecipe(3, "AAA", "", "", new ItemStack(ItemInit.PAPERY_SHEET, 1), new ItemStack(ItemInit.RICE));
		Crafting.addShapedRecipe(4, "AAA", "AAA", "AAA", new ItemStack(ItemInit.ONIGIRI, 1), new ItemStack(ItemInit.RICE_COOKED));
		Crafting.addShapedRecipe(5, "AAB", " B ", "B  ", new ItemStack(ItemInit.GRAFTER, 1), new ItemStack(Items.FLINT), new ItemStack(Items.STICK));
		Crafting.addShapedRecipe(6, "ABA", "BCB", "ABA", new ItemStack(BlockInit.RICE_BLOCK, 1), new ItemStack(Items.STICK), new ItemStack(ItemInit.PAPERY_SHEET), new ItemStack(Items.STRING));
		Crafting.addShapedRecipe(6, "ABA", "BCB", "ABA", new ItemStack(BlockInit.RICE_BLOCK, 1), new ItemStack(ItemInit.PAPERY_SHEET), new ItemStack(Items.STICK), new ItemStack(Items.STRING));
		Crafting.addShapedRecipe(7, "AAA", "ABA", "AAA", new ItemStack(BlockInit.SAND_LAMP, 1), new ItemStack(Blocks.SAND, 1, 0), new ItemStack(ItemInit.MELTY_FLINT));
		Crafting.addShapedRecipe(8, "AA", "AA", "", new ItemStack(BlockInit.SAND_LAMP_BRICK, 4), new ItemStack(BlockInit.SAND_LAMP));
		Crafting.addShapedRecipe(9, "AAA", "AAA", "AAA", new ItemStack(Items.SKULL, 1, 0), new ItemStack(Items.BONE));
		Crafting.addShapedRecipe(10, "AAA", "AAA", "AAA", new ItemStack(Items.NETHER_STAR, 1), new ItemStack(Items.SKULL, 1, 1));
		Crafting.addShapelessRecipe(11, new ItemStack(Blocks.ICE, 1), new ItemStack(Items.WATER_BUCKET));
		Crafting.addShapelessRecipe(12, new ItemStack(Items.COAL, 2), new ItemStack(ItemInit.MELTY_FLINT), new ItemStack(ItemInit.MELTY_FLINT), new ItemStack(ItemInit.MELTY_FLINT));
		Crafting.addShapelessRecipe(13, new ItemStack(Items.REDSTONE, 2), new ItemStack(ItemInit.MELTY_FLINT), new ItemStack(Items.COAL), new ItemStack(Items.COAL));
		Crafting.addShapelessRecipe(14, new ItemStack(Items.GLOWSTONE_DUST, 2), new ItemStack(ItemInit.MELTY_FLINT), new ItemStack(Items.REDSTONE), new ItemStack(Items.REDSTONE));
		Crafting.addShapelessRecipe(15, new ItemStack(Items.GUNPOWDER, 2), new ItemStack(ItemInit.MELTY_FLINT), new ItemStack(Items.REDSTONE), new ItemStack(Items.COAL));
		Crafting.addShapelessRecipe(16, new ItemStack(Items.BLAZE_POWDER, 2), new ItemStack(ItemInit.MELTY_FLINT), new ItemStack(Items.REDSTONE), new ItemStack(Items.GLOWSTONE_DUST));
		Crafting.addShapedRecipe(17, " A", "A ", "", new ItemStack(Items.BLAZE_ROD, 1), new ItemStack(Items.BLAZE_POWDER));
		Crafting.addShapedRecipe(18, " A ", "ABA", " A ", new ItemStack(Items.ENDER_PEARL, 1), new ItemStack(ItemInit.MELTY_FLINT), new ItemStack(Items.GHAST_TEAR));
		
		for(int var = 0; var < 16; var++) {
			Crafting.addShapelessRecipe(19, new ItemStack(Items.DYE, 6, var), new ItemStack(ItemInit.MELTY_FLINT), new ItemStack(Items.DYE, 1, var));
		}
		
		Crafting.addShapelessRecipe(20, new ItemStack(Items.SUGAR, 2), new ItemStack(ItemInit.MELTY_FLINT), new ItemStack(Items.REDSTONE), new ItemStack(Items.WHEAT_SEEDS));
		Crafting.addShapelessRecipe(20, new ItemStack(Items.SUGAR, 2), new ItemStack(ItemInit.MELTY_FLINT), new ItemStack(Items.REDSTONE), new ItemStack(Items.BEETROOT_SEEDS));
		Crafting.addShapelessRecipe(20, new ItemStack(Items.SUGAR, 2), new ItemStack(ItemInit.MELTY_FLINT), new ItemStack(Items.REDSTONE), new ItemStack(Items.MELON_SEEDS));
		Crafting.addShapelessRecipe(20, new ItemStack(Items.SUGAR, 2), new ItemStack(ItemInit.MELTY_FLINT), new ItemStack(Items.REDSTONE), new ItemStack(Items.PUMPKIN_SEEDS));
		Crafting.addShapelessRecipe(20, new ItemStack(Items.SUGAR, 2), new ItemStack(ItemInit.MELTY_FLINT), new ItemStack(Items.REDSTONE), new ItemStack(ItemInit.RICE));
		Crafting.addShapelessRecipe(20, new ItemStack(Items.SUGAR, 2), new ItemStack(ItemInit.MELTY_FLINT), new ItemStack(Items.REDSTONE), new ItemStack(ItemInit.FLAX));
		Crafting.addShapelessRecipe(21, new ItemStack(Items.QUARTZ, 2), new ItemStack(ItemInit.MELTY_FLINT), new ItemStack(Items.FLINT), new ItemStack(Items.FLINT));
		Crafting.addShapelessRecipe(22, new ItemStack(Items.SLIME_BALL, 2), new ItemStack(ItemInit.MELTY_FLINT), new ItemStack(Items.CLAY_BALL), new ItemStack(Items.SNOWBALL));
		Crafting.addShapelessRecipe(23, new ItemStack(Items.NAME_TAG, 1), new ItemStack(ItemInit.PAPERY_SHEET), new ItemStack(Items.STRING));
		Crafting.addShapedRecipe(24, "ABA", "BCB", "ABA", new ItemStack(ItemInit.INFINITE_LAVA, 1), new ItemStack(ItemInit.MELTY_FLINT), new ItemStack(Blocks.DIAMOND_BLOCK), new ItemStack(Items.LAVA_BUCKET));
		Crafting.addShapedRecipe(24, "ABA", "BCB", "ABA", new ItemStack(ItemInit.INFINITE_LAVA, 1), new ItemStack(Blocks.DIAMOND_BLOCK), new ItemStack(ItemInit.MELTY_FLINT), new ItemStack(Items.LAVA_BUCKET));
		Crafting.addShapedRecipe(25, "ABA", "BCB", "ABA", new ItemStack(ItemInit.INFINITE_WATER, 1), new ItemStack(ItemInit.MELTY_FLINT), new ItemStack(Blocks.DIAMOND_BLOCK), new ItemStack(Items.WATER_BUCKET));
		Crafting.addShapedRecipe(25, "ABA", "BCB", "ABA", new ItemStack(ItemInit.INFINITE_WATER, 1), new ItemStack(Blocks.DIAMOND_BLOCK), new ItemStack(ItemInit.MELTY_FLINT), new ItemStack(Items.WATER_BUCKET));
		Crafting.addShapelessRecipe(26, new ItemStack(Items.GOLD_INGOT, 3), new ItemStack(ItemInit.GOLD_BARS));
		Crafting.addShapelessRecipe(26, new ItemStack(ItemInit.GOLD_BARS), new ItemStack(Items.GOLD_INGOT), new ItemStack(Items.GOLD_INGOT), new ItemStack(Items.GOLD_INGOT));
		
		if(Loader.isModLoaded(IConstants.MODID_AE2) && Loader.isModLoaded(IConstants.MODID_TC)) {
			Crafting.addShapelessRecipe(27, new ItemStack(Item.getByNameOrId("appliedenergistics2:sky_stone_block"), 1), new ItemStack(Blocks.STONE, 1, 0), new ItemStack(Items.GLOWSTONE_DUST));
			Crafting.addShapelessRecipe(28, new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 0), new ItemStack(Items.QUARTZ), new ItemStack(Items.REDSTONE));
			Crafting.addShapelessRecipe(28, new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 1), new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 0), new ItemStack(Items.REDSTONE));
			Crafting.addShapelessRecipe(28, new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 7), new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 1), new ItemStack(Items.REDSTONE));
			Crafting.addShapelessRecipe(29, new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 23), new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 1), new ItemStack(Items.REDSTONE), new ItemStack(Items.IRON_INGOT));
			Crafting.addShapelessRecipe(29, new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 22), new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 1), new ItemStack(Items.REDSTONE), new ItemStack(Items.GOLD_INGOT));
			Crafting.addShapelessRecipe(29, new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 24), new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 1), new ItemStack(Items.REDSTONE), new ItemStack(Items.DIAMOND));
			Crafting.addShapedRecipe(30, "ABA", "ABA", "ABA", new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 10), new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 0), new ItemStack(Items.REDSTONE));
			Crafting.addShapedRecipe(30, "ABA", "ABA", "ABA", new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 12), new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 7), new ItemStack(Items.REDSTONE));
			Crafting.addShapedRecipe(30, "ABA", "ABA", "ABA", new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 11), new ItemStack(Items.QUARTZ), new ItemStack(Items.REDSTONE));
			Crafting.addShapedRecipe(31, "AAA", "ABA", "AAA", new ItemStack(Items.SKULL, 1, 1), new ItemStack(Item.getByNameOrId("tconstruct:materials"), 1, 17), new ItemStack(Items.SKULL, 1, 0));
		} else if(Loader.isModLoaded(IConstants.MODID_AE2) && !Loader.isModLoaded(IConstants.MODID_TC)) {
			Crafting.addShapelessRecipe(27, new ItemStack(Item.getByNameOrId("appliedenergistics2:sky_stone_block"), 1), new ItemStack(Blocks.STONE, 1, 0), new ItemStack(Items.GLOWSTONE_DUST));
			Crafting.addShapelessRecipe(28, new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 0), new ItemStack(Items.QUARTZ), new ItemStack(Items.REDSTONE));
			Crafting.addShapelessRecipe(28, new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 1), new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 0), new ItemStack(Items.REDSTONE));
			Crafting.addShapelessRecipe(28, new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 7), new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 1), new ItemStack(Items.REDSTONE));
			Crafting.addShapelessRecipe(29, new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 23), new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 1), new ItemStack(Items.REDSTONE), new ItemStack(Items.IRON_INGOT));
			Crafting.addShapelessRecipe(29, new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 22), new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 1), new ItemStack(Items.REDSTONE), new ItemStack(Items.GOLD_INGOT));
			Crafting.addShapelessRecipe(29, new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 24), new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 1), new ItemStack(Items.REDSTONE), new ItemStack(Items.DIAMOND));
			Crafting.addShapedRecipe(30, "ABA", "ABA", "ABA", new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 10), new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 0), new ItemStack(Items.REDSTONE));
			Crafting.addShapedRecipe(30, "ABA", "ABA", "ABA", new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 12), new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 7), new ItemStack(Items.REDSTONE));
			Crafting.addShapedRecipe(30, "ABA", "ABA", "ABA", new ItemStack(Item.getByNameOrId("appliedenergistics2:material"), 1, 11), new ItemStack(Items.QUARTZ), new ItemStack(Items.REDSTONE));
		} else if(!Loader.isModLoaded(IConstants.MODID_AE2) && Loader.isModLoaded(IConstants.MODID_TC)) {
			Crafting.addShapedRecipe(27, "AAA", "ABA", "AAA", new ItemStack(Items.SKULL, 1, 1), new ItemStack(Item.getByNameOrId("tconstruct:materials"), 1, 17), new ItemStack(Items.SKULL, 1, 0));
		}
		
		/** Transmuting */
		Transmuting.addRecipe(0, new Component(BlockInit.RICE_BLOCK), new Component(BlockInit.PAPER_WALL, 12, 0));
		Transmuting.addRecipe(1, new Component(Blocks.BOOKSHELF), new Component(ItemInit.BOOK, 1, 0));
		Transmuting.addRecipe(2, new Component(Blocks.GRAVEL), new Component(Items.FLINT, 2, 0));
		Transmuting.addRecipe(3, new Component(Blocks.ICE), new Component(Blocks.FLOWING_WATER));
		Transmuting.addRecipe(4, new Component(Blocks.OBSIDIAN), new Component(Blocks.FLOWING_LAVA));
		Transmuting.addRecipe(5, new Component(Blocks.DIRT), new Component(Items.CLAY_BALL, 2, 0));
		Transmuting.addRecipe(5, new Component(Blocks.GRASS), new Component(Items.CLAY_BALL, 2, 0));
		Transmuting.addRecipe(6, new Component(Blocks.STONE).addProperty(BlockStone.VARIANT, BlockStone.EnumType.STONE), new Component(Blocks.COBBLESTONE));
		Transmuting.addRecipe(6, new Component(Blocks.COBBLESTONE), new Component(Blocks.STONE).addProperty(BlockStone.VARIANT, BlockStone.EnumType.STONE));
		Transmuting.addRecipe(7, new Component(Blocks.SAND).addProperty(BlockSand.VARIANT, BlockSand.EnumType.RED_SAND), new Component(Blocks.SOUL_SAND));
		Transmuting.addRecipe(7, new Component(Blocks.SOUL_SAND), new Component(Blocks.NETHERRACK));
		Transmuting.addRecipe(7, new Component(Blocks.NETHERRACK), new Component(Blocks.SAND).addProperty(BlockSand.VARIANT, BlockSand.EnumType.RED_SAND));
		
		Transmuting.addRecipe(8, new Component(Blocks.RED_MUSHROOM), new Component(Blocks.BROWN_MUSHROOM));
		Transmuting.addRecipe(8, new Component(Blocks.BROWN_MUSHROOM), new Component(Blocks.RED_MUSHROOM));
		Transmuting.addRecipe(9, new Component(Blocks.PUMPKIN), new Component(Blocks.LIT_PUMPKIN));
		Transmuting.addRecipe(9, new Component(Blocks.LIT_PUMPKIN), new Component(Blocks.PUMPKIN));
		
		Transmuting.addRecipe(10, new Component(Blocks.SAND).addProperty(BlockSand.VARIANT, BlockSand.EnumType.SAND), new Component(Blocks.GLASS));
		Transmuting.addRecipe(10, new Component(Blocks.GLASS), new Component(Blocks.SAND).addProperty(BlockSand.VARIANT, BlockSand.EnumType.SAND));
		
		Transmuting.addRecipe(11, new Component(Blocks.SAPLING).addProperty(BlockSapling.TYPE, BlockPlanks.EnumType.OAK), new Component(Blocks.SAPLING).addProperty(BlockSapling.TYPE, BlockPlanks.EnumType.DARK_OAK));
		Transmuting.addRecipe(11, new Component(Blocks.SAPLING).addProperty(BlockSapling.TYPE, BlockPlanks.EnumType.DARK_OAK), new Component(Blocks.SAPLING).addProperty(BlockSapling.TYPE, BlockPlanks.EnumType.SPRUCE));
		Transmuting.addRecipe(11, new Component(Blocks.SAPLING).addProperty(BlockSapling.TYPE, BlockPlanks.EnumType.SPRUCE), new Component(Blocks.SAPLING).addProperty(BlockSapling.TYPE, BlockPlanks.EnumType.BIRCH));
		Transmuting.addRecipe(11, new Component(Blocks.SAPLING).addProperty(BlockSapling.TYPE, BlockPlanks.EnumType.BIRCH), new Component(Blocks.SAPLING).addProperty(BlockSapling.TYPE, BlockPlanks.EnumType.JUNGLE));
		Transmuting.addRecipe(11, new Component(Blocks.SAPLING).addProperty(BlockSapling.TYPE, BlockPlanks.EnumType.JUNGLE), new Component(Blocks.SAPLING).addProperty(BlockSapling.TYPE, BlockPlanks.EnumType.ACACIA));
		Transmuting.addRecipe(11, new Component(Blocks.SAPLING).addProperty(BlockSapling.TYPE, BlockPlanks.EnumType.ACACIA), new Component(Blocks.SAPLING).addProperty(BlockSapling.TYPE, BlockPlanks.EnumType.OAK));
		
		Transmuting.addRecipe(12, new Component(Blocks.LOG).addProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.OAK), new Component(Blocks.LOG2).addProperty(BlockNewLog.VARIANT, BlockPlanks.EnumType.DARK_OAK));
		Transmuting.addRecipe(12, new Component(Blocks.LOG2).addProperty(BlockNewLog.VARIANT, BlockPlanks.EnumType.DARK_OAK), new Component(Blocks.LOG).addProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE));
		Transmuting.addRecipe(12, new Component(Blocks.LOG).addProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), new Component(Blocks.LOG).addProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.BIRCH));
		Transmuting.addRecipe(12, new Component(Blocks.LOG).addProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.BIRCH), new Component(Blocks.LOG).addProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.JUNGLE));
		Transmuting.addRecipe(12, new Component(Blocks.LOG).addProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.JUNGLE), new Component(Blocks.LOG2).addProperty(BlockNewLog.VARIANT, BlockPlanks.EnumType.ACACIA));
		Transmuting.addRecipe(12, new Component(Blocks.LOG2).addProperty(BlockNewLog.VARIANT, BlockPlanks.EnumType.ACACIA), new Component(Blocks.LOG).addProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.OAK));
		
		Transmuting.addRecipe(13, new Component(Blocks.PLANKS).addProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.OAK), new Component(Blocks.PLANKS).addProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.DARK_OAK));
		Transmuting.addRecipe(13, new Component(Blocks.PLANKS).addProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.DARK_OAK), new Component(Blocks.PLANKS).addProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.SPRUCE));
		Transmuting.addRecipe(13, new Component(Blocks.PLANKS).addProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.SPRUCE), new Component(Blocks.PLANKS).addProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.BIRCH));
		Transmuting.addRecipe(13, new Component(Blocks.PLANKS).addProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.BIRCH), new Component(Blocks.PLANKS).addProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.JUNGLE));
		Transmuting.addRecipe(13, new Component(Blocks.PLANKS).addProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.JUNGLE), new Component(Blocks.PLANKS).addProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.ACACIA));
		Transmuting.addRecipe(13, new Component(Blocks.PLANKS).addProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.ACACIA), new Component(Blocks.PLANKS).addProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.OAK));
		
		for(int var = 0; var < 16; var++) {
			Transmuting.addRecipe(14, new Component(Blocks.WOOL).addProperty(BlockColored.COLOR, EnumDyeColor.byMetadata(var)), new Component(Blocks.WOOL).addProperty(BlockColored.COLOR, EnumDyeColor.byMetadata((var == 15 ? 0 : var + 1))));
		}
		
		for(int var = 0; var < 16; var++) {
			Transmuting.addRecipe(15, new Component(Blocks.STAINED_GLASS).addProperty(BlockColored.COLOR, EnumDyeColor.byMetadata(var)), new Component(Blocks.STAINED_GLASS).addProperty(BlockColored.COLOR, EnumDyeColor.byMetadata((var == 15 ? 0 : var + 1))));
		}
		
		for(int var = 0; var < 16; var++) {
			Transmuting.addRecipe(16, new Component(Blocks.STAINED_GLASS_PANE).addProperty(BlockColored.COLOR, EnumDyeColor.byMetadata(var)), new Component(Blocks.STAINED_GLASS_PANE).addProperty(BlockColored.COLOR, EnumDyeColor.byMetadata((var == 15 ? 0 : var + 1))));
		}
		
		for(int var = 0; var < 16; var++) {
			Transmuting.addRecipe(17, new Component(Blocks.STAINED_HARDENED_CLAY).addProperty(BlockColored.COLOR, EnumDyeColor.byMetadata(var)), new Component(Blocks.STAINED_HARDENED_CLAY).addProperty(BlockColored.COLOR, EnumDyeColor.byMetadata((var == 15 ? 0 : var + 1))));
		}
		
		for(int var = 0; var < 16; var++) {
			Transmuting.addRecipe(18, new Component(Blocks.CONCRETE_POWDER).addProperty(BlockColored.COLOR, EnumDyeColor.byMetadata(var)), new Component(Blocks.CONCRETE_POWDER).addProperty(BlockColored.COLOR, EnumDyeColor.byMetadata((var == 15 ? 0 : var + 1))));
		}
		
		for(int var = 0; var < 16; var++) {
			Transmuting.addRecipe(19, new Component(Blocks.CONCRETE).addProperty(BlockColored.COLOR, EnumDyeColor.byMetadata(var)), new Component(Blocks.CONCRETE).addProperty(BlockColored.COLOR, EnumDyeColor.byMetadata((var == 15 ? 0 : var + 1))));
		}
		
		for(int var = 0; var < 16; var++) {
			Transmuting.addRecipe(20, new Component(Blocks.CARPET).addProperty(BlockColored.COLOR, EnumDyeColor.byMetadata(var)), new Component(Blocks.CARPET).addProperty(BlockColored.COLOR, EnumDyeColor.byMetadata((var == 15 ? 0 : var + 1))));
		}
		
		Transmuting.addRecipe(21, new Component(Blocks.STONE).addProperty(BlockStone.VARIANT, BlockStone.EnumType.ANDESITE), new Component(Blocks.STONE).addProperty(BlockStone.VARIANT, BlockStone.EnumType.DIORITE));
		Transmuting.addRecipe(21, new Component(Blocks.STONE).addProperty(BlockStone.VARIANT, BlockStone.EnumType.DIORITE), new Component(Blocks.STONE).addProperty(BlockStone.VARIANT, BlockStone.EnumType.GRANITE));
		Transmuting.addRecipe(21, new Component(Blocks.STONE).addProperty(BlockStone.VARIANT, BlockStone.EnumType.GRANITE), new Component(Blocks.STONE).addProperty(BlockStone.VARIANT, BlockStone.EnumType.ANDESITE));
		Transmuting.addRecipe(22, new Component(Blocks.STONE).addProperty(BlockStone.VARIANT, BlockStone.EnumType.ANDESITE_SMOOTH), new Component(Blocks.STONE).addProperty(BlockStone.VARIANT, BlockStone.EnumType.DIORITE_SMOOTH));
		Transmuting.addRecipe(22, new Component(Blocks.STONE).addProperty(BlockStone.VARIANT, BlockStone.EnumType.DIORITE_SMOOTH), new Component(Blocks.STONE).addProperty(BlockStone.VARIANT, BlockStone.EnumType.GRANITE_SMOOTH));
		Transmuting.addRecipe(22, new Component(Blocks.STONE).addProperty(BlockStone.VARIANT, BlockStone.EnumType.GRANITE_SMOOTH), new Component(Blocks.STONE).addProperty(BlockStone.VARIANT, BlockStone.EnumType.ANDESITE_SMOOTH));
	}
}
