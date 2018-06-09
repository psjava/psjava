package org.psjava.ds.deque;

public class DoubleLinkedListFactory {

    public static DequeFactory getInstance() {
        return new DequeFactory() {
            @Override
            public <T> PSDeque<T> create() {
                return DoubleLinkedList.create();
            }
        };
    }

    private DoubleLinkedListFactory() {
    }
}
