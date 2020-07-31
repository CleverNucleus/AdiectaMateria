package clevernucleus.adiectamateria.common.util;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

public class Util {
	
	public static <E> Set<E> set(final Consumer<Set<E>> par0) {
		Set<E> var0 = new HashSet<E>();
		
		par0.accept(var0);
		
		return var0;
	}
}
