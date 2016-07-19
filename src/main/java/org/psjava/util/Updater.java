package org.psjava.util;

public interface Updater<T> {
    T getUpdatedOrNull(T v);
}
