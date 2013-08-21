package org.psjava.ds.map;

import java.util.Iterator;

import org.psjava.javautil.AssertStatus;
import org.psjava.javautil.ConvertedDataIterator;
import org.psjava.javautil.DataConverter;
import org.psjava.javautil.EqualityTester;
import org.psjava.javautil.StrictEqualityTester;
import org.psjava.math.PairHash;


public class MutableMapUsingJavaMap {
	
	public static <K, V> MutableMap<K, V> create(final java.util.Map<K, V> map) {
		return new MutableMap<K, V>() {

			@Override
			public boolean containsKey(K key) {
				return map.containsKey(key);
			}

			@Override
			public V get(K key) {
				V r = map.get(key);
				AssertStatus.assertTrue(r != null, "key is not in map");
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

			@Override
			public Iterable<K> keys() {
				return map.keySet();
			}

			@Override
			public void put(K key, V value) {
				map.put(key, value);
			}

			@Override
			public Iterable<V> values() {
				return map.values();
			}

			@Override
			public void clear() {
				map.clear();
			}

			@Override
			public boolean isEmpty() {
				return map.isEmpty();
			}

			@Override
			public Iterator<MutableEntry<K, V>> iterator() {
				return ConvertedDataIterator.create(map.entrySet().iterator(), new DataConverter<java.util.Map.Entry<K, V>, MutableEntry<K, V>>() {
					@Override
					public MutableEntry<K, V> convert(java.util.Map.Entry<K, V> e) {
						return new EntryWrapper<K, V>(e);
					}
				});
			}

			@Override
			public int size() {
				return map.size();
			}

			@Override
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
