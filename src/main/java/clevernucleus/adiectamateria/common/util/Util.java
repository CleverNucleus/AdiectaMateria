package clevernucleus.adiectamateria.common.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Util {
	public static final Random RANDOM = new Random();
	public static final Supplier<Integer> RANDOM_NEGATIVE = () -> RANDOM.nextBoolean() ? -1 : 1;
	
	public static <T> T pair(final T[] par0, final boolean par1) {
		if(par0 == null || par0.length == 0) return (T)null;
		if(par0.length < 2) return par0[0];
		
		return par0[par1 ? 0 : 1];
	}
	
	public static <E> Set<E> set(final Consumer<Set<E>> par0) {
		Set<E> var0 = new HashSet<E>();
		
		par0.accept(var0);
		
		return var0;
	}
	
	public static <K, V> Map<K, V> map(final Consumer<Map<K, V>> par0) {
		Map<K, V> var0 = new HashMap<K, V>();
		
		par0.accept(var0);
		
		return var0;
	}
}
