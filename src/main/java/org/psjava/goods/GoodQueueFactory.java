package org.psjava.goods;

import org.psjava.ds.Deque;
import org.psjava.ds.DoubleLinkedList;
import org.psjava.ds.queue.Queue;
import org.psjava.ds.queue.QueueFactory;

public class GoodQueueFactory {

	private static QueueFactory instance = new QueueFactory() {
		@Override
		public <T> Queue<T> create() {
			final Deque<T> deque = DoubleLinkedList.create(); // TODO use good deque factory when it's prepared.. and extract to class
			return new Queue<T>() {
				@Override
				public void enque(T v) {
					deque.addToLast(v);
				}

				@Override
				public boolean isEmpty() {
					return deque.isEmpty();
				}

				@Override
				public T deque() {
					return deque.removeFirst();
				}
			};
		}
	};

	public static QueueFactory getInstance() {
		return instance;
	}

	private GoodQueueFactory() {
	}

}
