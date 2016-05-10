package org.psjava.util;

public interface Filter<T> {
	boolean isAccepted(T v);
}
