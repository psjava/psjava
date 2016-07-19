package org.psjava.ds.tree.binary.bst;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.util.DefaultComparator;
import org.psjava.util.IteratorToString;

public class BinarySearchTreeTest {

    @Test
    public void testInsertOrUpdate() {
        BinarySearchTree<Integer, Integer> tree = create();
        Assert.assertEquals("Empty", tree.toString());
        insertOrUpdate(tree, 5, 9);
        tree.insertOrUpdate(6, 666);
        tree.insertOrUpdate(6, 777);
        Assert.assertEquals("5=5(,9=9(6=777,))", tree.toString());
    }

    @Test
    public void testFindNodeOrNull() {
        BinarySearchTree<Integer, Integer> tree = create();
        insertOrUpdate(tree, 5, 9, 6);
        Assert.assertNotNull(tree.findNodeOrNull(5));
        Assert.assertNotNull(tree.findNodeOrNull(9));
        Assert.assertNotNull(tree.findNodeOrNull(6));
        Assert.assertNull(tree.findNodeOrNull(3));
    }

    @Test
    public void testInOrderIterator() {
        BinarySearchTree<Integer, Integer> tree = create();
        insertOrUpdate(tree, 5, 9, 6);
        String r = IteratorToString.toString(tree.getInOrderIterator());
        Assert.assertEquals("(5=5,6=6,9=9)", r);
    }

    @Test
    public void testRemovingFullChildAndSimpleSuccesor() {
        BinarySearchTree<Integer, Integer> tree = create();
        insertOrUpdate(tree, 3, 2, 4);
        tree.removeIfExist(3);
        Assert.assertEquals("4=4(2=2,)", tree.toString());
    }

    @Test
    public void testRemovingFullChildAndComplexSuccesor() {
        BinarySearchTree<Integer, Integer> tree = create();
        insertOrUpdate(tree, 3, 2, 4, 5);
        tree.removeIfExist(3);
        Assert.assertEquals("4=4(2=2,5=5)", tree.toString());
    }

    @Test
    public void testRemoveByMovingToSuccessor() {
        BinarySearchTree<Integer, Integer> tree = create();
        insertOrUpdate(tree, 5, 3, 4);
        tree.removeIfExist(4);
        Assert.assertEquals("5=5(3=3,)", tree.toString());
    }

    @Test
    public void testRemoveOneChildNode() {
        BinarySearchTree<Integer, Integer> tree = create();
        insertOrUpdate(tree, 3, 4, 5);
        tree.removeIfExist(4);
        Assert.assertEquals("3=3(,5=5)", tree.toString());
    }

    @Test
    public void testRemoveNotExistKey() {
        RemoveResult actual = create().removeIfExist(99);
        Assert.assertEquals(RemoveResult.NOT_EXIST, actual);
    }

    @Test
    public void testRemoveRoot() {
        BinarySearchTree<Integer, Integer> tree = create();
        insertOrUpdate(tree, 3, 4);
        tree.removeIfExist(3);
        Assert.assertEquals("4=4", tree.toString());
        tree.removeIfExist(4);
        Assert.assertEquals("Empty", tree.toString());
    }

    private static BinarySearchTree<Integer, Integer> create() {
        return new BinarySearchTree<Integer, Integer>(new DefaultComparator<Integer>());
    }

    private static void insertOrUpdate(BinarySearchTree<Integer, Integer> tree, int... a) {
        for (int v : a)
            tree.insertOrUpdate(v, v);
    }

}
