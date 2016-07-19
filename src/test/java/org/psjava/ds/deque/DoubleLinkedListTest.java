package org.psjava.ds.deque;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.ds.deque.DoubleLinkedList;

public class DoubleLinkedListTest {

    @Test
    public void testEmpty() {
        DoubleLinkedList<String> a = DoubleLinkedList.create();
        Assert.assertEquals(0, a.size());
        Assert.assertEquals("()", a.toString());
    }

}
