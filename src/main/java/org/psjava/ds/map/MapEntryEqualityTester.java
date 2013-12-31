package org.psjava.ds.map;

public class MapEntryEqualityTester {

	public static <K, V> boolean are(MapEntry<K, V> o1, MapEntry<K, V> o2) {
		return o1.getKey().equals(o2.getKey()) && MapValueEqualityTester.areEqual(o1.getValue(), o2.getValue());
	}

	private MapEntryEqualityTester() {
	}

}
