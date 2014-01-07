package org.psjava.ds.map;

import java.util.Comparator;
import java.util.Iterator;

import org.psjava.ds.KeyValuePair;
import org.psjava.ds.tree.binary.bst.BinarySearchTree;
import org.psjava.ds.tree.binary.bst.InsertionResult;
import org.psjava.ds.tree.binary.bst.RemoveResult;
import org.psjava.util.AssertStatus;
import org.psjava.util.IterableToString;

public class MutableSortedMapUsingBinarySearchTree {

	public static <K, V> MutableSortedMap<K, V> create(final Comparator<K> comp) {
		return new MutableSortedMap<K, V>() {
			BinarySearchTree<K, V> tree = new BinarySearchTree<K, V>(comp);
			int size = 0;

			@Override
			public boolean containsKey(K key) {
				return tree.findExistValue(key, null) != null;
			}

			@Override
			public V get(K key) {
				V v = tree.findExistValue(key, null);
				AssertStatus.assertNotNull(v, "not exist for key");
				return v;
			}

			@Override
			public V get(K key, V def) {
				return tree.findExistValue(key, def);
			}

			@Override
			public void put(K key, V value) {
				AssertStatus.assertNotNull(value, "value cannot be a null");
				InsertionResult r = tree.insertOrUpdate(key, value);
				if (r == InsertionResult.INSERTED)
					size++;
			}

			@Override
			public void clear() {
				tree.clear();
				size = 0;
			}

			@Override
			public boolean isEmpty() {
				return size == 0;
			}

			@Override
			public Iterator<KeyValuePair<K, V>> iterator() {
				return tree.getInOrderIterator();
			}

			@Override
			public void remove(K key) {
				RemoveResult r = tree.removeIfExist(key);
				if (r == RemoveResult.REMOVED)
					size--;
			}

			@Override
			public int size() {
				return size;
			}

			@Override
			public String toString() {
				return IterableToString.toString(this);
			}
		};
	}
}
