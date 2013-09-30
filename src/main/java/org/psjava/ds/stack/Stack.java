package org.psjava.ds.stack;

public interface Stack<T> {
	void push(T v);
	T pop();
	T top();
	boolean isEmpty();
}
