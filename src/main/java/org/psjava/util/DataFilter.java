package org.psjava.util;

public interface DataFilter<T> {
	boolean isAccepted(T v);
}
