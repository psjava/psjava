package org.psjava.ds.tree;

import org.junit.Assert;
import org.junit.Test;

public class BinaryTreeByArrayTest {
    @Test
    public void test() {
        BinaryTreeByArray<String> tree = new BinaryTreeByArray<String>();
        int a = tree.createRoot("A");
        int b = tree.putChild(a, false, "B");
        tree.putChild(a, true, "C");
        tree.putChild(b, true, "D");
        Assert.assertEquals("A(0:B(1:D),1:C)", tree.toString());
        tree.remove(b);
        Assert.assertEquals("A(1:C)", tree.toString());
    }
}
