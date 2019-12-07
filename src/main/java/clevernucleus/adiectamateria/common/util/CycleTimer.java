package clevernucleus.adiectamateria.common.util;

import java.util.List;

public class CycleTimer {
	private long start, end;
	
	public CycleTimer() {
		this.start = System.currentTimeMillis();
		this.end = System.currentTimeMillis();
	}
	
	public void tick() {
		end = System.currentTimeMillis();
	}
	
	public Component[] getCycledComponents(List<Component[]> par0) {
		long second = (long)((double)(end - start) * 0.001D);
		
		return par0.get((int)(second % par0.size()));
	}
	
	public Recipe getCycledRecipe(List<Recipe> par0) {
		long second = (long)((double)(end - start) * 0.001D);
		
		return par0.get((int)(second % par0.size()));
	}
}
