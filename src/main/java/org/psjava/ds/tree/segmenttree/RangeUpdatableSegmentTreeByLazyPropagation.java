package org.psjava.ds.tree.segmenttree;

import org.psjava.ds.array.Array;
import org.psjava.ds.tree.BinaryTreeNode;
import org.psjava.ds.tree.BinaryTreeNodeFactory;
import org.psjava.math.BinaryOperator;
import org.psjava.math.Power;

public class RangeUpdatableSegmentTreeByLazyPropagation<T> implements RangeUpdatableSegmentTree<T> {

	public static final <T> RangeUpdatableSegmentTree<T> create(Array<T> initialData, BinaryOperator<T> operator) {
		return new RangeUpdatableSegmentTreeByLazyPropagation<T>(initialData, operator);
	}

	class NodeData {
		T merged;
		boolean lazy = false;
		T propagationValue = null; // should not be null if lazy is true

		NodeData(T merged) {
			this.merged = merged;
		}
	}

	private final BinaryOperator<T> operator;
	private final int size;
	final BinaryTreeNode<NodeData> root;

	RangeUpdatableSegmentTreeByLazyPropagation(Array<T> initialData, BinaryOperator<T> operator) {
		this.operator = operator;
		size = initialData.size();
		if (size > 0)
			root = construct(initialData, 0, size);
		else
			root = null;
	}

	private BinaryTreeNode<NodeData> construct(Array<T> initialData, int start, int end) {
		if (end - start == 1) {
			return BinaryTreeNodeFactory.create(new NodeData(initialData.get(start)));
		} else {
			int mid = calcMiddle(start, end);
			BinaryTreeNode<NodeData> left = construct(initialData, start, mid);
			BinaryTreeNode<NodeData> right = construct(initialData, mid, end);
			BinaryTreeNode<NodeData> node = BinaryTreeNodeFactory.create(new NodeData(merge(left, right)));
			node.putLeft(left);
			node.putRight(right);
			return node;
		}
	}

	@Override
	public T query(int start, int end) {
		return query(root, 0, size, start, end);
	}

	private T query(BinaryTreeNode<NodeData> node, int nodeStart, int nodeEnd, int rangeStart, int rangeEnd) {
		if (rangeStart == nodeStart && rangeEnd == nodeEnd) {
			return node.getData().merged;
		} else {
			propagateIfLazy(node, nodeStart, nodeEnd);
			int mid = calcMiddle(nodeStart, nodeEnd);
			if (rangeEnd <= mid)
				return query(node.getLeft(), nodeStart, mid, rangeStart, rangeEnd);
			else if (mid <= rangeStart)
				return query(node.getRight(), mid, nodeEnd, rangeStart, rangeEnd);
			else
				return operator.calc(query(node.getLeft(), nodeStart, mid, rangeStart, mid), query(node.getRight(), mid, nodeEnd, mid, rangeEnd));
		}
	}

	@Override
	public void update(int p, final T v) {
		updateRange(p, p + 1, v);
	}

	@Override
	public void updateRange(int start, int end, T value) {
		updateRange(root, 0, size, start, end, value);
	}

	private void updateRange(BinaryTreeNode<NodeData> node, int nodeStart, int nodeEnd, int rangeStart, int rangeEnd, T value) {
		if (nodeEnd - nodeStart == 1) {
			node.getData().merged = value;
		} else if (rangeStart == nodeStart && rangeEnd == nodeEnd) {
			makeAsLazy(node, rangeStart, rangeEnd, value);
		} else {
			propagateIfLazy(node, nodeStart, nodeEnd);
			int mid = calcMiddle(nodeStart, nodeEnd);
			if (rangeStart < mid)
				updateRange(node.getLeft(), nodeStart, mid, rangeStart, Math.min(mid, rangeEnd), value);
			if (mid < rangeEnd)
				updateRange(node.getRight(), mid, nodeEnd, Math.max(mid, rangeStart), rangeEnd, value);
			node.getData().merged = merge(node.getLeft(), node.getRight());
		}
	}

	private static int calcMiddle(int start, int end) {
		return (start + end) / 2;
	}

	private T merge(BinaryTreeNode<NodeData> left, BinaryTreeNode<NodeData> right) {
		return operator.calc(left.getData().merged, right.getData().merged);
	}

	private void makeAsLazy(BinaryTreeNode<NodeData> node, int start, int end, T value) {
		T m = Power.calc(value, end - start, operator);
		node.getData().merged = m;
		node.getData().lazy = true;
		node.getData().propagationValue = value;
	}

	private void propagateIfLazy(BinaryTreeNode<NodeData> node, int start, int end) {
		if (node.getData().lazy) {
			T value = node.getData().propagationValue;
			int mid = calcMiddle(start, end);
			makeAsLazy(node.getLeft(), start, mid, value);
			makeAsLazy(node.getRight(), mid, end, value);
			node.getData().lazy = false;
		}
	}

	@Override
	public String toString() {
		return root.toString();
	}

}