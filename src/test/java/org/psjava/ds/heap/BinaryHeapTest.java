package org.psjava.ds.heap;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.javautil.DefaultComparator;
import org.psjava.javautil.EmptyIterable;



public class BinaryHeapTest {

	@Test
	public void testBasicAction() {
		BinaryHeap<Integer> h = createHeap();
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
