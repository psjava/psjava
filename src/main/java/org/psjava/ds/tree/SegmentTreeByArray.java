package org.psjava.ds.tree;

import org.psjava.ds.array.Array;
import org.psjava.math.BinaryOperator;

public class SegmentTreeByArray<T> implements SegmentTree<T> {

	/**
	 * We didn't implement lazy propagation. because it disables the advantage
	 * of BinaryTreeByArray's speed.
	 */

	private final BinaryOperator<T> merger;
	private final BinaryTreeByArray<T> tree;
	private final int size;

	public SegmentTreeByArray(final Array<T> initialData, final BinaryOperator<T> merger) {
		this.merger = merger;
		size = initialData.size();
		tree = new BinaryTreeByArray<T>();
		int root = tree.createRoot(initialData.get(0));
		construct(root, initialData, 0, initialData.size());
	}

	private void construct(int node, Array<T> initialData, int start, int end) {
		if (end - start == 1) {
			tree.setValue(node, initialData.get(start));
		} else {
			T any = initialData.get(0);
			int mid = (start + end) / 2;
			int left = tree.putChild(node, false, any);
			int right = tree.putChild(node, true, any);
			construct(left, initialData, start, mid);
			construct(right, initialData, mid, end);
			tree.setValue(node, merger.calc(tree.getValue(left), tree.getValue(right)));
		}
	}

	@Override
	public T query(int start, int end) {
		return query(tree.getRootPointer(), 0, size, start, end);
	}

	private T query(int node, int nodeStart, int nodeEnd, int start, int end) {
		if (nodeEnd - nodeStart == 1) {
			return tree.getValue(node);
		} else {
			int mid = (nodeStart + nodeEnd) / 2;
			if (end <= mid)
				return query(tree.getLeft(node), nodeStart, mid, start, end);
			else if (mid <= start)
				return query(tree.getRight(node), mid, nodeEnd, start, end);
			else
				return merger.calc(query(tree.getLeft(node), nodeStart, mid, start, mid), query(tree.getRight(node), mid, nodeEnd, mid, end));
		}
	}

	@Override
	public void update(int position, T value) {
		update(tree.getRootPointer(), 0, size, position, value);
	}

	private void update(int node, int nodeStart, int nodeEnd, int position, T value) {
		if (nodeEnd - nodeStart == 1) {
			tree.setValue(node, value);
		} else {
			int left = tree.getLeft(node);
			int right = tree.getRight(node);
			int mid = (nodeStart + nodeEnd) / 2;
			if (position < mid)
				update(left, nodeStart, mid, position, value);
			else
				update(right, mid, nodeEnd, position, value);
			tree.setValue(node, merger.calc(tree.getValue(left), tree.getValue(right)));
		}
	}
}