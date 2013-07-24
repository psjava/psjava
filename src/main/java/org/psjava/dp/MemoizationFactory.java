package org.psjava.dp;

import org.psjava.ds.map.MutableMap;
import org.psjava.ds.map.MutableMapFactory;
import org.psjava.ds.set.MutableSet;
import org.psjava.ds.set.MutableSetFactory;

public class MemoizationFactory {

	private MutableMapFactory mapFactory;
	private MutableSetFactory setFactory;

	public MemoizationFactory(MutableMapFactory mapFactory, MutableSetFactory setFactory) {
		this.mapFactory = mapFactory;
		this.setFactory = setFactory;
	}

	public <I, V> Memoization<I, V> create(final MemoizationFunction<I, V> f) {
		final MutableMap<I, V> table = mapFactory.create();
		final MutableSet<I> inStack = setFactory.create();
		return new Memoization<I, V>() {
			@Override
			public V get(I input) {
				if (inStack.contains(input))
					throw new IllegalArgumentException("The function calls infinite recursion. check the logic.");
				inStack.insert(input);
				V v = table.get(input, null);
				if (v == null) {
					v = f.get(input, this);
					table.put(input, v);
				}
				inStack.remove(input);
				return v;
			}
		};
	}

}
