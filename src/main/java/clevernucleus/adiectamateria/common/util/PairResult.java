package clevernucleus.adiectamateria.common.util;

public class PairResult<V> {
	public static class Pair<K> {
		private K key;
		private int value;
		
		private Pair(final K par0, final int par1) {
			this.key = par0;
			this.value = par1;
		}
		
		public K key() {
			return this.key;
		}
		
		public int value() {
			return this.value;
		}
		
		@Override
		public String toString() {
			return this.key.toString() + ":" + this.value;
		}
	}
	
	private Pair<V> a, b;
	
	private PairResult(final Pair<V> par0, final Pair<V> par1) {
		this.a = par0;
		this.b = par1;
	}
	
	public static <V> Pair<V> P(final V par0, final int par1) {
		return new Pair<V>(par0, par1);
	}
	
	public static <V> PairResult<V> make(final Pair<V> par0) {
		return new PairResult<V>(par0, null);
	}
	
	public static <V> PairResult<V> make(final Pair<V> par0, final Pair<V> par1) {
		return new PairResult<V>(par0, par1);
	}
	
	public Pair<V> get(final boolean par0) {
		if(this.a == null && this.b == null) return null;
		if(this.a == null) return this.b;
		if(this.b == null) return this.a;
		
		return par0 ? this.a : this.b;
	}
	
	@Override
	public String toString() {
		return "[{" + this.a.toString() + "},{" + this.b.toString() + "}]";
	}
}
