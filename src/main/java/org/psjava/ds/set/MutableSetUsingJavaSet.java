package org.psjava.ds.set;

import java.util.Iterator;

import org.psjava.ds.map.SetEqualityTester;
import org.psjava.util.Assertion;
import org.psjava.util.IterableToString;
import org.psjava.util.OrderFreeIterableHash;
import org.psjava.StrictEqualityTester;

@Deprecated
public class MutableSetUsingJavaSet<T> implements MutableSet<T> {

    private final java.util.Set<T> javaset;

    public MutableSetUsingJavaSet(java.util.Set<T> set) {
        this.javaset = set;
    }

    @Override
    public void clear() {
        javaset.clear();
    }

    @Override
    public boolean contains(T v) {
        return javaset.contains(v);
    }

    @Override
    public void add(T v) {
        boolean added = javaset.add(v);
        Assertion.ensure(added, "Already exist in set");
    }

    @Override
    public void addIfAbsent(T v) {
        javaset.add(v);
    }

    @Override
    public Iterator<T> iterator() {
        return javaset.iterator();
    }

    @Override
    public int size() {
        return javaset.size();
    }

    @Override
    public void remove(T v) {
        boolean removed = javaset.remove(v);
        Assertion.ensure(removed, "given value is not in set");
    }

    @Override
    public void removeIfExist(T v) {
        javaset.remove(v);
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public String toString() {
        return IterableToString.toString(this);
    }

    @Override
    public int hashCode() {
        return OrderFreeIterableHash.hash(this);
    }

    @Override
    public boolean equals(Object obj) {
        return StrictEqualityTester.areEqual(this, obj, SetEqualityTester::areEqual);
    }

}