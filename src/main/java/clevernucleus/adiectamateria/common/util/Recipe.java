package clevernucleus.adiectamateria.common.util;

import java.util.ArrayList;
import java.util.List;

import clevernucleus.adiectamateria.common.util.recipes.Crafting;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class Recipe {
	private List<String> shape;
	private Crafting.Type type;
	private ItemStack[] components;
	
	public Recipe(Crafting.Type par0, ItemStack ... par1) {
		this.type = par0;
		this.components = par1;
	}
	
	public Recipe(Crafting.Type par0, List<String> par1, ItemStack ... par2) {
		this.type = par0;
		this.shape = par1;
		this.components = par2;
	}
	
	private String setString(String par0) {
		String var0 = "";
		
		if(par0.length() == 1) {
			var0 = par0 + "  ";
		} else if(par0.length() == 2) {
			var0 = par0 + " ";
		} else if(par0.length() == 3) {
			var0 = par0;
		}
		
		return var0;
	}
	
	private String getRecipeString(List<String> par0) {
		String var0 = "";
		
		if(par0.size() == 1) {
			var0 = setString(par0.get(0)) + "      ";
		} else if(par0.size() == 2) {
			var0 = setString(par0.get(0)) + setString(par0.get(1)) + "   ";
		} else if(par0.size() == 3) {
			var0 = setString(par0.get(0)) + setString(par0.get(1)) + setString(par0.get(2));
		}
		
		return var0;
	}
	
	public ItemStack[] getDisplayRecipe() {
		ItemStack[] var1 = new ItemStack[10];
		
		if(this.type == Crafting.Type.SHAPED) {
			String var0 = getRecipeString(shape);
			
			for(int var = 0; var < 10; var++) {
				var1[0] = components[0];
				
				if(var >= 1) {
					if(var0.charAt(var - 1) == ' ') {
						var1[var] = ItemStack.EMPTY;
					} else if(var0.charAt(var - 1) == 'A') {
						var1[var] = components[1];
					} else if(var0.charAt(var - 1) == 'B') {
						var1[var] = components[2];
					} else if(var0.charAt(var - 1) == 'C') {
						var1[var] = components[3];
					} else if(var0.charAt(var - 1) == 'D') {
						var1[var] = components[4];
					} else if(var0.charAt(var - 1) == 'E') {
						var1[var] = components[5];
					} else if(var0.charAt(var - 1) == 'F') {
						var1[var] = components[6];
					} else if(var0.charAt(var - 1) == 'G') {
						var1[var] = components[7];
					} else if(var0.charAt(var - 1) == 'H') {
						var1[var] = components[8];
					} else if(var0.charAt(var - 1) == 'I') {
						var1[var] = components[9];
					}
				}
			}
		} else if(this.type == Crafting.Type.SHAPELESS) {
			for(int var = 0; var < 10; var++) {
				if(var < components.length) {
					var1[var] = components[var];
				} else {
					var1[var] = ItemStack.EMPTY;
				}
			}
		}
		
		return var1;
	}
	
	public Crafting.Type getRecipeType() {
		return type;
	}
	
	public ItemStack[] getRecipeComponents() {
		return components;
	}
	
	public List<String> getRecipeShape() {
		return shape;
	}
}
