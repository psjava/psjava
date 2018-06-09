package org.psjava.ds.deque;

public class DynamicArrayDequeFactory {

    public static DequeFactory getInstance() {
        return new DequeFactory() {
            @Override
            public <T> PSDeque<T> create() {
                return DynamicArrayDeque.create();
            }
        };
    }

    private DynamicArrayDequeFactory() {
    }
}
