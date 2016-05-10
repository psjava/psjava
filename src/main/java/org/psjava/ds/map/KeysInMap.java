package org.psjava.ds.map;

import org.psjava.ds.KeyValuePair;
import org.psjava.util.ConvertedDataIterable;
import org.psjava.util.Converter;

public class KeysInMap {
	public static <K, V> Iterable<K> get(Map<K, V> map) {
		return ConvertedDataIterable.create(map, new Converter<KeyValuePair<K, V>, K>() {
			@Override
			public K convert(KeyValuePair<K, V> pair) {
				return pair.getKey();
			}
		});
	}

	private KeysInMap() {
	}
}
