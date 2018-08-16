package org.psjava.ds.map;

import java.util.*;
import java.util.Map;

import org.psjava.ds.KeyValuePair;
import org.psjava.ds.KeyValuePairEqualityTester;
import org.psjava.ds.KeyValuePairHash;
import org.psjava.util.ConvertedIterator;
import org.psjava.util.Converter;
import org.psjava.StrictEqualityTester;

public class MapIteratorFromJavaMap {

    public static <K, V> Iterator<KeyValuePair<K, V>> create(final java.util.Map<K, V> map) {
        return ConvertedIterator.create(map.entrySet().iterator(), new Converter<Map.Entry<K, V>, KeyValuePair<K, V>>() {
            @Override
            public KeyValuePair<K, V> convert(java.util.Map.Entry<K, V> e) {
                return new EntryWrapper<K, V>(e);
            }
        });
    }

    private static class EntryWrapper<K, V> implements KeyValuePair<K, V> {
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
            return StrictEqualityTester.areEqual(this, obj, KeyValuePairEqualityTester::are);
        }

        @Override
        public int hashCode() {
            return KeyValuePairHash.hash(this);
        }
    }

    private MapIteratorFromJavaMap() {
    }

}
