package org.psjava.goods;

import org.psjava.ds.deque.DequeFactory;
import org.psjava.ds.deque.DoubleLinkedListFactory;

public class GoodDequeFactory {
	public static DequeFactory getInstance() {
		return DoubleLinkedListFactory.getInstance();
	}
}
