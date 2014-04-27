package org.psjava.ds.tree.binary;

import org.psjava.util.AssertStatus;

public class BinaryTreeNodeWithParentFactory {

	public static <T> BinaryTreeNodeWithParent<T> create(final T initData) {
		return new BinaryTreeNodeWithParent<T>() {

			T data = initData;
			BinaryTreeNodeWithParent<T> parentOrNull;
			BinaryTreeNodeWithParent<T> leftOrNull = null, rightOrNull = null; // null if no child.

			@Override
			public T getData() {
				return data;
			}

			@Override
			public void setData(T data) {
				this.data = data;
			}

			@Override
			public boolean hasParent() {
				return parentOrNull != null;
			}

			@Override
			public BinaryTreeNodeWithParent<T> getParent() {
				AssertStatus.assertTrue(hasParent());
				return parentOrNull;
			}

			@Override
			public void removeParent() {
				AssertStatus.assertTrue(parentOrNull != null);
				parentOrNull = null;
			}

			@Override
			public void putParent(BinaryTreeNodeWithParent<T> parent) {
				AssertStatus.assertTrue(parent != null);
				parentOrNull = parent;
			}

			@Override
			public boolean hasLeft() {
				return leftOrNull != null;
			}

			@Override
			public boolean hasRight() {
				return rightOrNull != null;
			}

			@Override
			public BinaryTreeNodeWithParent<T> getLeft() {
				AssertStatus.assertTrue(hasLeft());
				return leftOrNull;
			}

			@Override
			public BinaryTreeNodeWithParent<T> getRight() {
				AssertStatus.assertTrue(hasRight());
				return rightOrNull;
			}

			@Override
			public void putLeft(BinaryTreeNodeWithParent<T> child) {
				leftOrNull = child;
			}

			@Override
			public void putRight(BinaryTreeNodeWithParent<T> child) {
				rightOrNull = child;
			}

			@Override
			public void removeLeft() {
				AssertStatus.assertTrue(hasLeft());
				leftOrNull = null;
			}

			@Override
			public void removeRight() {
				AssertStatus.assertTrue(hasRight());
				rightOrNull = null;
			}

		};
	}

	private BinaryTreeNodeWithParentFactory() {
	}
}
