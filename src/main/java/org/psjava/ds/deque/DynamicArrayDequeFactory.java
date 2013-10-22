package org.psjava.ds.deque;

public class DynamicArrayDequeFactory {

	public static DequeFactory getInstance() {
		return new DequeFactory() {
			@Override
			public <T> Deque<T> create() {
				return DynamicArrayDeque.create();
			}
		};
	}

	private DynamicArrayDequeFactory() {
	}
}
