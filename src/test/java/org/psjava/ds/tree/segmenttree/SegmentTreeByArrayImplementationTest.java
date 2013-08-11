package org.psjava.ds.tree.segmenttree;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.ds.array.Array;
import org.psjava.ds.array.MutableArrayFromValues;
import org.psjava.ds.tree.segmenttree.SegmentTree;
import org.psjava.ds.tree.segmenttree.SegmentTreeByArrayImplementation;
import org.psjava.math.BinaryOperator;

public class SegmentTreeByArrayImplementationTest {
	@Test
	public void testQuery() {
		SegmentTree<Integer> tree = createInitTree();
		Assert.assertEquals(10, (int) tree.query(0, 4));
	}

	@Test
	public void testUpdateSingle() {
		SegmentTree<Integer> tree = createInitTree();
		tree.update(0, 2);
		Assert.assertEquals(37, (int) tree.query(0, 8));
	}

	private SegmentTree<Integer> createInitTree() {
		Array<Integer> init = MutableArrayFromValues.create(1, 2, 3, 4, 5, 6, 7, 8);
		return new SegmentTreeByArrayImplementation<Integer>(init, new BinaryOperator<Integer>() {
			@Override
			public Integer calc(Integer a, Integer b) {
				return a + b;
			}
		});
	}
}
