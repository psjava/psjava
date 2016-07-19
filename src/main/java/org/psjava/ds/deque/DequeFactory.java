package org.psjava.ds.deque;

public interface DequeFactory {
    <T> Deque<T> create();
}
