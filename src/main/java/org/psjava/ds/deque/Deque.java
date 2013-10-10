package org.psjava.ds.deque;

import org.psjava.ds.Collection;

public interface Deque<T> extends Collection<T> {

	void addToLast(T e);

	void clear();

	void addToFirst(T v);

	T getFirst();

	T getLast();

	T removeFirst();

	T removeLast();

}