package org.psjava.ds.map;

import org.psjava.javautil.ConvertedDataIterable;
import org.psjava.javautil.DataConverter;

public class KeysInMap {
	public static <K, V> Iterable<K> get(Map<K, V> map) {
		return ConvertedDataIterable.create(map, new DataConverter<MapEntry<K, V>, K>() {
			@Override
			public K convert(MapEntry<K, V> v) {
				return v.getKey();
			}
		});
	}
}
