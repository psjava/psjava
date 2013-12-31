package org.psjava.ds.map;

public class MapEqualityTester {

	public static <K, V> boolean areEqual(Map<K, V> m1, Map<K, V> m2) {
		if (m1.size() != m2.size())
			return false;
		for (MapEntry<K, V> e : m1) {
			K key1 = e.getKey();
			V value1 = e.getValue();
			if (!m2.containsKey(key1))
				return false;
			return MapValueEqualityTester.areEqual(value1, m2.get(key1));
		}
		return true;
	}

	private MapEqualityTester() {
	}

}
