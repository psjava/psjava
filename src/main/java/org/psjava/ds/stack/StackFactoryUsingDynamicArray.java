package org.psjava.ds.stack;

import org.psjava.ds.array.DynamicArray;
import org.psjava.ds.array.LastInArray;

public class StackFactoryUsingDynamicArray {

    public static StackFactory getInstance() {
        return new StackFactory() {
            @Override
            public <T> PSStack<T> create() {
                return new PSStack<T>() {
                    DynamicArray<T> a = DynamicArray.create();

                    @Override
                    public boolean isEmpty() {
                        return a.isEmpty();
                    }

                    @Override
                    public T pop() {
                        return a.removeLast();
                    }

                    @Override
                    public void push(T v) {
                        a.addToLast(v);
                    }

                    @Override
                    public T top() {
                        return LastInArray.getLast(a);
                    }

                    @Override
                    public String toString() {
                        return a.toString();
                    }
                };
            }
        };
    }

    private StackFactoryUsingDynamicArray() {
    }
}