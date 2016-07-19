package org.psjava.util;

public interface EventListener<T> {
    void onEvent(T value);
}