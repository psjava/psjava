package org.psjava.ds.map;

import org.psjava.javautil.ConvertedDataIterable;
import org.psjava.javautil.DataConverter;

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
