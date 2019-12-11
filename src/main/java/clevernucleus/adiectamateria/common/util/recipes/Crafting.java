package clevernucleus.adiectamateria.common.util.recipes;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import clevernucleus.adiectamateria.common.util.Recipe;
import clevernucleus.adiectamateria.common.util.interfaces.IConstants;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Crafting {
	public static enum Type {
		SHAPED("shaped"),
		SHAPELESS("shapeless"),
		MODDED("modded");
		
		private String key;
		
		Type(String par0) {
			this.key = par0;
		}
		
		public String getKey() {
			return key;
		}
	}
	
	private static final List<List<Recipe>> CRAFTING_LIST = new ArrayList<List<Recipe>>();
	
	/**
	 * Adds a shapeless recipe to the game and the mod registry.
	 * @param par0 recipe id, used to group recipes with the same id/output to the same registry list
	 * @param par1 recipe components, with the first component being the output
	 */
	public static void addShapelessRecipe(int par0, ItemStack ... par1) {
		if(par1.length > 1) {
			Ingredient[] var0 = new Ingredient[par1.length - 1];
			String var1 = IConstants.MODID + ":" + par1[0].getUnlocalizedName().substring(5) + "_" + par0;
			String var2 = IConstants.MODID + ":shapeless";
			
			for(int var = 1; var < par1.length; var++) {
				var0[var - 1] = Ingredient.fromStacks(par1[var]);
			}
			
			Recipe var3 = new Recipe(Type.SHAPELESS, par1);
			List<Recipe> var4 = new ArrayList<Recipe>();
			
			if(CRAFTING_LIST.size() >= (par0 + 1)) {
				var4 = CRAFTING_LIST.get(par0);
				
				var4.add(var3);
				
				CRAFTING_LIST.set(par0, var4);
			} else {
				var4.add(var3);
				
				CRAFTING_LIST.add(par0, var4);
			}
			
			var1 = var1 + var4.indexOf(var3);
			
			GameRegistry.addShapelessRecipe(new ResourceLocation(var1), new ResourceLocation(var2), par1[0], var0);
		}
	}
	
	/**
	 * Adds a shaped recipe to the game and the mod registry.
	 * @param par0 recipe id, used to group recipes with the same id/output to the same registry list
	 * @param par1 recipe shape, with keys A, B, C ... I, (max 9 slots); inputs are ordered to match keys in alphabetical order. 
	 * @param par2 recipe components, with the first component being the output
	 */
	public static void addShapedRecipe(int par0, String par1, String par2, String par3, ItemStack ... par4) {
		if(par4.length > 1) {
			String var0 = IConstants.MODID + ":" + par4[0].getUnlocalizedName().substring(5) + "_" + par0;
			String var1 = IConstants.MODID + ":shaped";
			
			List<String> var2 = new ArrayList<String>();
			Set<Character> var3 = new TreeSet<>();
			
			if(!par1.isEmpty()) {
				var2.add(par1);
			}
			
			if(!par2.isEmpty()) {
				var2.add(par2);
			}
			
			if(!par3.isEmpty()) {
				var2.add(par3);
			}
			
			String var4 = par1 + par2 + par3;
			
			for(int var = 0; var < var4.length(); var++) {
				if(var4.charAt(var) != ' ') {
					var3.add(var4.charAt(var));
				}
			}
			
			Object[] var5 = new Object[var2.size() + (2 * var3.size())];
			
			for(int var = 0; var < (var2.size() + var3.size()); var++) {
				if(var < var2.size()) {
					var5[var] = var2.get(var);
				} else {
					var5[var2.size() + (2 * (var - var2.size()))] = var3.toArray()[(var - var2.size())];
					var5[var2.size() + (2 * (var - var2.size())) + 1] = par4[(var - var2.size()) == 0 ? 1 : (var - var2.size()) + 1];
				}
			}
			
			Recipe var9 = new Recipe(Type.SHAPED, var2, par4);
			List<Recipe> var10 = new ArrayList<Recipe>();
			
			if(CRAFTING_LIST.size() >= (par0 + 1)) {
				var10 = CRAFTING_LIST.get(par0);
				
				var10.add(var9);
				
				CRAFTING_LIST.set(par0, var10);
			} else {
				var10.add(var9);
				
				CRAFTING_LIST.add(par0, var10);
			}
			
			var0 = var0 + var10.indexOf(var9);
			
			GameRegistry.addShapedRecipe(new ResourceLocation(var0), new ResourceLocation(var1), par4[0], var5);
		}
	}
	
	public static List<List<Recipe>> getList() {
		return CRAFTING_LIST;
	}
}
