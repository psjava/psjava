package org.psjava.math.ns;

import org.psjava.math.Modulo;

public class ModularNumberSystem<T> implements MultipliableNumberSystem<T> {
	
	private final IntegerDivisableNumberSystem<T> ns;
	private final T m;
	
	public ModularNumberSystem(IntegerDivisableNumberSystem<T> originalSystem, T modular) {
		this.ns = originalSystem;
		this.m = modular;
	}

	@Override
	public T getZero() {
		return ns.getZero();
	}
	
	@Override
	public T getOne() {
		return ns.getOne();
	}
	
	@Override
	public boolean isOne(T v) {
		return ns.isOne(v);
	}
	
	@Override
	public boolean isPositive(T v) {
		return ns.isPositive(v);
	}
	
	@Override
	public boolean isNegative(T v) {
		return ns.isNegative(v);
	}
	
	@Override
	public boolean isZero(T v) {
		return ns.isZero(v);
	}
	
	@Override
	public int getSign(T v) {
		return ns.getSign(v);
	}
	
	@Override
	public boolean areEqual(T v1, T v2) {
		return ns.areEqual(modulo(v1), modulo(v2));
	}
	
	@Override
	public T add(T v1, T v2) {
		return modulo(ns.add(v1, v2));
	}
	
	@Override
	public T subtract(T minuend, T subtrahend) {
		return modulo(ns.subtract(minuend, subtrahend));
	}
	
	@Override
	public T multiply(T v1, T v2) {
		return modulo(ns.multiply(v1, v2));
	}

	private T modulo(T v) {
		return Modulo.calc(ns, v, m);
	}
	
}
