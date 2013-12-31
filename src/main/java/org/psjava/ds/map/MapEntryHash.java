package org.psjava.ds.map;

import org.psjava.algo.math.PairHash;

public class MapEntryHash {
	public static <K, V> int hash(MapEntry<K, V> entry) {
		if (entry.getValue() == null)
			return entry.getKey().hashCode();
		return PairHash.hash(entry.getKey().hashCode(), entry.getValue().hashCode());
	}

	private MapEntryHash() {
	}

}
