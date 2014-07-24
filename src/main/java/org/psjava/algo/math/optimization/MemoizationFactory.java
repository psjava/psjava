package org.psjava.algo.math.optimization;

import org.psjava.ds.map.MutableMap;
import org.psjava.ds.map.MutableMapFactory;
import org.psjava.ds.set.MutableSet;
import org.psjava.ds.set.MutableSetFactory;
import org.psjava.util.AssertStatus;

public class MemoizationFactory {

	private MutableMapFactory mapFactory;
	private MutableSetFactory setFactory;

	public MemoizationFactory(MutableMapFactory mapFactory, MutableSetFactory setFactory) {
		this.mapFactory = mapFactory;
		this.setFactory = setFactory;
	}

	public <I, O> Memoization<I, O> create(final MemoizationFunction<I, O> f) {
		final MutableMap<I, O> table = mapFactory.create();
		final MutableSet<I> inStack = setFactory.create();
		return new Memoization<I, O>() {
			@Override
			public O get(I input) {
				AssertStatus.assertTrue(!inStack.contains(input), "The function calls infinite recursion. check the logic.");
				inStack.insert(input);
				O v = table.getOrNull(input);
				if (v == null) {
					v = f.get(input, this);
					table.add(input, v);
				}
				inStack.remove(input);
				return v;
			}
		};
	}

}
