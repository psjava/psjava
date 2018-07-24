package org.psjava.ds.map;

import java.util.Comparator;
import java.util.Iterator;

import org.psjava.ds.KeyValuePair;
import org.psjava.ds.tree.binary.bst.BinarySearchTree;
import org.psjava.ds.tree.binary.bst.InsertionResult;
import org.psjava.ds.tree.binary.bst.RemoveResult;
import org.psjava.util.Assertion;
import org.psjava.util.IterableToString;

public class MutableSortedMapUsingBinarySearchTree {

    public static <K, V> MutableSortedMap<K, V> create(final Comparator<K> comp) {
        return new MutableSortedMap<K, V>() {
            BinarySearchTree<K, V> tree = new BinarySearchTree<K, V>(comp);
            int size = 0;

            @Override
            public boolean containsKey(K key) {
                return tree.findPairOrNull(key) != null;
            }

            @Override
            public V get(K key) {
                KeyValuePair<K, V> pair = tree.findPairOrNull(key);
                Assertion.ensureNotNull(pair, "not exist for key");
                return pair.getValue();
            }

            @Override
            public V getOrNull(K key) {
                KeyValuePair<K, V> pair = tree.findPairOrNull(key);
                if (pair == null)
                    return null;
                return pair.getValue();
            }

            @Override
            public void add(K key, V value) {
                InsertionResult res = tree.insertOrUpdate(key, value);
                Assertion.ensure(res == InsertionResult.INSERTED);
                size++;
            }

            @Override
            public void replace(K key, V value) {
                InsertionResult res = tree.insertOrUpdate(key, value);
                Assertion.ensure(res == InsertionResult.UPDATED);
            }

            @Override
            public void addOrReplace(K key, V value) {
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

    private MutableSortedMapUsingBinarySearchTree() {
    }
}
