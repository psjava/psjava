package org.psjava.goods;

import org.psjava.ds.set.DisjointSet;
import org.psjava.ds.set.DisjointSetForest;

public class GoodDisjointSet {

    public static <T> DisjointSet<T> create() {
        return new DisjointSetForest<T>();
    }

    private GoodDisjointSet() {
    }

}
