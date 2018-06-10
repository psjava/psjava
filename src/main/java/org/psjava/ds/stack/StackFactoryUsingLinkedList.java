package org.psjava.ds.stack;

import org.psjava.ds.deque.DoubleLinkedList;

public class StackFactoryUsingLinkedList {

    public static StackFactory getInstance() {
        return new StackFactory() {
            @Override
            public <T> PSStack<T> create() {
                return new PSStack<T>() {
                    DoubleLinkedList<T> linkedList = DoubleLinkedList.create();

                    @Override
                    public boolean isEmpty() {
                        return linkedList.isEmpty();
                    }

                    @Override
                    public T pop() {
                        return linkedList.removeLast();
                    }

                    @Override
                    public void push(T v) {
                        linkedList.addToLast(v);
                    }

                    @Override
                    public T top() {
                        return linkedList.getLast();
                    }

                    @Override
                    public String toString() {
                        return linkedList.toString();
                    }
                };
            }
        };
    }

    private StackFactoryUsingLinkedList() {
    }
}