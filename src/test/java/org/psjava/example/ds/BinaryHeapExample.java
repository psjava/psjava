package org.psjava.example.ds;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.ds.heap.BinaryHeap;
import org.psjava.ds.heap.BinaryHeapFactory;
import org.psjava.ds.heap.Heap;
import org.psjava.ds.heap.HeapNode;
import org.psjava.util.DefaultComparator;

/**
 * @implementation {@link BinaryHeap}
 */
public class BinaryHeapExample {

    @Test
    public void example() {

        // Let's create a small heap.

        Heap<Integer> heap = BinaryHeapFactory.getInstance().create(new DefaultComparator<Integer>());
        heap.insert(100);
        heap.insert(300);
        heap.insert(200);

        // This is most basic operation. Extraction of minimum.

        int extracted = heap.extractMinimum(); // must be 100
        Assert.assertEquals(100, extracted);

        // You can only get the miminum without extraction by 'getMinimum()'.

        int minimum1 = heap.getMinimum(); // must be 200
        Assert.assertEquals(200, minimum1);

        // Let's do decrease-key operation.
        // when you insert, keep the node like a pointer . And decrease it with the node.

        HeapNode<Integer> node = heap.insert(400);
        node.decreaseKey(10); // decrease 400 -> 10

        int minimum2 = heap.getMinimum(); // must be 10
        Assert.assertEquals(10, minimum2);
    }

}
