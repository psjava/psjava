package org.psjava.ds.map.hashtable;

import java.util.Iterator;

import org.psjava.ds.map.Map;
import org.psjava.ds.map.MapEntry;
import org.psjava.ds.map.MapEqualityTester;
import org.psjava.ds.map.MutableMap;
import org.psjava.util.AssertStatus;
import org.psjava.util.ConvertedDataIterator;
import org.psjava.util.DataConverter;
import org.psjava.util.DataFilter;
import org.psjava.util.EqualityTester;
import org.psjava.util.FilteredIterator;
import org.psjava.util.Java1DArray;
import org.psjava.util.OrderFreeIterableHash;
import org.psjava.util.StrictEqualityTester;
import org.psjava.util.VarargsIterator;

public class OpenAddressingHashTableMap<K, V> implements MutableMap<K, V> {

	/**
	 * This is not very fast map. Because it's structure to provide flexibility of probing.
	 */

	private static class Entry<K, V> implements MapEntry<K, V> {
		K keyOrNull; // if null then the entry is lazy deleted.
		V value;
		int keyHash;

		Entry(K key, V value, int keyHash) {
			this.keyOrNull = key;
			this.value = value;
			this.keyHash = keyHash;
		}

		@Override
		public K getKey() {
			AssertStatus.assertTrue(keyOrNull != null);
			return keyOrNull;
		}

		@Override
		public V getValue() {
			AssertStatus.assertTrue(keyOrNull != null);
			return value;
		}

		@Override
		public String toString() {
			if (keyOrNull == null)
				return "<removed>";
			return keyOrNull + "=" + value;
		}
	}

	private static final int MAX_LOAD_FACTOR2 = 2;

	private final HashProber prober;
	protected Entry<K, V>[] bucket;
	protected int load = 0;
	protected int lazyDeletedCount = 0;

	public OpenAddressingHashTableMap(HashProber prober, int reserve) {
		this.prober = prober;
		bucket = Java1DArray.create(Entry.class, calcBucketSize(reserve));
	}

	protected static int calcBucketSize(int reserve) {
		int size = 1;
		while (size / MAX_LOAD_FACTOR2 < reserve)
			size <<= 1;
		return size;
	}

	@Override
	public void clear() {
		bucket = Java1DArray.create(Entry.class, calcBucketSize(1));
		load = 0;
		lazyDeletedCount = 0;
	}

	@Override
	public void put(K key, V value) {
		ensureArraysCapacity(load + 1);
		putToCurrentArray(key, value);
	}

	protected void putToCurrentArray(final K key, final V value) {
		final int keyHash = key.hashCode();
		probe(keyHash, new BucketVisitor() {
			@Override
			public boolean visitAndGetContinuity(int pos) {
				if (bucket[pos] != null) {
					if (isKeyInBucket(pos, key, keyHash)) {
						bucket[pos].keyOrNull = key;
						bucket[pos].value = value;
						return false;
					} else {
						return true;
					}
				} else {
					bucket[pos] = new Entry<K, V>(key, value, keyHash);
					load++;
					return false;
				}
			}
		});
	}

	private void probe(int keyHash, BucketVisitor visitor) {
		prober.probe(Math.abs(keyHash) % bucket.length, bucket.length, visitor);
	}

	protected void ensureArraysCapacity(int reserve) {
		if (reserve <= bucket.length / MAX_LOAD_FACTOR2)
			return;
		Entry<K, V>[] oldBucket = bucket;
		bucket = Java1DArray.create(Entry.class, calcBucketSize(reserve));
		load = 0;
		lazyDeletedCount = 0;
		for (Entry<K, V> v : oldBucket)
			if (v != null && v.keyOrNull != null)
				putToCurrentArray(v.keyOrNull, v.value);
	}

	@Override
	public V get(K key) {
		Entry<K, V> e = findEntry(key, null);
		AssertStatus.assertTrue(e != null, "key is not in the map");
		return e.value;
	}

	@Override
	public V get(K key, V def) {
		Entry<K, V> e = findEntry(key, null);
		if (e == null)
			return def;
		return e.value;
	}

	@Override
	public boolean containsKey(K key) {
		return findEntry(key, null) != null;
	}

	@Override
	public void remove(final K key) {
		Entry<K, V> e = findEntry(key, null);
		if (e != null) {
			e.keyOrNull = null;
			e.value = null;
			lazyDeletedCount++;
		}
	}

	@Override
	public int size() {
		return load - lazyDeletedCount;
	}

	private Entry<K, V> findResult;

	private Entry<K, V> findEntry(final K key, Entry<K, V> def) {
		final int keyHash = key.hashCode();
		findResult = def;
		probe(keyHash, new BucketVisitor() {
			@Override
			public boolean visitAndGetContinuity(int pos) {
				if (bucket[pos] != null) {
					if (isKeyInBucket(pos, key, keyHash)) {
						findResult = bucket[pos];
						return false;
					} else {
						return true;
					}
				} else {
					return false;
				}
			}
		});
		return findResult;
	}

	@Override
	public Iterator<MapEntry<K, V>> iterator() {
		return ConvertedDataIterator.create(FilteredIterator.create(VarargsIterator.create(bucket), new DataFilter<Entry<K, V>>() {
			@Override
			public boolean isAccepted(Entry<K, V> v) {
				return v != null && v.keyOrNull != null;
			}
		}), new DataConverter<Entry<K, V>, MapEntry<K, V>>() {
			@Override
			public MapEntry<K, V> convert(Entry<K, V> v) {
				return v;
			}
		});
	}

	private boolean isKeyInBucket(int pos, K key, int keyHash) {
		Entry<K, V> e = bucket[pos];
		return e.keyOrNull != null && e.keyHash == keyHash && e.keyOrNull.equals(key);
	}

	@Override
	public boolean isEmpty() {
		return load == 0;
	}

	@Override
	public boolean equals(Object obj) {
		return StrictEqualityTester.areEqual(this, obj, new EqualityTester<Map<K, V>>() {
			@Override
			public boolean areEqual(Map<K, V> o1, Map<K, V> o2) {
				return MapEqualityTester.areEqual(o1, o2);
			}
		});
	}

	@Override
	public int hashCode() {
		return OrderFreeIterableHash.hash(this);
	}
}
