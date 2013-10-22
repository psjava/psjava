package org.psjava.ds.deque;

public class DoubleLinkedListFactory implements DequeFactory {
	@Override
	public <T> Deque<T> create() {
		return DoubleLinkedList.create();
	}
}
