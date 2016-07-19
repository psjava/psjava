package org.psjava;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import org.junit.Assert;

abstract public class TestUtil {

    public static <T> void assertEqualIterable(T[] expected, Iterable<T> iterable) {
        ArrayList<T> actualList = toArrayListFromIterable(iterable);
        Assert.assertEquals(toArrayList(expected), actualList);
    }

    public static <T> ArrayList<T> toArrayListFromIterable(Iterable<T> iterable) {
        ArrayList<T> r = new ArrayList<T>();
        for (T v : iterable)
            r.add(v);
        return r;
    }

    public static <T> ArrayList<T> toArrayListFromIterator(Iterator<T> iterator) {
        ArrayList<T> r = new ArrayList<T>();
        while (iterator.hasNext())
            r.add(iterator.next());
        return r;
    }

    public static <T> ArrayList<T> toArrayList(T... expected) {
        ArrayList<T> r = new ArrayList<T>();
        for (T v : expected)
            r.add(v);
        return r;
    }

    public static <T> HashSet<T> toHashSet(Iterable<T> iter) {
        HashSet<T> r = new HashSet<T>();
        for (T v : iter)
            r.add(v);
        return r;
    }

    public static <T> HashSet<T> toHashSet(T... vs) {
        HashSet<T> r = new HashSet<T>();
        for (T v : vs)
            r.add(v);
        return r;
    }

}
