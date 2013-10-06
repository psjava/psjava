package org.psjava.ds.stack;

import org.psjava.ds.array.DynamicArray;
import org.psjava.ds.array.LastInArray;

public class StackFactoryUsingDynamicArray implements StackFactory {
	@Override
	public <T> Stack<T> create() {
		return new Stack<T>() {
			DynamicArray<T> a = DynamicArray.create();

			public boolean isEmpty() {
				return a.isEmpty();
			}

			public T pop() {
				return a.removeLast();
			}

			public void push(T v) {
				a.addToLast(v);
			}

			public T top() {
				return LastInArray.getLast(a);
			}

			@Override
			public String toString() {
				return a.toString();
			}
		};
	}

}