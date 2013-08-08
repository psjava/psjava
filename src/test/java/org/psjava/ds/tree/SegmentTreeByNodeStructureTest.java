package org.psjava.ds.tree;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.ds.array.Array;
import org.psjava.ds.array.MutableArrayFromValues;
import org.psjava.math.BinaryOperator;

public class SegmentTreeByNodeStructureTest {

	@Test
	public void testQuery() {
		SegmentTreeByNodeStructure<Integer> tree = createInitTree();
		Assert.assertEquals(10, (int) tree.query(0, 4));
	}

	@Test
	public void testUpdateSingle() {
		SegmentTreeByNodeStructure<Integer> tree = createInitTree();
		tree.update(0, 2);
		Assert.assertEquals(37, (int) tree.query(0, 8));
	}

	@Test
	public void testLazyUpdate() {
		SegmentTreeByNodeStructure<Integer> tree = createInitTree();

		tree.updateRange(2, 4, 100);

		SegmentTreeByNodeStructure<Integer>.NodeData data = tree.root.getLeft().getRight().getData();
		Assert.assertNotNull(data.lazyPropagationValueOrNull);
		Assert.assertEquals(200, (int) data.merged);

		int r = tree.query(1, 3);

		Assert.assertEquals(102, r);
		Assert.assertNull(data.lazyPropagationValueOrNull);
	}

	private SegmentTreeByNodeStructure<Integer> createInitTree() {
		Array<Integer> init = MutableArrayFromValues.create(1, 2, 3, 4, 5, 6, 7, 8);
		return new SegmentTreeByNodeStructure<Integer>(init, new BinaryOperator<Integer>() {
			@Override
			public Integer calc(Integer a, Integer b) {
				return a + b;
			}
		});
	}

}
