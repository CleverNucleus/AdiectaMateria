package clevernucleus.adiectamateria.util;

import java.util.ArrayList;
import java.util.List;

import clevernucleus.adiectamateria.Objects;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * @name AdiectaMateria
 * @author CleverNucleus
 * @license Apache 2.0
 */
public class CraftingHandler {
	
	public static final List<Item> MEAT = new ArrayList<Item>();
	public static final Item[] meat_types = new Item[] {Items.PORKCHOP, Items.COOKED_PORKCHOP, Items.FISH, Items.COOKED_FISH, Items.BEEF, Items.COOKED_BEEF, Items.CHICKEN, Items.COOKED_CHICKEN, Items.MUTTON, Items.COOKED_MUTTON, Items.RABBIT, Items.COOKED_RABBIT, Items.ROTTEN_FLESH};
	
	private static String var0;
	private static String var1;
	
	/**
	 * Adds a shapeless recipe that cycles through one instance of every dye / metadata in the game.
	 * @param par0 set to 0 if this is the only recipe producing the same output, otherwise increment this by 1 per recipe.
	 * @param par1 the output.
	 * @param par2 the output quantity.
	 * @param par3 the input (not the dye).
	 * @param par4 the input (the dye).
	 */
	public static void addDyeRecipe(int par0, Item par1, int par2, Item par3, Item par4) {
		for(int var = 0; var < 16; var++) {
			
			var0 = Util.MODID + ":" + par1.getUnlocalizedName().substring(5) + "_" + var;
			var1 = Util.MODID + ":item";
			
			GameRegistry.addShapelessRecipe(new ResourceLocation(var0), new ResourceLocation(var1), new ItemStack(par1, par2, var), new Ingredient[] {Ingredient.fromItem(par3), Ingredient.fromStacks(new ItemStack(par4, 1, var))});
		}
	}
	
	/**
	 * Adds a shapeless recipe that cycles through one instance of every meat in the game.
	 * @param par0 set to 0 if this is the only recipe producing the same output, otherwise increment this by 1 per recipe.
	 * @param par1 the output.
	 * @param par2 the output quantity.
	 * @param par3 the input.
	 */
	public static void addMeatRecipe(int par0, Item par1, int par2, Item par3) {
		for(Item var : meat_types) {
			MEAT.add(var);
		}
		
		for(Item var : MEAT) {
			
			var0 = Util.MODID + ":" + par1.getUnlocalizedName().substring(5) + var.getUnlocalizedName().substring(5);
			var1 = Util.MODID + ":item";
			
			GameRegistry.addShapelessRecipe(new ResourceLocation(var0), new ResourceLocation(var1), new ItemStack(par1, par2), new Ingredient[] {Ingredient.fromItem(var), Ingredient.fromItem(par3)});
		}
	}
	
	public static void addShapedRecipe(int par0, String par1, Item par2, int par3, Item par4) {
		
		var0 = Util.MODID + ":" + par2.getUnlocalizedName().substring(5) + par0;
		var1 = Util.MODID + ":item";
		
		GameRegistry.addShapedRecipe(new ResourceLocation(var0), new ResourceLocation(var1), new ItemStack(par2, par3), new Object[] {par1, 'A', new ItemStack(par4)});
	}
	
	public static void addShapedRecipe(int par0, String par1, Item par2, int par3, Item par4, Item par5) {
		
		var0 = Util.MODID + ":" + par2.getUnlocalizedName().substring(5) + par0;
		var1 = Util.MODID + ":item";
		
		GameRegistry.addShapedRecipe(new ResourceLocation(var0), new ResourceLocation(var1), new ItemStack(par2, par3), new Object[] {par1, 'A', new ItemStack(par4), 'B', new ItemStack(par5)});
	}
	
