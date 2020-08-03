package clevernucleus.adiectamateria.common.util;

import java.util.function.Supplier;

public class Dual<A, B> {
	private A a;
	private B b;
	
	private Dual(final A par0, final B par1) {
		this.a = par0;
		this.b = par1;
	}
	
	public static <F, S> Dual<F, S> make(final F par0, final S par1) {
		return new Dual<F, S>(par0, par1);
	}
	
	public static <F, S> Dual<F, S> get(final Supplier<Dual<F, S>> par0) {
		return par0.get();
	}
	
	public A a() {
		return this.a;
	}
	
	public B b() {
		return this.b;
	}
	
	@Override
	public String toString() {
		return "[" + this.a + "," + this.b + "]";
	}
}
