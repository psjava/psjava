package org.psjava.ds.tree.binary.bst;

import org.psjava.ds.tree.binary.BinaryTreeNodeWithParent;

public class MinimumFinder {

    public static <T> BinaryTreeNodeWithParent<T> find(BinaryTreeNodeWithParent<T> node) {
        if (node.hasLeft())
            return find(node.getLeft());
        else
            return node;
    }

    private MinimumFinder() {
    }

}