	public static void addShapedRecipe(int par0, String par1, Item par2, int par3, Item par4, Item par5, Item par6) {
		
		var0 = Util.MODID + ":" + par2.getUnlocalizedName().substring(5) + par0;
		var1 = Util.MODID + ":item";
		
		GameRegistry.addShapedRecipe(new ResourceLocation(var0), new ResourceLocation(var1), new ItemStack(par2, par3), new Object[] {par1, 'A', new ItemStack(par4), 'B', new ItemStack(par5), 'C', new ItemStack(par6)});
	}
	
	public static void addShapedRecipe(int par0, String par1, String par2, Item par3, int par4, Item par5) {
		
		var0 = Util.MODID + ":" + par3.getUnlocalizedName().substring(5) + par0;
		var1 = Util.MODID + ":item";
		
		GameRegistry.addShapedRecipe(new ResourceLocation(var0), new ResourceLocation(var1), new ItemStack(par3, par4), new Object[] {par1, par2, 'A', new ItemStack(par5)});
	}
	
	public static void addShapedRecipe(int par0, String par1, String par2, Item par3, int par4, Item par5, Item par6) {
		
		var0 = Util.MODID + ":" + par3.getUnlocalizedName().substring(5) + par0;
		var1 = Util.MODID + ":item";
		
		GameRegistry.addShapedRecipe(new ResourceLocation(var0), new ResourceLocation(var1), new ItemStack(par3, par4), new Object[] {par1, par2, 'A', new ItemStack(par5), 'B', new ItemStack(par6)});
	}
	
	public static void addShapedRecipe(int par0, String par1, String par2, Item par3, int par4, Item par5, Item par6, Item par7) {
		
		var0 = Util.MODID + ":" + par3.getUnlocalizedName().substring(5) + par0;
		var1 = Util.MODID + ":item";
		
		GameRegistry.addShapedRecipe(new ResourceLocation(var0), new ResourceLocation(var1), new ItemStack(par3, par4), new Object[] {par1, par2, 'A', new ItemStack(par5), 'B', new ItemStack(par6), 'C', new ItemStack(par7)});
	}
	
	public static void addShapedRecipe(int par0, String par1, String par2, Item par3, int par4, Item par5, Item par6, Item par7, Item par8) {
		
		var0 = Util.MODID + ":" + par3.getUnlocalizedName().substring(5) + par0;
		var1 = Util.MODID + ":item";
		
		GameRegistry.addShapedRecipe(new ResourceLocation(var0), new ResourceLocation(var1), new ItemStack(par3, par4), new Object[] {par1, par2, 'A', new ItemStack(par5), 'B', new ItemStack(par6), 'C', new ItemStack(par7), 'D', new ItemStack(par8)});
	}
	
	public static void addShapedRecipe(int par0, String par1, String par2, Item par3, int par4, Item par5, Item par6, Item par7, Item par8, Item par9) {
		
		var0 = Util.MODID + ":" + par3.getUnlocalizedName().substring(5) + par0;
		var1 = Util.MODID + ":item";
		
		GameRegistry.addShapedRecipe(new ResourceLocation(var0), new ResourceLocation(var1), new ItemStack(par3, par4), new Object[] {par1, par2, 'A', new ItemStack(par5), 'B', new ItemStack(par6), 'C', new ItemStack(par7), 'D', new ItemStack(par8), 'E', new ItemStack(par9)});
	}
	
	public static void addShapedRecipe(int par0, String par1, String par2, Item par3, int par4, Item par5, Item par6, Item par7, Item par8, Item par9, Item par10) {
		
		var0 = Util.MODID + ":" + par3.getUnlocalizedName().substring(5) + par0;
		var1 = Util.MODID + ":item";
		
		GameRegistry.addShapedRecipe(new ResourceLocation(var0), new ResourceLocation(var1), new ItemStack(par3, par4), new Object[] {par1, par2, 'A', new ItemStack(par5), 'B', new ItemStack(par6), 'C', new ItemStack(par7), 'D', new ItemStack(par8), 'E', new ItemStack(par9), 'F', new ItemStack(par10)});
	}
	
