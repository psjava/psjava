package org.psjava.ds.set;

public interface MutableSet<T> extends Set<T> {
	void clear();

	void add(T v);

	void addIfAbsent(T v);

	void remove(T v);

	void removeIfExist(T v);
}
