package org.psjava.dp;

import org.psjava.ds.map.MutableMap;
import org.psjava.ds.map.MutableMapFactory;

public class MemoizationFactory {

	private MutableMapFactory mapFactory;

	public MemoizationFactory(MutableMapFactory mapFactory) {
		this.mapFactory = mapFactory;
	}

	public <I, V> Memoization<I, V> create(final MemoizationFunction<I, V> f) {
		return new Memoization<I, V>() {
			private MutableMap<I, V> table = mapFactory.create();

			@Override
			public V get(I input) {
				V v = table.get(input, null);
				if (v == null) {
					v = f.get(input, this);
					table.put(input, v);
				}
				return v;
			}
		};
	}

}