	public static void addShapedRecipe(int par0, String par1, String par2, String par3, Item par4, int par5, Item par6) {
		
		var0 = Util.MODID + ":" + par4.getUnlocalizedName().substring(5) + par0;
		var1 = Util.MODID + ":item";
		
		GameRegistry.addShapedRecipe(new ResourceLocation(var0), new ResourceLocation(var1), new ItemStack(par4, par5), new Object[] {par1, par2, par3, 'A', new ItemStack(par6)});
	}
	
	public static void addShapedRecipe(int par0, String par1, String par2, String par3, Item par4, int par5, Item par6, Item par7) {
		
		var0 = Util.MODID + ":" + par4.getUnlocalizedName().substring(5) + par0;
		var1 = Util.MODID + ":item";
		
		GameRegistry.addShapedRecipe(new ResourceLocation(var0), new ResourceLocation(var1), new ItemStack(par4, par5), new Object[] {par1, par2, par3, 'A', new ItemStack(par6), 'B', new ItemStack(par7)});
	}
	
	public static void addShapedRecipe(int par0, String par1, String par2, String par3, Block par4, int par5, Block par6, Item par7) {
		
		var0 = Util.MODID + ":" + par4.getUnlocalizedName().substring(5) + par0;
		var1 = Util.MODID + ":block";
		
		GameRegistry.addShapedRecipe(new ResourceLocation(var0), new ResourceLocation(var1), new ItemStack(par4, par5), new Object[] {par1, par2, par3, 'A', new ItemStack(par6), 'B', new ItemStack(par7)});
	}
	
	public static void addShapedRecipe(int par0, String par1, String par2, String par3, Item par4, int par5, Item par6, Item par7, Item par8) {
		
		var0 = Util.MODID + ":" + par4.getUnlocalizedName().substring(5) + par0;
		var1 = Util.MODID + ":item";
		
		GameRegistry.addShapedRecipe(new ResourceLocation(var0), new ResourceLocation(var1), new ItemStack(par4, par5), new Object[] {par1, par2, par3, 'A', new ItemStack(par6), 'B', new ItemStack(par7), 'C', new ItemStack(par8)});
	}
	
	public static void addShapedRecipe(int par0, String par1, String par2, String par3, Block par4, int par5, Item par6, Item par7, Item par8) {
		
		var0 = Util.MODID + ":" + par4.getUnlocalizedName().substring(5) + par0;
		var1 = Util.MODID + ":block";
		
		GameRegistry.addShapedRecipe(new ResourceLocation(var0), new ResourceLocation(var1), new ItemStack(par4, par5), new Object[] {par1, par2, par3, 'A', new ItemStack(par6), 'B', new ItemStack(par7), 'C', new ItemStack(par8)});
	}
	
	public static void addShapedRecipe(int par0, String par1, String par2, String par3, Item par4, int par5, Block par6, Item par7, Item par8) {
		
		var0 = Util.MODID + ":" + par4.getUnlocalizedName().substring(5) + par0;
		var1 = Util.MODID + ":item";
		
		GameRegistry.addShapedRecipe(new ResourceLocation(var0), new ResourceLocation(var1), new ItemStack(par4, par5), new Object[] {par1, par2, par3, 'A', new ItemStack(par6), 'B', new ItemStack(par7), 'C', new ItemStack(par8)});
	}
	
	public static void addShapedRecipe(int par0, String par1, String par2, String par3, Item par4, int par5, Item par6, Block par7, Item par8) {
		
		var0 = Util.MODID + ":" + par4.getUnlocalizedName().substring(5) + par0;
		var1 = Util.MODID + ":item";
		
		GameRegistry.addShapedRecipe(new ResourceLocation(var0), new ResourceLocation(var1), new ItemStack(par4, par5), new Object[] {par1, par2, par3, 'A', new ItemStack(par6), 'B', new ItemStack(par7), 'C', new ItemStack(par8)});
	}
	
