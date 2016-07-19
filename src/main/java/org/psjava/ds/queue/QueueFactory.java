package org.psjava.ds.queue;

public interface QueueFactory {
    <T> Queue<T> create();
}
