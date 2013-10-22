package org.psjava.goods;

import org.psjava.ds.deque.Deque;
import org.psjava.ds.queue.Queue;
import org.psjava.ds.queue.QueueFactory;

public class GoodQueueFactory {

	private static QueueFactory instance = new QueueFactory() {
		@Override
		public <T> Queue<T> create() {
			final Deque<T> deque = GoodDequeFactory.getInstance().create();
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
