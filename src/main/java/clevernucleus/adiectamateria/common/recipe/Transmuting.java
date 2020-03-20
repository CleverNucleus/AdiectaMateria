package clevernucleus.adiectamateria.common.recipe;

import java.util.ArrayList;
import java.util.List;

public class Transmuting {
	public static final List<Component[]> STORAGE = new ArrayList<Component[]>();
	public static final List<List<Component[]>> LIST = new ArrayList<List<Component[]>>();
	
	public static void add(int par0, Component par1, Component par2) {
		Component[] var0 = new Component[2];
		
		var0[0] = par1;
		var0[1] = par2;
		
		List<Component[]> var2 = new ArrayList<Component[]>();
		
		if(LIST.size() >= (par0 + 1)) {
			var2 = LIST.get(par0);
			
			var2.add(var0);
			
			LIST.set(par0, var2);
		} else {
			var2.add(var0);
			
			LIST.add(par0, var2);
		}
		
		STORAGE.add(var0);
	}
}
