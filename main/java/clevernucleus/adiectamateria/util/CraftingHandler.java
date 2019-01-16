package clevernucleus.adiectamateria.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import clevernucleus.adiectamateria.Objects;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.oredict.OreDictionary;

/**
 * @name AdiectaMateria
 * @author CleverNucleus
 * @license Apache 2.0
 */

public class CraftingHandler {
	
	public static final List<Item> MEAT = new ArrayList<Item>();
	public static final List<Item> IN_0 = new ArrayList<Item>();
	public static final List<Item> OUT_0 = new ArrayList<Item>();
	public static final List<Item> IN_1 = new ArrayList<Item>();
	public static final List<Item> OUT_1 = new ArrayList<Item>();
	public static final List<Block> IN_2 = new ArrayList<Block>();
	public static final List<Block> OUT_2 = new ArrayList<Block>();
	
	public static final Item[] meat = new Item[] {Items.porkchop, Items.cooked_porkchop, Items.fish, Items.cooked_fished, Items.beef, Items.cooked_beef, Items.chicken, Items.cooked_chicken, Items.rotten_flesh};
	public static final Item[] in_0 = new Item[] {Objects.ITEM_PULVIS_DUST, Items.coal, Items.gunpowder, Items.redstone, Items.glowstone_dust, Items.flint, Items.stick, Items.quartz, Items.clay_ball, Items.snowball, Items.slime_ball, Items.spider_eye, Items.sugar, Items.paper, Items.string, Items.leather};
	public static final Item[] out_0 = new Item[] {Items.coal, Items.gunpowder, Items.redstone, Items.glowstone_dust, Items.blaze_powder, Items.quartz, Items.bone, Items.clay_ball, Items.snowball, Items.slime_ball, Items.spider_eye, Items.ender_pearl, Items.paper, Items.string, Items.leather, Items.feather};
	public static final Item[] in_1 = new Item[] {Items.water_bucket, Items.lava_bucket, Items.gunpowder, Items.blaze_powder, Items.glowstone_dust, Items.redstone, Items.quartz};
	public static final Item[] out_1 = new Item[] {Objects.ITEM_INFINITE_WATER, Objects.ITEM_INFINITE_LAVA, Objects.ITEM_ORB_ELEC, Objects.ITEM_ORB_FIRE, Objects.ITEM_ORB_DAY, Objects.ITEM_ORB_NIGHT, Objects.ITEM_ORB_RAIN};
	public static final Block[] in_2 = new Block[] {Blocks.sand, Blocks.gravel, Blocks.dirt, Blocks.cobblestone, Blocks.netherrack, Blocks.obsidian, Blocks.soul_sand};
	public static final Block[] out_2 = new Block[] {Blocks.gravel, Blocks.dirt, Blocks.cobblestone, Blocks.netherrack, Blocks.obsidian, Blocks.soul_sand, Blocks.end_stone};
	
