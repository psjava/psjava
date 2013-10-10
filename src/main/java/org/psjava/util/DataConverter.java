package org.psjava.util;

public interface DataConverter<T1, T2> {
	T2 convert(T1 v);
}