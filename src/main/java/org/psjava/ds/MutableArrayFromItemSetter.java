package org.psjava.ds;

import org.psjava.ds.array.ArrayIterator;
import org.psjava.ds.array.MutableArray;
import org.psjava.util.EqualityTester;
import org.psjava.util.GetterByIndex;
import org.psjava.util.IterableEqualityTester;
import org.psjava.util.IterableToString;
import org.psjava.util.OrderFreeIterableHash;
import org.psjava.util.SetterByIndex;
import org.psjava.util.StrictEqualityTester;

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
                return StrictEqualityTester.areEqual(this, obj, new EqualityTester<MutableArray<T>>() {
                    @Override
                    public boolean areEqual(MutableArray<T> o1, MutableArray<T> o2) {
                        return IterableEqualityTester.areEqual(o1, o2);
                    }
                });
            }

            @Override
            public int hashCode() {
                return OrderFreeIterableHash.hash(this);
            }
        };
    }

}
