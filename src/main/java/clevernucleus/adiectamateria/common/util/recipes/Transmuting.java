package clevernucleus.adiectamateria.common.util.recipes;

import java.util.ArrayList;
import java.util.List;

import clevernucleus.adiectamateria.common.util.Component;

public class Transmuting {
	private static final List<Component[]> TRANSMUTATION_ARRAY = new ArrayList<Component[]>();
	private static final List<List<Component[]>> TRANSMUTATION_LIST = new ArrayList<List<Component[]>>();
	
	/**
	 * 
	 * @param par0 Recipe id; used to group looping recipes into one section on the book; index starts at 0
	 * @param par1 Input component; should only be a block
	 * @param par2 Output component; what the block turns into
	 */
	public static void addRecipe(int par0, Component par1, Component par2) {
		Component[] var0 = new Component[2];
		
		var0[0] = par1;
		var0[1] = par2;
		
		List<Component[]> var2 = new ArrayList<Component[]>();
		
		if(TRANSMUTATION_LIST.size() >= (par0 + 1)) {
			var2 = TRANSMUTATION_LIST.get(par0);
			
			var2.add(var0);
			
			TRANSMUTATION_LIST.set(par0, var2);
		} else {
			var2.add(var0);
			
			TRANSMUTATION_LIST.add(par0, var2);
		}
		
		TRANSMUTATION_ARRAY.add(var0);
	}
	
	public static List<Component[]> getArray() {
		return TRANSMUTATION_ARRAY;
	}
	
	public static List<List<Component[]>> getList() {
		return TRANSMUTATION_LIST;
	}
}
