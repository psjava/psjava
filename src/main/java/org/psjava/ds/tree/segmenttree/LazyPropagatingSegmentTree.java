package org.psjava.ds.tree.segmenttree;

import org.psjava.ds.array.PSArray;
import org.psjava.ds.tree.BinaryTreeNode;
import org.psjava.ds.tree.BinaryTreeNodeFactory;

/**
 * Implemented by lazy propagation method. We did not implement in array implementation for tree.
 * <p>
 * Because in any method, we need node objects, so there is no advantage for memory allocation number.
 */

public class LazyPropagatingSegmentTree<T, U> {

    class NodeData {
        T merged;
        boolean lazy = false;
        U updateDataToBePropagate = null; // should not be null if lazy is true

        NodeData(T merged) {
            this.merged = merged;
        }
    }

    private final EnhancedRangeUpdatableSegmentTreeOperator<T, U> operator;

    private final int size;
    final BinaryTreeNode<NodeData> root;

    public LazyPropagatingSegmentTree(PSArray<T> initialData, EnhancedRangeUpdatableSegmentTreeOperator<T, U> operator) {
        this.operator = operator;
        size = initialData.size();
        if (size > 0)
            root = construct(initialData, 0, size);
        else
            root = null;
    }

    private BinaryTreeNode<NodeData> construct(PSArray<T> initialData, int start, int end) {
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

    public T queryRange(int start, int end) {
        return queryRangeRecursively(root, 0, size, start, end);
    }

    private T queryRangeRecursively(BinaryTreeNode<NodeData> node, int nodeStart, int nodeEnd, int rangeStart, int rangeEnd) {
        if (rangeStart == nodeStart && rangeEnd == nodeEnd) {
            return node.getData().merged;
        } else {
            propagateIfLazy(node, nodeStart, nodeEnd);
            int mid = calcMiddle(nodeStart, nodeEnd);
            if (rangeEnd <= mid)
                return queryRangeRecursively(node.getLeft(), nodeStart, mid, rangeStart, rangeEnd);
            else if (mid <= rangeStart)
                return queryRangeRecursively(node.getRight(), mid, nodeEnd, rangeStart, rangeEnd);
            else
                return operator.mergeSingleValue(queryRangeRecursively(node.getLeft(), nodeStart, mid, rangeStart, mid), queryRangeRecursively(node.getRight(), mid, nodeEnd, mid, rangeEnd));
        }
    }

    public void updateRange(int start, int end, U updateData) {
        updateRangeRecursively(root, 0, size, start, end, updateData);
    }

    private void updateRangeRecursively(BinaryTreeNode<NodeData> node, int nodeStart, int nodeEnd, int start, int end, U updateData) {
        if (start == nodeStart && end == nodeEnd) {
            makeAsLazy(node, start, end, updateData);
        } else {
            propagateIfLazy(node, nodeStart, nodeEnd);
            int mid = calcMiddle(nodeStart, nodeEnd);
            if (start < mid)
                updateRangeRecursively(node.getLeft(), nodeStart, mid, start, Math.min(mid, end), updateData);
            if (mid < end)
                updateRangeRecursively(node.getRight(), mid, nodeEnd, Math.max(mid, start), end, updateData);
            node.getData().merged = merge(node.getLeft(), node.getRight());
        }
    }

    private static int calcMiddle(int start, int end) {
        return (start + end) / 2;
    }

    private T merge(BinaryTreeNode<NodeData> left, BinaryTreeNode<NodeData> right) {
        return operator.mergeSingleValue(left.getData().merged, right.getData().merged);
    }

    private void makeAsLazy(BinaryTreeNode<NodeData> node, int start, int end, U updateData) {
        NodeData data = node.getData();
        T m = operator.mergeRangeValue(data.merged, end - start, updateData);
        data.merged = m;
        if (!data.lazy)
            data.updateDataToBePropagate = updateData;
        else
            data.updateDataToBePropagate = operator.mergeUpdateData(data.updateDataToBePropagate, updateData);
        data.lazy = true;
    }

    private void propagateIfLazy(BinaryTreeNode<NodeData> node, int start, int end) {
        if (node.getData().lazy) {
            if (end - start > 1) {
                U value = node.getData().updateDataToBePropagate;
                int mid = calcMiddle(start, end);
                makeAsLazy(node.getLeft(), start, mid, value);
                makeAsLazy(node.getRight(), mid, end, value);
            }
            node.getData().lazy = false;
            node.getData().updateDataToBePropagate = null;
        }
    }

    @Override
    public String toString() {
        return root.toString();
    }

}
