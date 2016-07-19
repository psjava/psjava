package org.psjava.util;

// TODO replace to Function?
public interface Converter<T1, T2> {
    T2 convert(T1 v);
}