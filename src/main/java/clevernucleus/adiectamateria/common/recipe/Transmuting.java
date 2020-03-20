package clevernucleus.adiectamateria.common.recipe;

import java.util.ArrayList;
import java.util.List;

public class Transmuting {
	public static final List<Component[]> STORAGE = new ArrayList<Component[]>();
	
	public static void add(Component par0, Component par1) {
		Component[] var0 = new Component[2];
		
		var0[0] = par0;
		var0[1] = par1;
		
		STORAGE.add(var0);
	}
}
