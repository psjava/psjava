package org.psjava.ds.deque;

import org.psjava.util.Assertion;
import org.psjava.util.Java1DArray;
import org.psjava.util.ZeroTo;

public class DynamicArrayDeque<T> implements PSDeque<T> {

    public static <T> DynamicArrayDeque<T> create() {
        return new DynamicArrayDeque<T>();
    }

    protected Object[] array = Java1DArray.create(Object.class, 1);
    protected int start = 0;
    protected int end = 0;

    @Override
    public void addToLast(T e) {
        array[end] = e;
        end = (end + 1) % array.length;
        if (start == end)
            handleFullEvent();
    }

    @Override
    public void addToFirst(T v) {
        start = (start - 1 + array.length) % array.length;
        array[start] = v;
        if (start == end)
            handleFullEvent();
    }

    private void handleFullEvent() {
        Object[] newArray = Java1DArray.create(Object.class, array.length * 2);
        for (int i : ZeroTo.get(array.length))
            newArray[i] = array[(start + i) % array.length];
        start = 0;
        end = array.length;
        array = newArray;
    }

    @Override
    public void clear() {
        start = 0;
        end = 0;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T getFirst() {
        Assertion.ensure(!isEmpty());
        return (T) array[start];
    }

    @SuppressWarnings("unchecked")
    @Override
    public T getLast() {
        Assertion.ensure(!isEmpty());
        return (T) array[(end - 1 + array.length) % array.length];
    }

    @Override
    public boolean isEmpty() {
        return start == end;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T removeFirst() {
        Assertion.ensure(!isEmpty());
        T r = (T) array[start];
        start = (start + 1) % array.length;
        return r;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T removeLast() {
        Assertion.ensure(!isEmpty());
        end = (end - 1 + array.length) % array.length;
        return (T) array[end];
    }

}
