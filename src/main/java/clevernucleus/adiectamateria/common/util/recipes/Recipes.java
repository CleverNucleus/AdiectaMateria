package clevernucleus.adiectamateria.common.util.recipes;

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
		
		/** Crafting */
		Crafting.addShapelessRecipe(0, new ItemStack(Items.FLINT, 1), new ItemStack(ItemUnit.MELTY_FLINT));
		Crafting.addShapelessRecipe(0, new ItemStack(Items.FLINT, 2), new ItemStack(ItemUnit.MELTY_FLINT), new ItemStack(Blocks.GRAVEL));
		
		Crafting.addShapedRecipe(1, "A", "B", "A", new ItemStack(Items.APPLE, 2), new ItemStack(Items.BLAZE_ROD), new ItemStack(Items.BOOK));
		Crafting.addShapelessRecipe(2, new ItemStack(Items.DYE, 12, 1), new ItemStack(ItemUnit.MELTY_FLINT), new ItemStack(Items.DYE, 1, 1));
		Crafting.addShapelessRecipe(3, new ItemStack(Items.DYE, 12, 4), new ItemStack(ItemUnit.MELTY_FLINT), new ItemStack(Items.DYE, 1, 4));
		
		/** Transmuting */
		
		Transmuting.addRecipe(0, new Component(Blocks.BOOKSHELF), new Component(ItemUnit.BOOK, 1, 0));
		Transmuting.addRecipe(1, new Component(Blocks.GRAVEL), new Component(Items.FLINT, 1, 0));
		Transmuting.addRecipe(2, new Component(Blocks.ICE), new Component(Blocks.FLOWING_WATER));
		Transmuting.addRecipe(3, new Component(Blocks.OBSIDIAN), new Component(Blocks.FLOWING_LAVA));
		Transmuting.addRecipe(4, new Component(Blocks.DIRT), new Component(Blocks.GRASS));
		Transmuting.addRecipe(4, new Component(Blocks.GRASS), new Component(Blocks.DIRT));
		Transmuting.addRecipe(5, new Component(Blocks.STONE).addProperty(BlockStone.VARIANT, BlockStone.EnumType.STONE), new Component(Blocks.COBBLESTONE));
		Transmuting.addRecipe(5, new Component(Blocks.COBBLESTONE), new Component(Blocks.STONE).addProperty(BlockStone.VARIANT, BlockStone.EnumType.STONE));
		Transmuting.addRecipe(6, new Component(Blocks.SAND).addProperty(BlockSand.VARIANT, BlockSand.EnumType.RED_SAND), new Component(Blocks.SOUL_SAND));
		Transmuting.addRecipe(6, new Component(Blocks.SOUL_SAND), new Component(Blocks.NETHERRACK));
		Transmuting.addRecipe(6, new Component(Blocks.NETHERRACK), new Component(Blocks.SAND).addProperty(BlockSand.VARIANT, BlockSand.EnumType.RED_SAND));
		
		Transmuting.addRecipe(7, new Component(Blocks.RED_MUSHROOM), new Component(Blocks.BROWN_MUSHROOM));
		Transmuting.addRecipe(7, new Component(Blocks.BROWN_MUSHROOM), new Component(Blocks.RED_MUSHROOM));
		Transmuting.addRecipe(8, new Component(Blocks.PUMPKIN), new Component(Blocks.LIT_PUMPKIN));
		Transmuting.addRecipe(8, new Component(Blocks.LIT_PUMPKIN), new Component(Blocks.PUMPKIN));
		
		Transmuting.addRecipe(9, new Component(Blocks.SAND).addProperty(BlockSand.VARIANT, BlockSand.EnumType.SAND), new Component(Blocks.GLASS));
		Transmuting.addRecipe(9, new Component(Blocks.GLASS), new Component(Blocks.SAND).addProperty(BlockSand.VARIANT, BlockSand.EnumType.SAND));
		
		Transmuting.addRecipe(10, new Component(Blocks.SAPLING).addProperty(BlockSapling.TYPE, BlockPlanks.EnumType.OAK), new Component(Blocks.SAPLING).addProperty(BlockSapling.TYPE, BlockPlanks.EnumType.DARK_OAK));
		Transmuting.addRecipe(10, new Component(Blocks.SAPLING).addProperty(BlockSapling.TYPE, BlockPlanks.EnumType.DARK_OAK), new Component(Blocks.SAPLING).addProperty(BlockSapling.TYPE, BlockPlanks.EnumType.SPRUCE));
		Transmuting.addRecipe(10, new Component(Blocks.SAPLING).addProperty(BlockSapling.TYPE, BlockPlanks.EnumType.SPRUCE), new Component(Blocks.SAPLING).addProperty(BlockSapling.TYPE, BlockPlanks.EnumType.BIRCH));
		Transmuting.addRecipe(10, new Component(Blocks.SAPLING).addProperty(BlockSapling.TYPE, BlockPlanks.EnumType.BIRCH), new Component(Blocks.SAPLING).addProperty(BlockSapling.TYPE, BlockPlanks.EnumType.JUNGLE));
		Transmuting.addRecipe(10, new Component(Blocks.SAPLING).addProperty(BlockSapling.TYPE, BlockPlanks.EnumType.JUNGLE), new Component(Blocks.SAPLING).addProperty(BlockSapling.TYPE, BlockPlanks.EnumType.ACACIA));
		Transmuting.addRecipe(10, new Component(Blocks.SAPLING).addProperty(BlockSapling.TYPE, BlockPlanks.EnumType.ACACIA), new Component(Blocks.SAPLING).addProperty(BlockSapling.TYPE, BlockPlanks.EnumType.OAK));
		
		Transmuting.addRecipe(11, new Component(Blocks.LOG).addProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.OAK), new Component(Blocks.LOG2).addProperty(BlockNewLog.VARIANT, BlockPlanks.EnumType.DARK_OAK));
		Transmuting.addRecipe(11, new Component(Blocks.LOG2).addProperty(BlockNewLog.VARIANT, BlockPlanks.EnumType.DARK_OAK), new Component(Blocks.LOG).addProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE));
		Transmuting.addRecipe(11, new Component(Blocks.LOG).addProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), new Component(Blocks.LOG).addProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.BIRCH));
		Transmuting.addRecipe(11, new Component(Blocks.LOG).addProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.BIRCH), new Component(Blocks.LOG).addProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.JUNGLE));
		Transmuting.addRecipe(11, new Component(Blocks.LOG).addProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.JUNGLE), new Component(Blocks.LOG2).addProperty(BlockNewLog.VARIANT, BlockPlanks.EnumType.ACACIA));
		Transmuting.addRecipe(11, new Component(Blocks.LOG2).addProperty(BlockNewLog.VARIANT, BlockPlanks.EnumType.ACACIA), new Component(Blocks.LOG).addProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.OAK));
		
		Transmuting.addRecipe(12, new Component(Blocks.PLANKS).addProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.OAK), new Component(Blocks.PLANKS).addProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.DARK_OAK));
		Transmuting.addRecipe(12, new Component(Blocks.PLANKS).addProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.DARK_OAK), new Component(Blocks.PLANKS).addProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.SPRUCE));
		Transmuting.addRecipe(12, new Component(Blocks.PLANKS).addProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.SPRUCE), new Component(Blocks.PLANKS).addProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.BIRCH));
		Transmuting.addRecipe(12, new Component(Blocks.PLANKS).addProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.BIRCH), new Component(Blocks.PLANKS).addProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.JUNGLE));
		Transmuting.addRecipe(12, new Component(Blocks.PLANKS).addProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.JUNGLE), new Component(Blocks.PLANKS).addProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.ACACIA));
		Transmuting.addRecipe(12, new Component(Blocks.PLANKS).addProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.ACACIA), new Component(Blocks.PLANKS).addProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.OAK));
		
		for(int var = 0; var < 16; var++) {
			Transmuting.addRecipe(13, new Component(Blocks.WOOL).addProperty(BlockColored.COLOR, EnumDyeColor.byMetadata(var)), new Component(Blocks.WOOL).addProperty(BlockColored.COLOR, EnumDyeColor.byMetadata((var == 15 ? 0 : var + 1))));
		}
		
		for(int var = 0; var < 16; var++) {
			Transmuting.addRecipe(14, new Component(Blocks.STAINED_GLASS).addProperty(BlockColored.COLOR, EnumDyeColor.byMetadata(var)), new Component(Blocks.STAINED_GLASS).addProperty(BlockColored.COLOR, EnumDyeColor.byMetadata((var == 15 ? 0 : var + 1))));
		}
		
		for(int var = 0; var < 16; var++) {
			Transmuting.addRecipe(15, new Component(Blocks.STAINED_GLASS_PANE).addProperty(BlockColored.COLOR, EnumDyeColor.byMetadata(var)), new Component(Blocks.STAINED_GLASS_PANE).addProperty(BlockColored.COLOR, EnumDyeColor.byMetadata((var == 15 ? 0 : var + 1))));
		}
		
		for(int var = 0; var < 16; var++) {
			Transmuting.addRecipe(16, new Component(Blocks.STAINED_HARDENED_CLAY).addProperty(BlockColored.COLOR, EnumDyeColor.byMetadata(var)), new Component(Blocks.STAINED_HARDENED_CLAY).addProperty(BlockColored.COLOR, EnumDyeColor.byMetadata((var == 15 ? 0 : var + 1))));
		}
		
		for(int var = 0; var < 16; var++) {
			Transmuting.addRecipe(17, new Component(Blocks.CONCRETE_POWDER).addProperty(BlockColored.COLOR, EnumDyeColor.byMetadata(var)), new Component(Blocks.CONCRETE_POWDER).addProperty(BlockColored.COLOR, EnumDyeColor.byMetadata((var == 15 ? 0 : var + 1))));
		}
		
		for(int var = 0; var < 16; var++) {
			Transmuting.addRecipe(18, new Component(Blocks.CONCRETE).addProperty(BlockColored.COLOR, EnumDyeColor.byMetadata(var)), new Component(Blocks.CONCRETE).addProperty(BlockColored.COLOR, EnumDyeColor.byMetadata((var == 15 ? 0 : var + 1))));
		}
		
		for(int var = 0; var < 16; var++) {
			Transmuting.addRecipe(19, new Component(Blocks.CARPET).addProperty(BlockColored.COLOR, EnumDyeColor.byMetadata(var)), new Component(Blocks.CARPET).addProperty(BlockColored.COLOR, EnumDyeColor.byMetadata((var == 15 ? 0 : var + 1))));
		}
	}
}