	public static void addShapedRecipe(int par0, String par1, String par2, String par3, Item par4, int par5, Item par6, Item par7, Item par8, Item par9) {
		
		var0 = Util.MODID + ":" + par4.getUnlocalizedName().substring(5) + par0;
		var1 = Util.MODID + ":item";
		
		GameRegistry.addShapedRecipe(new ResourceLocation(var0), new ResourceLocation(var1), new ItemStack(par4, par5), new Object[] {par1, par2, par3, 'A', new ItemStack(par6), 'B', new ItemStack(par7), 'C', new ItemStack(par8), 'D', new ItemStack(par9)});
	}
	
	public static void addShapedRecipe(int par0, String par1, String par2, String par3, Item par4, int par5, Item par6, Item par7, Item par8, Item par9, Item par10) {
		
		var0 = Util.MODID + ":" + par4.getUnlocalizedName().substring(5) + par0;
		var1 = Util.MODID + ":item";
		
		GameRegistry.addShapedRecipe(new ResourceLocation(var0), new ResourceLocation(var1), new ItemStack(par4, par5), new Object[] {par1, par2, par3, 'A', new ItemStack(par6), 'B', new ItemStack(par7), 'C', new ItemStack(par8), 'D', new ItemStack(par9), 'E', new ItemStack(par10)});
	}
	
	public static void addShapedRecipe(int par0, String par1, String par2, String par3, Item par4, int par5, Item par6, Item par7, Item par8, Item par9, Item par10, Item par11) {
		
		var0 = Util.MODID + ":" + par4.getUnlocalizedName().substring(5) + par0;
		var1 = Util.MODID + ":item";
		
		GameRegistry.addShapedRecipe(new ResourceLocation(var0), new ResourceLocation(var1), new ItemStack(par4, par5), new Object[] {par1, par2, par3, 'A', new ItemStack(par6), 'B', new ItemStack(par7), 'C', new ItemStack(par8), 'D', new ItemStack(par9), 'E', new ItemStack(par10), 'F', new ItemStack(par11)});
	}
	
	public static void addShapedRecipe(int par0, String par1, String par2, String par3, Item par4, int par5, Item par6, Item par7, Item par8, Item par9, Item par10, Item par11, Item par12) {
		
		var0 = Util.MODID + ":" + par4.getUnlocalizedName().substring(5) + par0;
		var1 = Util.MODID + ":item";
		
		GameRegistry.addShapedRecipe(new ResourceLocation(var0), new ResourceLocation(var1), new ItemStack(par4, par5), new Object[] {par1, par2, par3, 'A', new ItemStack(par6), 'B', new ItemStack(par7), 'C', new ItemStack(par8), 'D', new ItemStack(par9), 'E', new ItemStack(par10), 'F', new ItemStack(par11), 'G', new ItemStack(par12)});
	}
	
	public static void addShapedRecipe(int par0, String par1, String par2, String par3, Item par4, int par5, Item par6, Item par7, Item par8, Item par9, Item par10, Item par11, Item par12, Item par13) {
		
		var0 = Util.MODID + ":" + par4.getUnlocalizedName().substring(5) + par0;
		var1 = Util.MODID + ":item";
		
		GameRegistry.addShapedRecipe(new ResourceLocation(var0), new ResourceLocation(var1), new ItemStack(par4, par5), new Object[] {par1, par2, par3, 'A', new ItemStack(par6), 'B', new ItemStack(par7), 'C', new ItemStack(par8), 'D', new ItemStack(par9), 'E', new ItemStack(par10), 'F', new ItemStack(par11), 'G', new ItemStack(par12), 'H', new ItemStack(par13)});
	}
	
	public static void addShapedRecipe(int par0, String par1, String par2, String par3, Item par4, int par5, Item par6, Item par7, Item par8, Item par9, Item par10, Item par11, Item par12, Item par13, Item par14) {
		
		var0 = Util.MODID + ":" + par4.getUnlocalizedName().substring(5) + par0;
		var1 = Util.MODID + ":item";
		
		GameRegistry.addShapedRecipe(new ResourceLocation(var0), new ResourceLocation(var1), new ItemStack(par4, par5), new Object[] {par1, par2, par3, 'A', new ItemStack(par6), 'B', new ItemStack(par7), 'C', new ItemStack(par8), 'D', new ItemStack(par9), 'E', new ItemStack(par10), 'F', new ItemStack(par11), 'G', new ItemStack(par12), 'H', new ItemStack(par13), 'I', new ItemStack(par14)});
	}
	
