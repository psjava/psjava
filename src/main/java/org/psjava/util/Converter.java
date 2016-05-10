package org.psjava.util;

public interface Converter<T1, T2> {
	T2 convert(T1 v);
}