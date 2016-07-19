package org.psjava.ds.tree.binary;

import org.psjava.util.AssertStatus;

public class BinaryTreeNodeUtil {

    public static <T> boolean isLeftChild(BinaryTreeNodeWithParent<T> node) {
        return node.getParent().hasLeft() && node.getParent().getLeft() == node;
    }

    public static <T> BinaryTreeNodeWithParent<T> getAnyChild(BinaryTreeNodeWithParent<T> node) {
        if (node.hasLeft())
            return node.getLeft();
        else
            return node.getRight();
    }

    public static <T> void replaceNode(BinaryTreeNodeWithParent<T> originalNode, BinaryTreeNodeWithParent<T> newNode) {
        BinaryTreeNodeWithParent<T> parent = originalNode.getParent();
        boolean left = isLeftChild(originalNode);
        disconnectFromParent(originalNode);
        if (left)
            connectAsLeftChild(newNode, parent);
        else
            connectAsRightChild(newNode, parent);
    }

    public static <T> void connectAsLeftChild(BinaryTreeNodeWithParent<T> node, BinaryTreeNodeWithParent<T> parent) {
        AssertStatus.assertTrue(!parent.hasLeft());
        AssertStatus.assertTrue(!node.hasParent());
        parent.putLeft(node);
        node.putParent(parent);
    }

    public static <T> void connectAsRightChild(BinaryTreeNodeWithParent<T> node, BinaryTreeNodeWithParent<T> parent) {
        AssertStatus.assertTrue(!parent.hasRight());
        AssertStatus.assertTrue(!node.hasParent());
        parent.putRight(node);
        node.putParent(parent);
    }

    public static <T> void disconnectFromParent(BinaryTreeNodeWithParent<T> node) {
        BinaryTreeNodeWithParent<T> parent = node.getParent();
        if (isLeftChild(node))
            parent.removeLeft();
        else
            parent.removeRight();
        node.removeParent();
    }

    private BinaryTreeNodeUtil() {
    }

}
