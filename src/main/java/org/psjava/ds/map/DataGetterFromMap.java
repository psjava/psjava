package org.psjava.ds.map;

import org.psjava.javautil.DataGetter;

public class DataGetterFromMap {

	public static <K, V> DataGetter<K,V> wrap(final Map<K, V> map) {
		return new DataGetter<K,V>() {
			@Override
			public V get(K k) {
				return map.get(k);
			}
		};
	}
	
	private DataGetterFromMap() {
	}

}
