package org.psjava.ds.map;

import java.util.Iterator;

import org.psjava.javautil.ConvertedDataIterator;
import org.psjava.javautil.DataConverter;
import org.psjava.javautil.EqualityTester;
import org.psjava.javautil.StrictEqualityTester;
import org.psjava.math.PairHash;


public class MutableMapUsingJavaMap {
	
	public static <K, V> MutableMap<K, V> create(final java.util.Map<K, V> map) {
		return new MutableMap<K, V>() {

			public boolean containsKey(K key) {
				return map.containsKey(key);
			}

			public V get(K key) {
				V r = map.get(key);
				if (r == null)
					throw new RuntimeException();
				return r;
			}

			@Override
			public V get(K key, V def) {
				V r = map.get(key);
				if (r != null)
					return r;
				else
					return def;
			}

			public Iterable<K> keys() {
				return map.keySet();
			}

			public void put(K key, V value) {
				map.put(key, value);
			}

			public Iterable<V> values() {
				return map.values();
			}

			public void clear() {
				map.clear();
			}

			public boolean isEmpty() {
				return map.isEmpty();
			}

			public Iterator<MutableEntry<K, V>> iterator() {
				return ConvertedDataIterator.create(map.entrySet().iterator(), new DataConverter<java.util.Map.Entry<K, V>, MutableEntry<K, V>>() {
					@Override
					public MutableEntry<K, V> convert(java.util.Map.Entry<K, V> e) {
						return new EntryWrapper<K, V>(e);
					}
				});
			}

			public int size() {
				return map.size();
			}

			public void remove(K key) {
				map.remove(key);
			}

			@Override
			public String toString() {
				return map.toString();
			}

		};
	}

	private static class EntryWrapper<K, V> implements MutableEntry<K, V>, EqualityTester<EntryWrapper<K,V>> {
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
		public void setValue(V v) {
			e.setValue(v);						
		}
		@Override
		public boolean equals(Object obj) {
			return StrictEqualityTester.areEqual(this, obj, this);
		}
		@Override
		public boolean areEqual(EntryWrapper<K, V> o1, EntryWrapper<K, V> o2) {
			return o1.getKey().equals(o2.getKey()) && o1.getValue().equals(o2.getValue());
		}
		@Override
		public int hashCode() {
			return PairHash.hash(getKey().hashCode(), getValue().hashCode());
		}
	}

}
