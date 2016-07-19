package org.psjava.ds.tree.binary.bst;

import java.util.Comparator;
import java.util.Iterator;

import org.psjava.ds.KeyValuePair;
import org.psjava.ds.tree.binary.BinaryTreeNodeUtil;
import org.psjava.ds.tree.binary.BinaryTreeNodeWithParent;
import org.psjava.ds.tree.binary.BinaryTreeNodeWithParentFactory;
import org.psjava.ds.tree.binary.BinaryTreeToString;
import org.psjava.ds.tree.binary.InOrderIterator;

public class BinarySearchTree<K, V> {

    public static class NodeData<K, V> implements KeyValuePair<K, V> {
        public final K key;
        public V value;

        public NodeData(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }
    }

    private final Comparator<K> comparator;
    private BinaryTreeNodeWithParent<NodeData<K, V>> rootOrNull = null;

    public BinarySearchTree(Comparator<K> comparator) {
        this.comparator = comparator;
    }

    public InsertionResult insertOrUpdate(K key, V value) {
        if (rootOrNull == null) {
            rootOrNull = BinaryTreeNodeWithParentFactory.create(new NodeData<K, V>(key, value));
            return InsertionResult.INSERTED;
        } else {
            return insertOrUpdateRecursively(rootOrNull, key, value);
        }
    }

    private InsertionResult insertOrUpdateRecursively(BinaryTreeNodeWithParent<NodeData<K, V>> node, K key, V value) {
        int comp = comparator.compare(key, node.getData().key);
        if (comp == 0) {
            node.setData(new NodeData<K, V>(key, value));
            return InsertionResult.UPDATED;
        } else if (comp < 0) {
            if (node.hasLeft()) {
                return insertOrUpdateRecursively(node.getLeft(), key, value);
            } else {
                BinaryTreeNodeUtil.connectAsLeftChild(BinaryTreeNodeWithParentFactory.create(new NodeData<K, V>(key, value)), node);
                return InsertionResult.INSERTED;
            }
        } else {
            if (node.hasRight()) {
                return insertOrUpdateRecursively(node.getRight(), key, value);
            } else {
                BinaryTreeNodeUtil.connectAsRightChild(BinaryTreeNodeWithParentFactory.create(new NodeData<K, V>(key, value)), node);
                return InsertionResult.INSERTED;
            }
        }
    }

    public KeyValuePair<K, V> findPairOrNull(K key) {
        BinaryTreeNodeWithParent<NodeData<K, V>> node = findNodeOrNull(key);
        if (node == null)
            return null;
        return node.getData();
    }

    protected BinaryTreeNodeWithParent<NodeData<K, V>> findNodeOrNull(K key) {
        if (rootOrNull == null)
            return null;
        else
            return findNodeOrNullRecursively(rootOrNull, key);

    }

    private BinaryTreeNodeWithParent<NodeData<K, V>> findNodeOrNullRecursively(BinaryTreeNodeWithParent<NodeData<K, V>> node, K key) {
        int comp = comparator.compare(node.getData().key, key);
        if (comp == 0) {
            return node;
        } else if (comp < 0) {
            if (node.hasRight())
                return findNodeOrNullRecursively(node.getRight(), key);
            else
                return null;
        } else {
            if (node.hasLeft())
                return findNodeOrNullRecursively(node.getLeft(), key);
            else
                return null;
        }
    }

    public RemoveResult removeIfExist(K key) {
        BinaryTreeNodeWithParent<NodeData<K, V>> node = findNodeOrNull(key);
        if (node == null)
            return RemoveResult.NOT_EXIST;
        if (!node.hasLeft() && !node.hasRight()) {
            if (rootOrNull == node)
                rootOrNull = null;
            else
                BinaryTreeNodeUtil.disconnectFromParent(node);
        } else if (node.hasLeft() && node.hasRight()) {
            BinaryTreeNodeWithParent<NodeData<K, V>> successor = MinimumFinder.find(node.getRight());
            node.setData(successor.getData());
            if (successor.hasRight()) {
                BinaryTreeNodeWithParent<NodeData<K, V>> right = successor.getRight();
                BinaryTreeNodeUtil.disconnectFromParent(right);
                BinaryTreeNodeUtil.replaceNode(successor, right);
            } else {
                BinaryTreeNodeUtil.disconnectFromParent(successor);
            }
        } else {
            BinaryTreeNodeWithParent<NodeData<K, V>> child = BinaryTreeNodeUtil.getAnyChild(node);
            BinaryTreeNodeUtil.disconnectFromParent(child);
            if (rootOrNull == node)
                rootOrNull = child;
            else
                BinaryTreeNodeUtil.replaceNode(node, child);
        }
        return RemoveResult.REMOVED;
    }

    public void clear() {
        rootOrNull = null;
    }

    public Iterator<KeyValuePair<K, V>> getInOrderIterator() {
        return InOrderIterator.<KeyValuePair<K, V>, NodeData<K, V>>create(rootOrNull);
    }

    @Override
    public String toString() {
        return BinaryTreeToString.toString(rootOrNull);
    }

}
