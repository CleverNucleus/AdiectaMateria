package clevernucleus.adiectamateria.common.util.recipes;

import clevernucleus.adiectamateria.common.item.ItemUnit;
import net.minecraft.block.BlockColored;
import net.minecraft.block.BlockNewLog;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockSand;
import net.minecraft.block.BlockSapling;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Recipes {
	public static void registerRecipes() {
		
		/** Smelting */
		Smelting.addSmeltingRecipe(Items.FLINT, ItemUnit.MELTY_FLINT);
		
		for(ItemStack var : Smelting.getSmeltingMap().keySet()) {
			GameRegistry.addSmelting(var, Smelting.getSmeltingMap().get(var), 0.3F);
		}
		
		/** Crafting */
		
		
		/** Transmuting */
		Transmuting.addSimpleRecipe(Blocks.GRAVEL, Items.FLINT);
		Transmuting.addSimpleRecipe(Blocks.RED_MUSHROOM, Blocks.BROWN_MUSHROOM);
		Transmuting.addSimpleRecipe(Blocks.BROWN_MUSHROOM, Blocks.RED_MUSHROOM);
		Transmuting.addSimpleRecipe(Blocks.BOOKSHELF, ItemUnit.BOOK);
		Transmuting.addSimpleRecipe(Blocks.ICE, Blocks.FLOWING_WATER);
		Transmuting.addSimpleRecipe(Blocks.OBSIDIAN, Blocks.FLOWING_LAVA);
		Transmuting.addSimpleRecipe(Blocks.DIRT, Blocks.GRASS);
		Transmuting.addSimpleRecipe(Blocks.GRASS, Blocks.DIRT);
		Transmuting.addSimpleRecipe(Blocks.STONE, Blocks.COBBLESTONE);
		Transmuting.addSimpleRecipe(Blocks.COBBLESTONE, Blocks.STONE);
		Transmuting.addSimpleRecipe(Blocks.SOUL_SAND, Blocks.NETHERRACK);
		Transmuting.addComplexRecipe(Blocks.SAPLING.getDefaultState().withProperty(BlockSapling.TYPE, BlockPlanks.EnumType.OAK), Blocks.SAPLING.getDefaultState().withProperty(BlockSapling.TYPE, BlockPlanks.EnumType.DARK_OAK));
		Transmuting.addComplexRecipe(Blocks.SAPLING.getDefaultState().withProperty(BlockSapling.TYPE, BlockPlanks.EnumType.DARK_OAK), Blocks.SAPLING.getDefaultState().withProperty(BlockSapling.TYPE, BlockPlanks.EnumType.SPRUCE));
		Transmuting.addComplexRecipe(Blocks.SAPLING.getDefaultState().withProperty(BlockSapling.TYPE, BlockPlanks.EnumType.SPRUCE), Blocks.SAPLING.getDefaultState().withProperty(BlockSapling.TYPE, BlockPlanks.EnumType.BIRCH));
		Transmuting.addComplexRecipe(Blocks.SAPLING.getDefaultState().withProperty(BlockSapling.TYPE, BlockPlanks.EnumType.BIRCH), Blocks.SAPLING.getDefaultState().withProperty(BlockSapling.TYPE, BlockPlanks.EnumType.JUNGLE));
		Transmuting.addComplexRecipe(Blocks.SAPLING.getDefaultState().withProperty(BlockSapling.TYPE, BlockPlanks.EnumType.JUNGLE), Blocks.SAPLING.getDefaultState().withProperty(BlockSapling.TYPE, BlockPlanks.EnumType.ACACIA));
		Transmuting.addComplexRecipe(Blocks.SAPLING.getDefaultState().withProperty(BlockSapling.TYPE, BlockPlanks.EnumType.ACACIA), Blocks.SAPLING.getDefaultState().withProperty(BlockSapling.TYPE, BlockPlanks.EnumType.OAK));
		Transmuting.addComplexRecipe(Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.OAK), Blocks.LOG2.getDefaultState().withProperty(BlockNewLog.VARIANT, BlockPlanks.EnumType.DARK_OAK));
		Transmuting.addComplexRecipe(Blocks.LOG2.getDefaultState().withProperty(BlockNewLog.VARIANT, BlockPlanks.EnumType.DARK_OAK), Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE));
		Transmuting.addComplexRecipe(Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.BIRCH));
		Transmuting.addComplexRecipe(Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.BIRCH), Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.JUNGLE));
		Transmuting.addComplexRecipe(Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.JUNGLE), Blocks.LOG2.getDefaultState().withProperty(BlockNewLog.VARIANT, BlockPlanks.EnumType.ACACIA));
		Transmuting.addComplexRecipe(Blocks.LOG2.getDefaultState().withProperty(BlockNewLog.VARIANT, BlockPlanks.EnumType.ACACIA), Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.OAK));
		Transmuting.addComplexRecipe(Blocks.PLANKS.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.OAK), Blocks.PLANKS.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.DARK_OAK));
		Transmuting.addComplexRecipe(Blocks.PLANKS.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.DARK_OAK), Blocks.PLANKS.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.SPRUCE));
		Transmuting.addComplexRecipe(Blocks.PLANKS.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.SPRUCE), Blocks.PLANKS.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.BIRCH));
		Transmuting.addComplexRecipe(Blocks.PLANKS.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.BIRCH), Blocks.PLANKS.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.JUNGLE));
		Transmuting.addComplexRecipe(Blocks.PLANKS.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.JUNGLE), Blocks.PLANKS.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.ACACIA));
		Transmuting.addComplexRecipe(Blocks.PLANKS.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.ACACIA), Blocks.PLANKS.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.OAK));
		Transmuting.addComplexRecipe(Blocks.NETHERRACK.getDefaultState(), Blocks.SAND.getDefaultState().withProperty(BlockSand.VARIANT, BlockSand.EnumType.RED_SAND));
		Transmuting.addComplexRecipe(Blocks.SAND.getDefaultState().withProperty(BlockSand.VARIANT, BlockSand.EnumType.RED_SAND), Blocks.SOUL_SAND.getDefaultState());
		Transmuting.addComplexRecipe(Blocks.SAND.getDefaultState().withProperty(BlockSand.VARIANT, BlockSand.EnumType.SAND), Blocks.GLASS.getDefaultState());
		Transmuting.addComplexRecipe(Blocks.GLASS.getDefaultState(), Blocks.SAND.getDefaultState().withProperty(BlockSand.VARIANT, BlockSand.EnumType.SAND));
		
		for(int var = 0; var < 16; var++) {
			Transmuting.addComplexRecipe(Blocks.WOOL.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.byMetadata(var)), Blocks.WOOL.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.byMetadata((var == 16 ? 0 : var + 1))));
		}
		
		for(int var = 0; var < 16; var++) {
			Transmuting.addComplexRecipe(Blocks.STAINED_GLASS.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.byMetadata(var)), Blocks.STAINED_GLASS.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.byMetadata((var == 16 ? 0 : var + 1))));
		}
		
		for(int var = 0; var < 16; var++) {
			Transmuting.addComplexRecipe(Blocks.STAINED_GLASS_PANE.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.byMetadata(var)), Blocks.STAINED_GLASS_PANE.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.byMetadata((var == 16 ? 0 : var + 1))));
		}
		
		for(int var = 0; var < 16; var++) {
			Transmuting.addComplexRecipe(Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.byMetadata(var)), Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.byMetadata((var == 16 ? 0 : var + 1))));
		}
		
		for(int var = 0; var < 16; var++) {
			Transmuting.addComplexRecipe(Blocks.CONCRETE_POWDER.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.byMetadata(var)), Blocks.CONCRETE_POWDER.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.byMetadata((var == 16 ? 0 : var + 1))));
		}

		for(int var = 0; var < 16; var++) {
			Transmuting.addComplexRecipe(Blocks.CONCRETE.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.byMetadata(var)), Blocks.CONCRETE.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.byMetadata((var == 16 ? 0 : var + 1))));
		}
		
		for(int var = 0; var < 16; var++) {
			Transmuting.addComplexRecipe(Blocks.CARPET.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.byMetadata(var)), Blocks.CARPET.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.byMetadata((var == 16 ? 0 : var + 1))));
		}
		
		Transmuting.addBlockException(Blocks.WOOL, 16);
		Transmuting.addBlockException(Blocks.STAINED_GLASS, 16);
		Transmuting.addBlockException(Blocks.STAINED_GLASS_PANE, 16);
		Transmuting.addBlockException(Blocks.STAINED_HARDENED_CLAY, 16);
		Transmuting.addBlockException(Blocks.CONCRETE_POWDER, 16);
		Transmuting.addBlockException(Blocks.CONCRETE, 16);
		Transmuting.addBlockException(Blocks.CARPET, 16);
		Transmuting.addBlockException(Blocks.PLANKS, 6);
		Transmuting.addBlockException(Blocks.LOG, 6);
		Transmuting.addBlockException(Blocks.SAPLING, 6);
	}
}
