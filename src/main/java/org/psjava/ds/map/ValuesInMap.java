package org.psjava.ds.map;

import org.psjava.util.ConvertedDataIterable;
import org.psjava.util.DataConverter;

public class ValuesInMap {
	public static <K, V> Iterable<V> get(Map<K, V> map) {
		return ConvertedDataIterable.create(map, new DataConverter<MapEntry<K, V>, V>() {
			@Override
			public V convert(MapEntry<K, V> v) {
				return v.getValue();
			}
		});
	}
}
