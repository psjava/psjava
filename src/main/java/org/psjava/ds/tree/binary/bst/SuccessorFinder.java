package org.psjava.ds.tree.binary.bst;

import org.psjava.ds.tree.binary.BinaryTreeNodeUtil;
import org.psjava.ds.tree.binary.BinaryTreeNodeWithParent;

public class SuccessorFinder {

    public static <T> BinaryTreeNodeWithParent<T> findOrNull(final BinaryTreeNodeWithParent<T> node) {
        if (node.hasRight())
            return MinimumFinder.find(node.getRight());
        else
            return findLowestBiggerKeyAncestorOrNullRecursively(node);
    }

    private static <T> BinaryTreeNodeWithParent<T> findLowestBiggerKeyAncestorOrNullRecursively(BinaryTreeNodeWithParent<T> node) {
        if (node.hasParent()) {
            if (BinaryTreeNodeUtil.isLeftChild(node))
                return node.getParent();
            else
                return findLowestBiggerKeyAncestorOrNullRecursively(node.getParent());
        } else {
            return null;
        }
    }

    private SuccessorFinder() {
    }

}
