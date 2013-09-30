package org.psjava.ds.stack;


public interface StackFactory {
	<T> Stack<T> create();
}
