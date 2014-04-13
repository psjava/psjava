package org.psjava.ds.set;

import org.psjava.goods.GoodMutableSetFactory;

public class IntersectionOfTwoSets {

	public static <T> Set<T> create(Set<T> s1, Set<T> s2) {
		MutableSet<T> r = GoodMutableSetFactory.getInstance().create();
		for (T v : s2)
			if (s1.contains(v))
				r.insert(v);
		return r;
	}

}
