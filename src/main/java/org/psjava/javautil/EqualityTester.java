package org.psjava.javautil;

public interface EqualityTester<T> {
	boolean areEqual(T o1, T o2);
}