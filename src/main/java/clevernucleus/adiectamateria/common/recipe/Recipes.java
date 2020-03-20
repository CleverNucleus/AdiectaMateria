package clevernucleus.adiectamateria.common.recipe;

import java.util.ArrayList;
import java.util.List;

import clevernucleus.adiectamateria.common.block.BlockInit;
import clevernucleus.adiectamateria.common.item.ItemInit;
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

public class Recipes {
	public static void registerRecipes() {
		
		
		Transmuting.add(new Component(BlockInit.RICE_BLOCK), new Component(BlockInit.PAPER_WALL, 12, 0));
		Transmuting.add(new Component(Blocks.BOOKSHELF), new Component(ItemInit.BOOK, 1, 0));
		Transmuting.add(new Component(Blocks.GRAVEL), new Component(Items.FLINT, 2, 0));
		Transmuting.add(new Component(Blocks.ICE), new Component(Blocks.FLOWING_WATER));
		Transmuting.add(new Component(Blocks.OBSIDIAN), new Component(Blocks.FLOWING_LAVA));
		Transmuting.add(new Component(Blocks.DIRT), new Component(Items.CLAY_BALL, 2, 0));
		Transmuting.add(new Component(Blocks.GRASS), new Component(Items.CLAY_BALL, 2, 0));
		Transmuting.add(new Component(Blocks.STONE).addProperty(BlockStone.VARIANT, BlockStone.EnumType.STONE), new Component(Blocks.COBBLESTONE));
		Transmuting.add(new Component(Blocks.COBBLESTONE), new Component(Blocks.STONE).addProperty(BlockStone.VARIANT, BlockStone.EnumType.STONE));
		Transmuting.add(new Component(Blocks.SAND).addProperty(BlockSand.VARIANT, BlockSand.EnumType.RED_SAND), new Component(Blocks.SOUL_SAND));
		Transmuting.add(new Component(Blocks.SOUL_SAND), new Component(Blocks.NETHERRACK));
		Transmuting.add(new Component(Blocks.NETHERRACK), new Component(Blocks.SAND).addProperty(BlockSand.VARIANT, BlockSand.EnumType.RED_SAND));
		Transmuting.add(new Component(Blocks.RED_MUSHROOM), new Component(Blocks.BROWN_MUSHROOM));
		Transmuting.add(new Component(Blocks.BROWN_MUSHROOM), new Component(Blocks.RED_MUSHROOM));
		Transmuting.add(new Component(Blocks.PUMPKIN), new Component(Blocks.LIT_PUMPKIN));
		Transmuting.add(new Component(Blocks.LIT_PUMPKIN), new Component(Blocks.PUMPKIN));
		Transmuting.add(new Component(Blocks.SAND).addProperty(BlockSand.VARIANT, BlockSand.EnumType.SAND), new Component(Blocks.GLASS));
		Transmuting.add(new Component(Blocks.GLASS), new Component(Blocks.SAND).addProperty(BlockSand.VARIANT, BlockSand.EnumType.SAND));
		Transmuting.add(new Component(Blocks.SAPLING).addProperty(BlockSapling.TYPE, BlockPlanks.EnumType.OAK), new Component(Blocks.SAPLING).addProperty(BlockSapling.TYPE, BlockPlanks.EnumType.DARK_OAK));
		Transmuting.add(new Component(Blocks.SAPLING).addProperty(BlockSapling.TYPE, BlockPlanks.EnumType.DARK_OAK), new Component(Blocks.SAPLING).addProperty(BlockSapling.TYPE, BlockPlanks.EnumType.SPRUCE));
		Transmuting.add(new Component(Blocks.SAPLING).addProperty(BlockSapling.TYPE, BlockPlanks.EnumType.SPRUCE), new Component(Blocks.SAPLING).addProperty(BlockSapling.TYPE, BlockPlanks.EnumType.BIRCH));
		Transmuting.add(new Component(Blocks.SAPLING).addProperty(BlockSapling.TYPE, BlockPlanks.EnumType.BIRCH), new Component(Blocks.SAPLING).addProperty(BlockSapling.TYPE, BlockPlanks.EnumType.JUNGLE));
		Transmuting.add(new Component(Blocks.SAPLING).addProperty(BlockSapling.TYPE, BlockPlanks.EnumType.JUNGLE), new Component(Blocks.SAPLING).addProperty(BlockSapling.TYPE, BlockPlanks.EnumType.ACACIA));
		Transmuting.add(new Component(Blocks.SAPLING).addProperty(BlockSapling.TYPE, BlockPlanks.EnumType.ACACIA), new Component(Blocks.SAPLING).addProperty(BlockSapling.TYPE, BlockPlanks.EnumType.OAK));
		Transmuting.add(new Component(Blocks.LOG).addProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.OAK), new Component(Blocks.LOG2).addProperty(BlockNewLog.VARIANT, BlockPlanks.EnumType.DARK_OAK));
		Transmuting.add(new Component(Blocks.LOG2).addProperty(BlockNewLog.VARIANT, BlockPlanks.EnumType.DARK_OAK), new Component(Blocks.LOG).addProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE));
		Transmuting.add(new Component(Blocks.LOG).addProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE), new Component(Blocks.LOG).addProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.BIRCH));
		Transmuting.add(new Component(Blocks.LOG).addProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.BIRCH), new Component(Blocks.LOG).addProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.JUNGLE));
		Transmuting.add(new Component(Blocks.LOG).addProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.JUNGLE), new Component(Blocks.LOG2).addProperty(BlockNewLog.VARIANT, BlockPlanks.EnumType.ACACIA));
		Transmuting.add(new Component(Blocks.LOG2).addProperty(BlockNewLog.VARIANT, BlockPlanks.EnumType.ACACIA), new Component(Blocks.LOG).addProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.OAK));
		Transmuting.add(new Component(Blocks.PLANKS).addProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.OAK), new Component(Blocks.PLANKS).addProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.DARK_OAK));
		Transmuting.add(new Component(Blocks.PLANKS).addProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.DARK_OAK), new Component(Blocks.PLANKS).addProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.SPRUCE));
		Transmuting.add(new Component(Blocks.PLANKS).addProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.SPRUCE), new Component(Blocks.PLANKS).addProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.BIRCH));
		Transmuting.add(new Component(Blocks.PLANKS).addProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.BIRCH), new Component(Blocks.PLANKS).addProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.JUNGLE));
		Transmuting.add(new Component(Blocks.PLANKS).addProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.JUNGLE), new Component(Blocks.PLANKS).addProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.ACACIA));
		Transmuting.add(new Component(Blocks.PLANKS).addProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.ACACIA), new Component(Blocks.PLANKS).addProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.OAK));
		Transmuting.add(new Component(Blocks.STONE).addProperty(BlockStone.VARIANT, BlockStone.EnumType.ANDESITE), new Component(Blocks.STONE).addProperty(BlockStone.VARIANT, BlockStone.EnumType.DIORITE));
		Transmuting.add(new Component(Blocks.STONE).addProperty(BlockStone.VARIANT, BlockStone.EnumType.DIORITE), new Component(Blocks.STONE).addProperty(BlockStone.VARIANT, BlockStone.EnumType.GRANITE));
		Transmuting.add(new Component(Blocks.STONE).addProperty(BlockStone.VARIANT, BlockStone.EnumType.GRANITE), new Component(Blocks.STONE).addProperty(BlockStone.VARIANT, BlockStone.EnumType.ANDESITE));
		Transmuting.add(new Component(Blocks.STONE).addProperty(BlockStone.VARIANT, BlockStone.EnumType.ANDESITE_SMOOTH), new Component(Blocks.STONE).addProperty(BlockStone.VARIANT, BlockStone.EnumType.DIORITE_SMOOTH));
		Transmuting.add(new Component(Blocks.STONE).addProperty(BlockStone.VARIANT, BlockStone.EnumType.DIORITE_SMOOTH), new Component(Blocks.STONE).addProperty(BlockStone.VARIANT, BlockStone.EnumType.GRANITE_SMOOTH));
		Transmuting.add(new Component(Blocks.STONE).addProperty(BlockStone.VARIANT, BlockStone.EnumType.GRANITE_SMOOTH), new Component(Blocks.STONE).addProperty(BlockStone.VARIANT, BlockStone.EnumType.ANDESITE_SMOOTH));
		
		for(int var = 0; var < 16; var++) {
			Transmuting.add(new Component(Blocks.WOOL).addProperty(BlockColored.COLOR, EnumDyeColor.byMetadata(var)), new Component(Blocks.WOOL).addProperty(BlockColored.COLOR, EnumDyeColor.byMetadata((var == 15 ? 0 : var + 1))));
		}
		
		for(int var = 0; var < 16; var++) {
			Transmuting.add(new Component(Blocks.STAINED_GLASS).addProperty(BlockColored.COLOR, EnumDyeColor.byMetadata(var)), new Component(Blocks.STAINED_GLASS).addProperty(BlockColored.COLOR, EnumDyeColor.byMetadata((var == 15 ? 0 : var + 1))));
		}
		
		for(int var = 0; var < 16; var++) {
			Transmuting.add(new Component(Blocks.STAINED_GLASS_PANE).addProperty(BlockColored.COLOR, EnumDyeColor.byMetadata(var)), new Component(Blocks.STAINED_GLASS_PANE).addProperty(BlockColored.COLOR, EnumDyeColor.byMetadata((var == 15 ? 0 : var + 1))));
		}
		
		for(int var = 0; var < 16; var++) {
			Transmuting.add(new Component(Blocks.STAINED_HARDENED_CLAY).addProperty(BlockColored.COLOR, EnumDyeColor.byMetadata(var)), new Component(Blocks.STAINED_HARDENED_CLAY).addProperty(BlockColored.COLOR, EnumDyeColor.byMetadata((var == 15 ? 0 : var + 1))));
		}
		
		for(int var = 0; var < 16; var++) {
			Transmuting.add(new Component(Blocks.CONCRETE_POWDER).addProperty(BlockColored.COLOR, EnumDyeColor.byMetadata(var)), new Component(Blocks.CONCRETE_POWDER).addProperty(BlockColored.COLOR, EnumDyeColor.byMetadata((var == 15 ? 0 : var + 1))));
		}
		
		for(int var = 0; var < 16; var++) {
			Transmuting.add(new Component(Blocks.CONCRETE).addProperty(BlockColored.COLOR, EnumDyeColor.byMetadata(var)), new Component(Blocks.CONCRETE).addProperty(BlockColored.COLOR, EnumDyeColor.byMetadata((var == 15 ? 0 : var + 1))));
		}
		
		for(int var = 0; var < 16; var++) {
			Transmuting.add(new Component(Blocks.CARPET).addProperty(BlockColored.COLOR, EnumDyeColor.byMetadata(var)), new Component(Blocks.CARPET).addProperty(BlockColored.COLOR, EnumDyeColor.byMetadata((var == 15 ? 0 : var + 1))));
		}
	}
}
