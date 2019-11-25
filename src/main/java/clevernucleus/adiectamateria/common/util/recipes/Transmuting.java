package clevernucleus.adiectamateria.common.util.recipes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import clevernucleus.adiectamateria.common.util.ObjectHolder;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Transmuting {
	private static final List<ObjectHolder> LIST = new ArrayList<>();
	private static final Map<IBlockState, Object> MAP = new HashMap<>();
	private static final List<Block> EXCEPTIONS = new ArrayList<Block>();
	private static final Map<Block, List<ItemStack>> EXCEPTION_MAP = new HashMap<>();
	
	public Transmuting() {}
	
	public static void addSimpleRecipe(Block par0, Block par1) {
		LIST.add(new ObjectHolder(par0.getDefaultState(), par1.getDefaultState()));
		MAP.put(par0.getDefaultState(), par1.getDefaultState());
	}
	
	public static void addSimpleRecipe(Block par0, Item par1) {
		LIST.add(new ObjectHolder(par0.getDefaultState(), par1));
		MAP.put(par0.getDefaultState(), par1);
	}
	
	public static void addComplexRecipe(IBlockState par0, IBlockState par1) {
		LIST.add(new ObjectHolder(par0, par1));
		MAP.put(par0, par1);
	}
	
	public static List<ObjectHolder> getTransmutingList() {
		return LIST;
	}
	
	public static Map<IBlockState, Object> getTransmutingMap() {
		return MAP;
	}
	
	public static void addBlockException(Block par0, int par1) {
		EXCEPTIONS.add(par0);
		
		List<ItemStack> var0 = new ArrayList<ItemStack>();
		
		if(par1 > 0) {
			for(int var = 0; var < par1; var++) {
				var0.add(new ItemStack(par0, 1, var));
			}
		} else {
			var0.add(new ItemStack(par0, 1, 1));
		}
		
		EXCEPTION_MAP.put(par0, var0);
	}
	
	public static List<Block> getExceptions() {
		return EXCEPTIONS;
	}
	
	public static Map<Block, List<ItemStack>> getExceptionMap() {
		return EXCEPTION_MAP;
	}
}
