package org.psjava.example.ds;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.ds.queue.Queue;
import org.psjava.ds.queue.QueueFactoryUsingDeque;
import org.psjava.goods.GoodQueueFactory;

/**
 * @implementation {@link GoodQueueFactory}
 * @implementation {@link QueueFactoryUsingDeque}
 */
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
    }
}
