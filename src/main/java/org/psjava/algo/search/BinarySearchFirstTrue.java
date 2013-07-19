package org.psjava.algo.search;


import org.psjava.math.calc.FloorDivide;
import org.psjava.math.ns.IntegerDivisableNumberSystem;

public class BinarySearchFirstTrue {

	public static <T> T search(IntegerDivisableNumberSystem<T> keyNumberSystem, T beginKey, T endKey, Function<T, Boolean> nonDecreasingFunction, T def) {
		T r = searchFirstPositionTrueCanBeInserted(keyNumberSystem, beginKey, endKey, nonDecreasingFunction);
		if (r.equals(endKey))
			return def;
		return r;
	}

	private static <T> T searchFirstPositionTrueCanBeInserted(IntegerDivisableNumberSystem<T> keyNumberSystem, T beginKey, T endKey, Function<T, Boolean> nonDecreasingFunction) {
		IntegerDivisableNumberSystem<T> ns = keyNumberSystem;
		T one = ns.getOne();
		T two = ns.add(one, one);
		while (ns.compare(beginKey, endKey) < 0) {
			T midKey = FloorDivide.calc(ns, ns.add(beginKey, endKey), two);
			boolean midValue = nonDecreasingFunction.get(midKey);
			if (!midValue)
				beginKey = ns.add(midKey, one);
			else
				endKey = midKey;
		}
		return endKey;
	}

}
