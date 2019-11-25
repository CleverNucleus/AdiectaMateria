package clevernucleus.adiectamateria.common.util.recipes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import clevernucleus.adiectamateria.common.util.ObjectHolder;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Smelting {
	private static final List<ObjectHolder> LIST = new ArrayList<ObjectHolder>();
	private static final Map<ItemStack, ItemStack> MAP = new HashMap<>();
	
	public static void addSmeltingRecipe(Object par0, Object par1) {
		if(par0 instanceof Item) {
			Item var0 = (Item) par0;
			
			if(par1 instanceof Item) {
				Item var1 = (Item) par1;
				
				LIST.add(new ObjectHolder(new ItemStack((Item)par0), new ItemStack((Item)par1)));
				MAP.put(new ItemStack((Item)par0), new ItemStack((Item)par1));
			} else if(par1 instanceof Block) {
				Block var1 = (Block) par1;
				
				LIST.add(new ObjectHolder(new ItemStack((Item)par0), new ItemStack((Block)par1)));
				MAP.put(new ItemStack((Item)par0), new ItemStack((Block)par1));
			}
		} else if(par0 instanceof Block) {
			Block var0 = (Block) par0;
			
			if(par1 instanceof Item) {
				Item var1 = (Item) par1;
				
				LIST.add(new ObjectHolder(new ItemStack((Block)par0), new ItemStack((Item)par1)));
				MAP.put(new ItemStack((Block)par0), new ItemStack((Item)par1));
			} else if(par1 instanceof Block) {
				Block var1 = (Block) par1;
				
				LIST.add(new ObjectHolder(new ItemStack((Block)par0), new ItemStack((Block)par1)));
				MAP.put(new ItemStack((Block)par0), new ItemStack((Block)par1));
			}
		}
	}
	
	public static List<ObjectHolder> getSmeltingList() {
		return LIST;
	}
	
	public static Map<ItemStack, ItemStack> getSmeltingMap() {
		return MAP;
	}
}
