package org.psjava.ds.queue;

import org.psjava.ds.deque.Deque;
import org.psjava.ds.deque.DequeFactory;

public class QueueFactoryUsingDeque {

	public static QueueFactory getInstance(final DequeFactory dequeFactory) {
		return new QueueFactory() {
			@Override
			public <T> Queue<T> create() {
				final Deque<T> deque = dequeFactory.create();
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
	}

	private QueueFactoryUsingDeque() {
	}

}
