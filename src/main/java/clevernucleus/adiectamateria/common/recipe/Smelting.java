package clevernucleus.adiectamateria.common.recipe;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Smelting {
	private static final List<ItemStack[]> SMELTING_LIST = new ArrayList<ItemStack[]>();
	
	/**
	 * 
	 * @param par0 input
	 * @param par1 output
	 */
	public static void addRecipe(ItemStack par0, ItemStack par1) {
		GameRegistry.addSmelting(par0, par1, 0.3F);
		
		ItemStack[] var0 = new ItemStack[2];
		
		var0[0] = par0;
		var0[1] = par1;
		
		SMELTING_LIST.add(var0);
	}
	
	public static List<ItemStack[]> getList() {
		return SMELTING_LIST;
	}
}
