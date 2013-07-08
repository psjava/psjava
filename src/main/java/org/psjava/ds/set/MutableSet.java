package org.psjava.ds.set;


public interface MutableSet<T> extends Set<T> {
	void clear();
	void insert(T v);
	void remove(T v);
}
