package org.psjava.ds.tree.binary;

public interface BinaryTreeNodeWithParent<T> {

    T getData();

    void setData(T data);

    boolean hasParent();

    BinaryTreeNodeWithParent<T> getParent();

    void putParent(BinaryTreeNodeWithParent<T> parent);

    void removeParent();

    boolean hasLeft();

    boolean hasRight();

    BinaryTreeNodeWithParent<T> getLeft();

    BinaryTreeNodeWithParent<T> getRight();

    void putLeft(BinaryTreeNodeWithParent<T> child);

    void putRight(BinaryTreeNodeWithParent<T> child);

    void removeLeft();

    void removeRight();
}
