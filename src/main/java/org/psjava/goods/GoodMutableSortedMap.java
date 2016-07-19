package org.psjava.goods;

import java.util.Comparator;

import org.psjava.ds.map.MutableSortedMap;
import org.psjava.ds.map.MutableSortedMapUsingJavaTreeMap;

public class GoodMutableSortedMap {

    public static <K, V> MutableSortedMap<K, V> create(Comparator<K> comp) {
        return MutableSortedMapUsingJavaTreeMap.<K, V>create(comp);
    }

    private GoodMutableSortedMap() {
    }

}
