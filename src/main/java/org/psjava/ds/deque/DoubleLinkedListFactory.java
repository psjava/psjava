package org.psjava.ds.deque;

public class DoubleLinkedListFactory {

	public static DequeFactory getInstance() {
		return new DequeFactory() {
			@Override
			public <T> Deque<T> create() {
				return DoubleLinkedList.create();
			}
		};
	}

	private DoubleLinkedListFactory() {
	}
}
