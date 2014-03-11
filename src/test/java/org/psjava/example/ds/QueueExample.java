package org.psjava.example.ds;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.ds.deque.DoubleLinkedListFactory;
import org.psjava.ds.deque.DynamicArrayDequeFactory;
import org.psjava.ds.queue.Queue;
import org.psjava.ds.queue.QueueFactory;
import org.psjava.ds.queue.QueueFactoryUsingDeque;
import org.psjava.goods.GoodQueueFactory;

public class QueueExample {

	@Test
	public void example() {

		Queue<String> queue = GoodQueueFactory.getInstance().create();

		queue.enque("A");
		queue.enque("B");

		// Here are operations.

		String dequed1 = queue.deque(); // must be "A"
		String dequed2 = queue.deque(); // must be "B"
		boolean empty = queue.isEmpty(); // must be true
		Assert.assertEquals("A", dequed1);
		Assert.assertEquals("B", dequed2);
		Assert.assertTrue(empty);

		// There are several implementations of queue. You can specify deque's implementation.

		QueueFactory factory1 = QueueFactoryUsingDeque.getInstance(DoubleLinkedListFactory.getInstance());
		QueueFactory factory2 = QueueFactoryUsingDeque.getInstance(DynamicArrayDequeFactory.getInstance());
		Assert.assertNotNull(factory1);
		Assert.assertNotNull(factory2);

	}
}