	/**
	 * Adds a shapeless crafting recipe.
	 * @param par0 set to 0 if this is the only recipe producing the same output, otherwise increment by 1 per recipe.
	 * @param par1 the output.
	 * @param par2 the output quantity.
	 * @param par3 the input.
	 */
	public static void addShapelessRecipe(int par0, Item par1, int par2, Item par3) {
		
		var0 = Util.MODID + ":" + par1.getUnlocalizedName().substring(5) + par0;
		var1 = Util.MODID + ":item";
		
		GameRegistry.addShapelessRecipe(new ResourceLocation(var0), new ResourceLocation(var1), new ItemStack(par1, par2), new Ingredient[] {Ingredient.fromItem(par3)});
	}
	
	/**
	 * Adds a shapeless crafting recipe.
	 * @param par0 set to 0 if this is the only recipe producing the same output, otherwise increment by 1 per recipe.
	 * @param par1 the output.
	 * @param par2 the output quantity.
	 * @param par3 the output metadata.
	 * @param par4 the input.
	 */
	public static void addShapelessRecipe(int par0, Item par1, int par2, int par3, Item par4) {
		
		var0 = Util.MODID + ":" + par1.getUnlocalizedName().substring(5) + par0;
		var1 = Util.MODID + ":item";
		
		GameRegistry.addShapelessRecipe(new ResourceLocation(var0), new ResourceLocation(var1), new ItemStack(par1, par2, par3), new Ingredient[] {Ingredient.fromItem(par4)});
	}
	
	/**
	 * Adds a shapeless crafting recipe.
	 * @param par0 set to 0 if this is the only recipe producing the same output, otherwise increment by 1 per recipe.
	 * @param par1 the output.
	 * @param par2 the output quantity.
	 * @param par3 ... the inputs.
	 */
	public static void addShapelessRecipe(int par0, Item par1, int par2, Item par3, Item par4) {
		
		var0 = Util.MODID + ":" + par1.getUnlocalizedName().substring(5) + par0;
		var1 = Util.MODID + ":item";
		
		GameRegistry.addShapelessRecipe(new ResourceLocation(var0), new ResourceLocation(var1), new ItemStack(par1, par2), new Ingredient[] {Ingredient.fromItem(par3), Ingredient.fromItem(par4)});
	}
	
	/**
	 * Adds a shapeless crafting recipe.
	 * @param par0 set to 0 if this is the only recipe producing the same output, otherwise increment by 1 per recipe.
	 * @param par1 the output.
	 * @param par2 the output quantity.
	 * @param par3 the output metadata.
	 * @param par4 ... the inputs.
	 */
	public static void addShapelessRecipe(int par0, Item par1, int par2, int par3, Item par4, Item par5) {
		
		var0 = Util.MODID + ":" + par1.getUnlocalizedName().substring(5) + par0;
		var1 = Util.MODID + ":item";
		
		GameRegistry.addShapelessRecipe(new ResourceLocation(var0), new ResourceLocation(var1), new ItemStack(par1, par2, par3), new Ingredient[] {Ingredient.fromItem(par4), Ingredient.fromItem(par5)});
	}
	
	/**
	 * Adds a shapeless crafting recipe.
	 * @param par0 set to 0 if this is the only recipe producing the same output, otherwise increment by 1 per recipe.
	 * @param par1 the output.
	 * @param par2 the output quantity.
	 * @param par3 ... the inputs.
	 */
	public static void addShapelessRecipe(int par0, Item par1, int par2, Item par3, Item par4, Item par5) {
		
		var0 = Util.MODID + ":" + par1.getUnlocalizedName().substring(5) + par0;
		var1 = Util.MODID + ":item";
		
		GameRegistry.addShapelessRecipe(new ResourceLocation(var0), new ResourceLocation(var1), new ItemStack(par1, par2), new Ingredient[] {Ingredient.fromItem(par3), Ingredient.fromItem(par4), Ingredient.fromItem(par5)});
	}
	
