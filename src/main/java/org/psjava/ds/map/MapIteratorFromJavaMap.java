package org.psjava.ds.map;

import java.util.Iterator;

import org.psjava.ds.KeyValuePair;
import org.psjava.ds.KeyValuePairEqualityTester;
import org.psjava.ds.KeyValuePairHash;
import org.psjava.util.ConvertedDataIterator;
import org.psjava.util.DataConverter;
import org.psjava.util.EqualityTester;
import org.psjava.util.StrictEqualityTester;

public class MapIteratorFromJavaMap {

	public static <K, V> Iterator<KeyValuePair<K, V>> create(final java.util.Map<K, V> map) {
		return ConvertedDataIterator.create(map.entrySet().iterator(), new DataConverter<java.util.Map.Entry<K, V>, KeyValuePair<K, V>>() {
			@Override
			public KeyValuePair<K, V> convert(java.util.Map.Entry<K, V> e) {
				return new EntryWrapper<K, V>(e);
			}
		});
	}

	private static class EntryWrapper<K, V> implements KeyValuePair<K, V>, EqualityTester<EntryWrapper<K, V>> {
		private java.util.Map.Entry<K, V> e;

		private EntryWrapper(java.util.Map.Entry<K, V> e) {
			this.e = e;
		}

		@Override
		public K getKey() {
			return e.getKey();
		}

		@Override
		public V getValue() {
			return e.getValue();
		}

		@Override
		public boolean equals(Object obj) {
			return StrictEqualityTester.areEqual(this, obj, this);
		}

		@Override
		public boolean areEqual(EntryWrapper<K, V> o1, EntryWrapper<K, V> o2) {
			return KeyValuePairEqualityTester.are(o1, o2);
		}

		@Override
		public int hashCode() {
			return KeyValuePairHash.hash(this);
		}
	}

	private MapIteratorFromJavaMap() {
	}

}
