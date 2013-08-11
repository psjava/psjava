package org.psjava.ds.tree;

import org.psjava.javautil.AssertStatus;

public class BinaryTreeNodeFactory {

	public static <T> BinaryTreeNode<T> create(final T initData) {
		return new BinaryTreeNode<T>() {

			T data = initData;
			BinaryTreeNode<T> left = null, right = null; // null if no child.

			@Override
			public T getData() {
				return data;
			}

			@Override
			public void setData(T data) {
				this.data = data;
			}

			@Override
			public boolean hasLeft() {
				return left != null;
			}

			@Override
			public boolean hasRight() {
				return right != null;
			}

			@Override
			public BinaryTreeNode<T> getLeft() {
				AssertStatus.assertTrue(hasLeft());
				return left;
			}

			@Override
			public BinaryTreeNode<T> getRight() {
				AssertStatus.assertTrue(hasRight());
				return right;
			}

			@Override
			public void putLeft(BinaryTreeNode<T> child) {
				left = child;
			}

			@Override
			public void putRight(BinaryTreeNode<T> child) {
				right = child;
			}

			@Override
			public void removeLeft() {
				AssertStatus.assertTrue(hasLeft());
				left = null;
			}

			@Override
			public void removeRight() {
				AssertStatus.assertTrue(hasRight());
				right = null;
			}

		};
	}
}