	/**
	 * Adds a shapeless crafting recipe.
	 * @param par0 set to 0 if this is the only recipe producing the same output, otherwise increment by 1 per recipe.
	 * @param par1 the output.
	 * @param par2 the output quantity.
	 * @param par3 the output metadata.
	 * @param par4 ... the inputs.
	 */
	public static void addShapelessRecipe(int par0, Item par1, int par2, int par3, Item par4, Item par5, Item par6) {
		
		var0 = Util.MODID + ":" + par1.getUnlocalizedName().substring(5) + par0;
		var1 = Util.MODID + ":item";
		
		GameRegistry.addShapelessRecipe(new ResourceLocation(var0), new ResourceLocation(var1), new ItemStack(par1, par2, par3), new Ingredient[] {Ingredient.fromItem(par4), Ingredient.fromItem(par5), Ingredient.fromItem(par6)});
	}
	
	/**
	 * Adds a shapeless crafting recipe.
	 * @param par0 set to 0 if this is the only recipe producing the same output, otherwise increment by 1 per recipe.
	 * @param par1 the output.
	 * @param par2 the output quantity.
	 * @param par3 ... the inputs.
	 */
	public static void addShapelessRecipe(int par0, Item par1, int par2, Item par3, Item par4, Item par5, Item par6) {
		
		var0 = Util.MODID + ":" + par1.getUnlocalizedName().substring(5) + par0;
		var1 = Util.MODID + ":item";
		
		GameRegistry.addShapelessRecipe(new ResourceLocation(var0), new ResourceLocation(var1), new ItemStack(par1, par2), new Ingredient[] {Ingredient.fromItem(par3), Ingredient.fromItem(par4), Ingredient.fromItem(par5), Ingredient.fromItem(par6)});
	}
	
	/**
	 * Adds a shapeless crafting recipe.
	 * @param par0 set to 0 if this is the only recipe producing the same output, otherwise increment by 1 per recipe.
	 * @param par1 the output.
	 * @param par2 the output quantity.
	 * @param par3 the output metadata.
	 * @param par4 ... the inputs.
	 */
	public static void addShapelessRecipe(int par0, Item par1, int par2, int par3, Item par4, Item par5, Item par6, Item par7) {
		
		var0 = Util.MODID + ":" + par1.getUnlocalizedName().substring(5) + par0;
		var1 = Util.MODID + ":item";
		
		GameRegistry.addShapelessRecipe(new ResourceLocation(var0), new ResourceLocation(var1), new ItemStack(par1, par2, par3), new Ingredient[] {Ingredient.fromItem(par4), Ingredient.fromItem(par5), Ingredient.fromItem(par6), Ingredient.fromItem(par7)});
	}
	
	/**
	 * Adds a shapeless crafting recipe.
	 * @param par0 set to 0 if this is the only recipe producing the same output, otherwise increment by 1 per recipe.
	 * @param par1 the output.
	 * @param par2 the output quantity.
	 * @param par3 ... the inputs.
	 */
	public static void addShapelessRecipe(int par0, Block par1, int par2, Item par3) {
		
		var0 = Util.MODID + ":" + par1.getUnlocalizedName().substring(5) + par0;
		var1 = Util.MODID + ":block";
		
		GameRegistry.addShapelessRecipe(new ResourceLocation(var0), new ResourceLocation(var1), new ItemStack(par1, par2), new Ingredient[] {Ingredient.fromItem(par3)});
	}
	
