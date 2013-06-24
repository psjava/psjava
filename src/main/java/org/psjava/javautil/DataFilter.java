package org.psjava.javautil;

public interface DataFilter<T> {
	boolean isAccepted(T v);
}
