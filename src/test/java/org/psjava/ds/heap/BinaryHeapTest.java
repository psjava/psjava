package org.psjava.ds.heap;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.util.DefaultComparator;
import org.psjava.util.EmptyIterable;

import java.util.Arrays;
import java.util.Comparator;

public class BinaryHeapTest {

    @Test
    public void testBug() {
        BinaryHeap<Integer> h = new BinaryHeap<>(Arrays.asList(3, 4, 2), Comparator.naturalOrder());
        Assert.assertEquals(3, (int) h.extractMinimum()); // TODO should be 2!
    }

    @Test
    public void testBasicAction() {
        BinaryHeap<Integer> h = new BinaryHeap<Integer>(new EmptyIterable<Integer>(), new DefaultComparator<Integer>());
        h.insert(3);
        h.insert(4);
        h.insert(2);
        Assert.assertEquals(2, (int) h.extractMinimum());
        Assert.assertEquals(3, (int) h.extractMinimum());
        Assert.assertEquals(4, (int) h.extractMinimum());
    }

    @Test(expected = RuntimeException.class)
    public void testDeleted() {
        BinaryHeap<Integer> h = createHeap();
        HeapNode<Integer> node = h.insert(3);
        node.delete();
        node.decreaseKey(0);
    }

    private BinaryHeap<Integer> createHeap() {
        return new BinaryHeap<Integer>(new EmptyIterable<Integer>(), new DefaultComparator<Integer>());
    }
}
