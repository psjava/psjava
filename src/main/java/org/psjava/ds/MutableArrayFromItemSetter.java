package org.psjava.ds;

import org.psjava.ds.array.ArrayIterator;
import org.psjava.ds.array.MutableArray;
import org.psjava.util.GetterByIndex;
import org.psjava.util.IterableEqualityTester;
import org.psjava.util.IterableToString;
import org.psjava.util.OrderFreeIterableHash;
import org.psjava.util.SetterByIndex;
import org.psjava.StrictEqualityTester;

import java.util.Iterator;

public class MutableArrayFromItemSetter {

    public static <T> MutableArray<T> create(final int size, final GetterByIndex<T> getterByIndex, final SetterByIndex<T> setterByIndex) {
        return new MutableArray<T>() {
            public T get(int i) {
                return getterByIndex.get(i);
            }

            public void set(int i, T v) {
                setterByIndex.set(i, v);
            }

            public int size() {
                return size;
            }

            @Override
            public boolean isEmpty() {
                return size() == 0;
            }

            @Override
            public Iterator<T> iterator() {
                return ArrayIterator.create(this);
            }

            @Override
            public String toString() {
                return IterableToString.toString(this);
            }

            @Override
            public boolean equals(Object obj) {
                return StrictEqualityTester.areEqual(this, obj, IterableEqualityTester::areEqual);
            }

            @Override
            public int hashCode() {
                return OrderFreeIterableHash.hash(this);
            }
        };
    }

}
