package org.psjava.javautil;

import org.psjava.ds.map.MutableMap;
import org.psjava.ds.set.Set;
import org.psjava.goods.GoodMutableMapFactory;

public class IntBijection {

	private final MutableMap<Object, Integer> objectToInt = GoodMutableMapFactory.getInstance().create();
	private final Object[] intToObject;

	public IntBijection(Set<? extends Object> objects) {
		intToObject = new Object[objects.size()];
		int index = 0;
		for (Object o : objects) {
			intToObject[index] = o;
			objectToInt.put(o, index);
			index++;
		}
	}

	public int size() {
		return intToObject.length;
	}

	public int toInt(Object o) {
		int r = objectToInt.get(o, -1);
		AssertStatus.assertTrue(r != -1, "object is not in the set");
		return r;
	}

	public Object toObject(int v) {
		return intToObject[v];
	}

}
