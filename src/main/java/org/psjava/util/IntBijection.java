package org.psjava.util;

import org.psjava.ds.map.MutableMap;
import org.psjava.ds.set.Set;
import org.psjava.goods.GoodMutableMapFactory;

public class IntBijection<V> {

	public static <V> IntBijection<V> create(Set<V> objects) {
		return new IntBijection<V>(objects);
	}

	private final MutableMap<V, Integer> objectToInt = GoodMutableMapFactory.getInstance().create();
	private final V[] intToObject;

	private IntBijection(Set<V> objects) {
		intToObject = Java1DArray.<V> create(Object.class, objects.size());
		int index = 0;
		for (V o : objects) {
			intToObject[index] = o;
			objectToInt.put(o, index);
			index++;
		}
	}

	public int size() {
		return intToObject.length;
	}

	public Integer toInt(V o) {
		Integer r = objectToInt.getOrNull(o);
		AssertStatus.assertTrue(r != null, "object is not in the set");
		return r;
	}

	public V toObject(int v) {
		return intToObject[v];
	}

}