	/**
	 * Adds a shapeless crafting recipe.
	 * @param par0 set to 0 if this is the only recipe producing the same output, otherwise increment by 1 per recipe.
	 * @param par1 the output.
	 * @param par2 the output quantity.
	 * @param par3 the output metadata.
	 * @param par4 ... the inputs.
	 */
	public static void addShapelessRecipe(int par0, Block par1, int par2, int par3, Item par4) {
		
		var0 = Util.MODID + ":" + par1.getUnlocalizedName().substring(5) + par0;
		var1 = Util.MODID + ":block";
		
		GameRegistry.addShapelessRecipe(new ResourceLocation(var0), new ResourceLocation(var1), new ItemStack(par1, par2, par3), new Ingredient[] {Ingredient.fromItem(par4)});
	}
	
	/**
	 * Adds a shapeless crafting recipe.
	 * @param par0 set to 0 if this is the only recipe producing the same output, otherwise increment by 1 per recipe.
	 * @param par1 the output.
	 * @param par2 the output quantity.
	 * @param par3 ... the inputs.
	 */
	public static void addShapelessRecipe(int par0, Block par1, int par2, Item par3, Item par4) {
		
		var0 = Util.MODID + ":" + par1.getUnlocalizedName().substring(5) + par0;
		var1 = Util.MODID + ":block";
		
		GameRegistry.addShapelessRecipe(new ResourceLocation(var0), new ResourceLocation(var1), new ItemStack(par1, par2), new Ingredient[] {Ingredient.fromItem(par3), Ingredient.fromItem(par4)});
	}
	
	/**
	 * Adds a shapeless crafting recipe.
	 * @param par0 set to 0 if this is the only recipe producing the same output, otherwise increment by 1 per recipe.
	 * @param par1 the output.
	 * @param par2 the output quantity.
	 * @param par3 the output metadata.
	 * @param par4 ... the inputs.
	 */
	public static void addShapelessRecipe(int par0, Block par1, int par2, int par3, Item par4, Item par5) {
		
		var0 = Util.MODID + ":" + par1.getUnlocalizedName().substring(5) + par0;
		var1 = Util.MODID + ":block";
		
		GameRegistry.addShapelessRecipe(new ResourceLocation(var0), new ResourceLocation(var1), new ItemStack(par1, par2, par3), new Ingredient[] {Ingredient.fromItem(par4), Ingredient.fromItem(par5)});
	}
	
	/**
	 * Adds a shapeless crafting recipe.
	 * @param par0 set to 0 if this is the only recipe producing the same output, otherwise increment by 1 per recipe.
	 * @param par1 the output.
	 * @param par2 the output quantity.
	 * @param par3 ... the inputs.
	 */
	public static void addShapelessRecipe(int par0, Block par1, int par2, Item par3, Item par4, Item par5) {
		
		var0 = Util.MODID + ":" + par1.getUnlocalizedName().substring(5) + par0;
		var1 = Util.MODID + ":block";
		
		GameRegistry.addShapelessRecipe(new ResourceLocation(var0), new ResourceLocation(var1), new ItemStack(par1, par2), new Ingredient[] {Ingredient.fromItem(par3), Ingredient.fromItem(par4), Ingredient.fromItem(par5)});
	}
	
	/**
	 * Adds a shapeless crafting recipe.
	 * @param par0 set to 0 if this is the only recipe producing the same output, otherwise increment by 1 per recipe.
	 * @param par1 the output.
	 * @param par2 the output quantity.
	 * @param par3 the output metadata.
	 * @param par4 ... the inputs.
	 */
	public static void addShapelessRecipe(int par0, Block par1, int par2, int par3, Item par4, Item par5, Item par6) {
		
		var0 = Util.MODID + ":" + par1.getUnlocalizedName().substring(5) + par0;
		var1 = Util.MODID + ":block";
		
		GameRegistry.addShapelessRecipe(new ResourceLocation(var0), new ResourceLocation(var1), new ItemStack(par1, par2, par3), new Ingredient[] {Ingredient.fromItem(par4), Ingredient.fromItem(par5), Ingredient.fromItem(par6)});
	}
	