	public static void implementCraftingRecipes() {
		GameRegistry.addShapelessRecipe(new ItemStack(Items.flint, 1), new Object[] {Objects.ITEM_PULVIS_DUST});
		GameRegistry.addShapelessRecipe(new ItemStack(Objects.ITEM_GOD_JUICE, 1), new Object[] {Objects.ITEM_ALTERA_DUST, Items.apple, Items.bread, Items.beef, Items.porkchop, Items.potato, Items.carrot, Items.glass_bottle, Items.chicken});
		
		GameRegistry.addShapedRecipe(new ItemStack(Objects.ITEM_RYE_COOKED, 1), new Object[] {"AAA", "AAA", "AAA", 'A', Objects.ITEM_RYE_RAW});
		GameRegistry.addShapedRecipe(new ItemStack(Objects.ITEM_RICE_PAPER, 2), new Object[] {"AAA", 'A', Objects.ITEM_RICE_SEEDS});
		GameRegistry.addShapedRecipe(new ItemStack(Items.nether_star, 1), new Object[] {"AAA", "AAA", "AAA", 'A', new ItemStack(Items.skull, 1, 1)});

		GameRegistry.addShapedRecipe(new ItemStack(Objects.ITEM_GREATER_APPLE, 1), new Object[] {" A ", "ABA", " A ", 'A', Items.nether_star, 'B', Items.apple});
		GameRegistry.addShapedRecipe(new ItemStack(Objects.BLOCK_SAND_LAMP, 1), new Object[] {"AAA", "ABA", "AAA", 'A', Blocks.sand, 'B', Objects.ITEM_PULVIS_DUST});
		GameRegistry.addShapedRecipe(new ItemStack(Objects.BLOCK_RICE, 2), new Object[] {"ABA", "BCB", "ABA", 'A', Objects.ITEM_RICE_PAPER, 'B', Items.stick, 'C', Items.clay_ball});
		GameRegistry.addShapedRecipe(new ItemStack(Objects.BLOCK_RICE, 2), new Object[] {"BAB", "ACA", "BAB", 'A', Objects.ITEM_RICE_PAPER, 'B', Items.stick, 'C', Items.clay_ball});
		
		for(Item var0 : CraftingHandler.meat) {
			CraftingHandler.MEAT.add(var0);
		}
		
		for(Item var0 : CraftingHandler.in_0) {
			CraftingHandler.IN_0.add(var0);
		}
		
		for(Item var0 : CraftingHandler.out_0) {
			CraftingHandler.OUT_0.add(var0);
		}
		
		for(Item var0 : CraftingHandler.in_1) {
			CraftingHandler.IN_1.add(var0);
		}
		
		for(Item var0 : CraftingHandler.out_1) {
			CraftingHandler.OUT_1.add(var0);
		}
		
		for(Block var0 : CraftingHandler.in_2) {
			CraftingHandler.IN_2.add(var0);
		}
		
		for(Block var0 : CraftingHandler.out_2) {
			CraftingHandler.OUT_2.add(var0);
		}
		
		for(int var0 = 0; var0 < CraftingHandler.IN_0.size(); var0++) {
			Item itemIn = CraftingHandler.IN_0.get(var0);
			Item itemOut = CraftingHandler.OUT_0.get(var0);
			
			GameRegistry.addShapelessRecipe(new ItemStack(itemOut, 2), new Object[] {Objects.ITEM_PULVIS_DUST, itemIn});
		}
		
		for(int var0 = 0; var0 < CraftingHandler.IN_1.size(); var0++) {
			Item itemIn = CraftingHandler.IN_1.get(var0);
			Item itemOut = CraftingHandler.OUT_1.get(var0);
			
			GameRegistry.addShapedRecipe(new ItemStack(itemOut, 1), new Object[] {"ABA", "BCB", "ABA", 'A', Blocks.diamond_block, 'B', Objects.ITEM_ALTERA_DUST, 'C', itemIn});
			GameRegistry.addShapedRecipe(new ItemStack(itemOut, 1), new Object[] {"BAB", "ACA", "BAB", 'A', Blocks.diamond_block, 'B', Objects.ITEM_ALTERA_DUST, 'C', itemIn});
		}
		
		for(int var0 = 0; var0 < CraftingHandler.IN_2.size(); var0++) {
			Block blockIn = CraftingHandler.IN_2.get(var0);
			Block blockOut = CraftingHandler.OUT_2.get(var0);
			
			GameRegistry.addShapelessRecipe(new ItemStack(blockOut, 1), new Object[] {Objects.ITEM_PULVIS_DUST, blockIn});
		}
		
		for(int var0 = 0; var0 < 16; var0++) {
			GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, 12, var0), new Object[] {Objects.ITEM_PULVIS_DUST, new ItemStack(Items.dye, 1, var0)});
		}
	}
	
	public static void implementSmeltingRecipes() {
		GameRegistry.addSmelting(new ItemStack(Items.stick), new ItemStack(Items.blaze_rod), 0.3F);
		GameRegistry.addSmelting(new ItemStack(Items.rotten_flesh), new ItemStack(Items.leather), 0.3F);
		GameRegistry.addSmelting(new ItemStack(Items.flint), new ItemStack(Objects.ITEM_PULVIS_DUST), 0.3F);
		GameRegistry.addSmelting(new ItemStack(Objects.ITEM_PULVIS_DUST), new ItemStack(Objects.ITEM_ALTERA_DUST), 0.3F);
		GameRegistry.addSmelting(new ItemStack(Objects.ITEM_RICE_SEEDS), new ItemStack(Objects.ITEM_RYE_RAW), 0.3F);
	}
	
	public static void implementForeignModRecipes() {
		if(Loader.isModLoaded(Util.MODID_AE2)) {
			GameRegistry.addShapelessRecipe(new ItemStack(GameRegistry.findBlock(Util.MODID_AE2, "tile.BlockSkyStone"), 1, 0), new Object[] {Items.redstone, Items.glowstone_dust, Blocks.stone});
			GameRegistry.addShapelessRecipe(new ItemStack(GameRegistry.findItem(Util.MODID_AE2, "item.ItemMultiMaterial"), 1, 0), new Object[] {Items.quartz, Items.redstone, Items.glowstone_dust});
			GameRegistry.addShapelessRecipe(new ItemStack(GameRegistry.findItem(Util.MODID_AE2, "item.ItemMultiMaterial"), 1, 1), new Object[] {new ItemStack(GameRegistry.findItem(Util.MODID_AE2, "item.ItemMultiMaterial"), 1, 0), Items.redstone});
			GameRegistry.addShapelessRecipe(new ItemStack(GameRegistry.findItem(Util.MODID_AE2, "item.ItemMultiMaterial"), 1, 7), new Object[] {new ItemStack(GameRegistry.findItem(Util.MODID_AE2, "item.ItemMultiMaterial"), 1, 1), Items.redstone});
			GameRegistry.addShapelessRecipe(new ItemStack(GameRegistry.findItem(Util.MODID_AE2, "item.ItemMultiMaterial"), 1, 23), new Object[] {new ItemStack(GameRegistry.findItem(Util.MODID_AE2, "item.ItemMultiMaterial"), 1, 0), Items.redstone, Items.quartz});
			GameRegistry.addShapelessRecipe(new ItemStack(GameRegistry.findItem(Util.MODID_AE2, "item.ItemMultiMaterial"), 1, 22), new Object[] {new ItemStack(GameRegistry.findItem(Util.MODID_AE2, "item.ItemMultiMaterial"), 1, 0), Items.redstone, Items.gold_ingot});
			GameRegistry.addShapelessRecipe(new ItemStack(GameRegistry.findItem(Util.MODID_AE2, "item.ItemMultiMaterial"), 1, 24), new Object[] {new ItemStack(GameRegistry.findItem(Util.MODID_AE2, "item.ItemMultiMaterial"), 1, 0), Items.redstone, Items.diamond});
			GameRegistry.addShapelessRecipe(new ItemStack(GameRegistry.findItem(Util.MODID_AE2, "item.ItemMultiMaterial"), 1, 10), new Object[] {new ItemStack(GameRegistry.findItem(Util.MODID_AE2, "item.ItemMultiMaterial"), 1, 0), new ItemStack(GameRegistry.findItem(Util.MODID_AE2, "item.ItemMultiMaterial"), 1, 0)});
			GameRegistry.addShapelessRecipe(new ItemStack(GameRegistry.findItem(Util.MODID_AE2, "item.ItemMultiMaterial"), 1, 12), new Object[] {new ItemStack(GameRegistry.findItem(Util.MODID_AE2, "item.ItemMultiMaterial"), 1, 7), new ItemStack(GameRegistry.findItem(Util.MODID_AE2, "item.ItemMultiMaterial"), 1, 7)});
			GameRegistry.addShapelessRecipe(new ItemStack(GameRegistry.findItem(Util.MODID_AE2, "item.ItemMultiMaterial"), 1, 11), new Object[] {Items.quartz, Items.quartz});
		}
		
		if(Loader.isModLoaded(Util.MODID_TC)) {
			GameRegistry.addShapelessRecipe(new ItemStack(GameRegistry.findItem(Util.MODID_TC, "heartCanister"), 1, 3), new Object[] {new ItemStack(GameRegistry.findItem(Util.MODID_TC, "heartCanister"), 1, 1)});
			GameRegistry.addShapelessRecipe(new ItemStack(GameRegistry.findItem(Util.MODID_TC, "heartCanister"), 1, 6), new Object[] {new ItemStack(GameRegistry.findItem(Util.MODID_TC, "heartCanister"), 1, 5), new ItemStack(GameRegistry.findItem(Util.MODID_TC, "heartCanister"), 1, 4), Objects.ITEM_GREATER_APPLE});
			
			
			GameRegistry.addShapedRecipe(new ItemStack(Items.skull, 1, 0), new Object[] {"AAA", "AAA", "AAA", 'A', Items.bone});
			GameRegistry.addShapedRecipe(new ItemStack(Items.skull, 1, 1), new Object[] {"AAA", "ABA", "AAA", 'A', new ItemStack(GameRegistry.findItem(Util.MODID_TC, "materials"), 1, 8), 'B', new ItemStack(Items.skull, 1, 0)});
			GameRegistry.addShapedRecipe(new ItemStack(GameRegistry.findItem(Util.MODID_TC, "heartCanister"), 1, 5), new Object[] {"AAA", "AAA", "AAA", 'A', new ItemStack(GameRegistry.findItem(Util.MODID_TC, "heartCanister"), 1, 1)});
			
			GameRegistry.addSmelting(new ItemStack(Items.bone), new ItemStack(GameRegistry.findItem(Util.MODID_TC, "materials"), 1, 8), 0.3F);
		}
		
		if(Loader.isModLoaded(Util.MODID_TC4)) {
			GameRegistry.addShapedRecipe(new ItemStack(GameRegistry.findItem(Util.MODID_TC4, "ItemEldritchObject"), 1, 3), new Object[] {"AAA", "ABA", "AAA", 'A', Items.nether_star, 'B', new ItemStack(GameRegistry.findItem(Util.MODID_TC4, "ItemResource"), 1, 14)});
		}
		
		if(Loader.isModLoaded(Util.MODID_MFR)) {
			for(Item var0 : MEAT) {
				GameRegistry.addShapedRecipe(new ItemStack(GameRegistry.findItem(Util.MODID_MFR, "meat.ingot.raw"), 1, 0), new Object[] {"AAA", "AAA", "AAA", 'A', var0});
			}
			
			GameRegistry.addShapedRecipe(new ItemStack(GameRegistry.findItem(Util.MODID_MFR, "pinkslime"), 1, 0), new Object[] {"AAA", "ABA", "AAA", 'A', new ItemStack(Items.dye, 1, 9), 'B', Items.slime_ball});
		}
		
		if(Loader.isModLoaded(Util.MODID_TF)) {
			GameRegistry.addSmelting(Items.blaze_rod, new ItemStack(GameRegistry.findItem(Util.MODID_TF, "material"), 1, 1026), 0.3F);
			GameRegistry.addSmelting(new ItemStack(GameRegistry.findItem(Util.MODID_TF, "material"), 1, 1026), new ItemStack(GameRegistry.findItem(Util.MODID_TF, "material"), 1, 1028), 0.3F);
			GameRegistry.addSmelting(new ItemStack(GameRegistry.findItem(Util.MODID_TF, "material"), 1, 1028), new ItemStack(GameRegistry.findItem(Util.MODID_TF, "material"), 1, 1024), 0.3F);
		}
		
		if(Loader.isModLoaded(Util.MODID_AV)) {
			GameRegistry.addShapelessRecipe(new ItemStack(GameRegistry.findItem(Util.MODID_AV, "Ultimate_Stew"), 1, 0), new Object[] {new ItemStack(Items.cauldron, 1, 0), Objects.ITEM_GOD_JUICE});
		}
	}
}
