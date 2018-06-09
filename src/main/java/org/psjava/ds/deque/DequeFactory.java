package org.psjava.ds.deque;

public interface DequeFactory {
    <T> PSDeque<T> create();
}
