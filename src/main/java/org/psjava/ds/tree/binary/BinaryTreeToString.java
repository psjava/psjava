package org.psjava.ds.tree.binary;

public class BinaryTreeToString {

    public static <T> String toString(BinaryTreeNodeWithParent<T> rootOrNull) {
        if (rootOrNull == null)
            return "Empty";
        else
            return toStringRecursively(rootOrNull);
    }

    private static <T> String toStringRecursively(BinaryTreeNodeWithParent<T> root) {
        String r = root.getData().toString();
        if (root.hasLeft() || root.hasRight()) {
            r += "(";
            if (root.hasLeft())
                r += toStringRecursively(root.getLeft());
            r += ",";
            if (root.hasRight())
                r += toStringRecursively(root.getRight());
            r += ")";
        }
        return r;
    }

    private BinaryTreeToString() {
    }

}