	/**
	 * Adds a shapeless crafting recipe.
	 * @param par0 set to 0 if this is the only recipe producing the same output, otherwise increment by 1 per recipe.
	 * @param par1 the output.
	 * @param par2 the output quantity.
	 * @param par3 ... the inputs.
	 */
	public static void addShapelessRecipe(int par0, Block par1, int par2, Item par3, Item par4, Item par5, Item par6) {
		
		var0 = Util.MODID + ":" + par1.getUnlocalizedName().substring(5) + par0;
		var1 = Util.MODID + ":block";
		
		GameRegistry.addShapelessRecipe(new ResourceLocation(var0), new ResourceLocation(var1), new ItemStack(par1, par2), new Ingredient[] {Ingredient.fromItem(par3), Ingredient.fromItem(par4), Ingredient.fromItem(par5), Ingredient.fromItem(par6)});
	}
	
	/**
	 * Adds a shapeless crafting recipe.
	 * @param par0 set to 0 if this is the only recipe producing the same output, otherwise increment by 1 per recipe.
	 * @param par1 the output.
	 * @param par2 the output quantity.
	 * @param par3 the output metadata.
	 * @param par4 ... the inputs.
	 */
	public static void addShapelessRecipe(int par0, Block par1, int par2, int par3, Item par4, Item par5, Item par6, Item par7) {
		
		var0 = Util.MODID + ":" + par1.getUnlocalizedName().substring(5) + par0;
		var1 = Util.MODID + ":block";
		
		GameRegistry.addShapelessRecipe(new ResourceLocation(var0), new ResourceLocation(var1), new ItemStack(par1, par2, par3), new Ingredient[] {Ingredient.fromItem(par4), Ingredient.fromItem(par5), Ingredient.fromItem(par6), Ingredient.fromItem(par7)});
	}
	
	/**
	 * Adds a shapeless crafting recipe.
	 * @param par0 set to 0 if this is the only recipe producing the same output, otherwise increment by 1 per recipe.
	 * @param par1 the output.
	 * @param par2 the output quantity.
	 * @param par3 ... the inputs.
	 */
	public static void addShapelessRecipe(int par0, Item par1, int par2, Block par3, Block par4, Block par5) {
		
		var0 = Util.MODID + ":" + par1.getUnlocalizedName().substring(5) + par0;
		var1 = Util.MODID + ":item";
		
		GameRegistry.addShapelessRecipe(new ResourceLocation(var0), new ResourceLocation(var1), new ItemStack(par1, par2), new Ingredient[] {Ingredient.fromItem(ItemBlock.getItemFromBlock(par3)), Ingredient.fromItem(ItemBlock.getItemFromBlock(par4)), Ingredient.fromItem(ItemBlock.getItemFromBlock(par5))});
	}
	
	/**
	 * Adds a shapeless crafting recipe.
	 * @param par0 set to 0 if this is the only recipe producing the same output, otherwise increment by 1 per recipe.
	 * @param par1 the output.
	 * @param par2 the output quantity.
	 * @param par3 ... the inputs.
	 */
	public static void addShapelessRecipe(int par0, Block par1, int par2, Item par3, Block par4) {
		
		var0 = Util.MODID + ":" + par1.getUnlocalizedName().substring(5) + par0;
		var1 = Util.MODID + ":block";
		
		GameRegistry.addShapelessRecipe(new ResourceLocation(var0), new ResourceLocation(var1), new ItemStack(par1, par2), new Ingredient[] {Ingredient.fromItem(par3), Ingredient.fromItem(ItemBlock.getItemFromBlock(par4))});
	}
	
	/**
	 * Adds a smelting recipe.
	 * @param par0 the output.
	 * @param par1 the output quantity.
	 * @param par2 the input.
	 */
	public static void addSmeltingRecipe(Item par0, int par1, Item par2) {
		GameRegistry.addSmelting(new ItemStack(par2, par1, 0), new ItemStack(par0, 1, 0), 0.7F);
	}
}
