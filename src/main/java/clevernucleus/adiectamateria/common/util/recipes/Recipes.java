package clevernucleus.adiectamateria.common.util.recipes;

import clevernucleus.adiectamateria.common.block.BlockUnit;
import clevernucleus.adiectamateria.common.item.ItemUnit;
import clevernucleus.adiectamateria.common.util.Component;
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
import net.minecraft.item.ItemStack;

public class Recipes {
	public static void registerRecipes() {
		
		/** Smelting */
		Smelting.addRecipe(new ItemStack(Items.FLINT), new ItemStack(ItemUnit.MELTY_FLINT));
		Smelting.addRecipe(new ItemStack(ItemUnit.RICE), new ItemStack(ItemUnit.RICE_COOKED));
		
		/** Crafting */
		Crafting.addShapelessRecipe(0, new ItemStack(Items.FLINT, 1), new ItemStack(ItemUnit.MELTY_FLINT));
		Crafting.addShapelessRecipe(0, new ItemStack(Items.FLINT, 2), new ItemStack(ItemUnit.MELTY_FLINT), new ItemStack(Blocks.GRAVEL));
		
		Crafting.addShapedRecipe(1, "AAB", " B ", "B  ", new ItemStack(ItemUnit.RICE_GRAFTER, 1), new ItemStack(Items.FLINT), new ItemStack(Items.STICK));
		Crafting.addShapedRecipe(2, "AAA", "AAA", "AAA", new ItemStack(ItemUnit.ONIGIRI, 1), new ItemStack(ItemUnit.RICE_COOKED));
		Crafting.addShapedRecipe(3, "AAA", "", "", new ItemStack(ItemUnit.RICE_PAPER, 3), new ItemStack(ItemUnit.RICE));
		Crafting.addShapedRecipe(4, "ABA", "BCB", "ABA", new ItemStack(BlockUnit.RICE_BLOCK, 1), new ItemStack(Items.STICK), new ItemStack(ItemUnit.RICE_PAPER), new ItemStack(Items.STRING));
		Crafting.addShapedRecipe(4, "ABA", "BCB", "ABA", new ItemStack(BlockUnit.RICE_BLOCK, 1), new ItemStack(ItemUnit.RICE_PAPER), new ItemStack(Items.STICK), new ItemStack(Items.STRING));
		Crafting.addShapedRecipe(5, "AAA", "ABA", "AAA", new ItemStack(BlockUnit.SAND_LAMP, 1), new ItemStack(Blocks.SAND, 1, 0), new ItemStack(ItemUnit.MELTY_FLINT));
		Crafting.addShapedRecipe(6, "AA", "AA", "", new ItemStack(BlockUnit.SAND_LAMP_BRICK, 4), new ItemStack(BlockUnit.SAND_LAMP));
		
		/** Transmuting */
		Transmuting.addRecipe(0, new Component(BlockUnit.RICE_BLOCK), new Component(BlockUnit.PAPER_WALL, 12, 0));
		Transmuting.addRecipe(1, new Component(Blocks.BOOKSHELF), new Component(ItemUnit.BOOK, 1, 0));
		Transmuting.addRecipe(2, new Component(Blocks.GRAVEL), new Component(Items.FLINT, 1, 0));
		Transmuting.addRecipe(3, new Component(Blocks.ICE), new Component(Blocks.FLOWING_WATER));
		Transmuting.addRecipe(4, new Component(Blocks.OBSIDIAN), new Component(Blocks.FLOWING_LAVA));
		Transmuting.addRecipe(5, new Component(Blocks.DIRT), new Component(Blocks.GRASS));
		Transmuting.addRecipe(5, new Component(Blocks.GRASS), new Component(Blocks.DIRT));
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
	}
}
