package org.psjava;

import org.psjava.ds.tree.BinaryTreeByArray;
import org.psjava.util.Assertion;

import java.util.List;
import java.util.function.BinaryOperator;

/**
 * This class is for only simple replacement updating. This class has an advantage of BinaryTreeByArray's speed.
 */

public class SegmentTree<T> {

    private final BinaryOperator<T> merger;
    private final BinaryTreeByArray<T> tree;
    private final int size;

    public SegmentTree(final List<T> initialData, final BinaryOperator<T> merger) {
        this.merger = merger;
        size = initialData.size();
        tree = new BinaryTreeByArray<>();
        if (!initialData.isEmpty()) {
            int root = tree.createRoot(initialData.get(0));
            construct(root, initialData, 0, initialData.size());
        }
    }

    private void construct(int node, List<T> initialData, int start, int end) {
        if (end - start == 1) {
            tree.setValue(node, initialData.get(start));
        } else {
            T any = initialData.get(0);
            int mid = (start + end) / 2;
            int left = tree.putChild(node, false, any);
            int right = tree.putChild(node, true, any);
            construct(left, initialData, start, mid);
            construct(right, initialData, mid, end);
            tree.setValue(node, merger.apply(tree.getValue(left), tree.getValue(right)));
        }
    }

    public T query(int start, int end) {
        Assertion.ensure(start < end && end <= size, () -> "invalid range start=" + start + ", end=" + end);
        return queryRecursively(tree.getRootPointer(), 0, size, start, end);
    }

    private T queryRecursively(int node, int nodeStart, int nodeEnd, int start, int end) {
        if (nodeStart == start && nodeEnd == end) {
            return tree.getValue(node);
        } else {
            int mid = (nodeStart + nodeEnd) / 2;
            if (end <= mid)
                return queryRecursively(tree.getLeft(node), nodeStart, mid, start, end);
            else if (mid <= start)
                return queryRecursively(tree.getRight(node), mid, nodeEnd, start, end);
            else
                return merger.apply(queryRecursively(tree.getLeft(node), nodeStart, mid, start, mid), queryRecursively(tree.getRight(node), mid, nodeEnd, mid, end));
        }
    }

    public void update(int position, T value) {
        Assertion.ensure(position < size);
        updateRecursively(tree.getRootPointer(), 0, size, position, value);
    }

    private void updateRecursively(int node, int nodeStart, int nodeEnd, int position, T value) {
        if (nodeEnd - nodeStart == 1) {
            tree.setValue(node, value);
        } else {
            int left = tree.getLeft(node);
            int right = tree.getRight(node);
            int mid = (nodeStart + nodeEnd) / 2;
            if (position < mid)
                updateRecursively(left, nodeStart, mid, position, value);
            else
                updateRecursively(right, mid, nodeEnd, position, value);
            tree.setValue(node, merger.apply(tree.getValue(left), tree.getValue(right)));
        }
    }
}