package org.psjava.goods;

import org.psjava.ds.queue.QueueFactory;
import org.psjava.ds.queue.QueueFactoryUsingDeque;

public class GoodQueueFactory {

	private static QueueFactory instance = QueueFactoryUsingDeque.create(GoodDequeFactory.getInstance());

	public static QueueFactory getInstance() {
		return instance;
	}

	private GoodQueueFactory() {
	}

}
