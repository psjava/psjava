package org.psjava.example;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.ds.heap.BinaryHeapFactory;
import org.psjava.ds.heap.Heap;
import org.psjava.ds.heap.HeapNode;
import org.psjava.util.DefaultComparator;

public class HeapExample {

	@Test
	public void example() {

		// Let's create a small heap.

		Heap<Integer> heap = new BinaryHeapFactory().create(new DefaultComparator<Integer>());
		heap.insert(100);
		heap.insert(300);
		heap.insert(200);


		// This is most basic operation. Extraction of minimum.

		int extracted = heap.extractMinimum();
		Assert.assertEquals(100, extracted);


		// You can only get the miminum without extraction.

		int minimum1 = heap.getMinimum();
		Assert.assertEquals(200, minimum1);


		// Let's do decrease-key operation.
		// Get the node as a pointer when you insert. and decreasing is
		// done with the node.

		HeapNode<Integer> node = heap.insert(400);
		node.decreaseKey(10); // decrease 400 -> 10

		int minimum2 = heap.getMinimum();
		Assert.assertEquals(10, minimum2);
	}

}
