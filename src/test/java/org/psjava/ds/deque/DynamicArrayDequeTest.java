package org.psjava.ds.deque;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.ds.array.ArrayFromVarargs;
import org.psjava.util.IterableToString;

public class DynamicArrayDequeTest {

    @Test
    public void testExtendingByAddToLast() {
        DynamicArrayDeque<String> q = new DynamicArrayDeque<String>();
        q.addToLast("A");
        Assert.assertEquals(0, q.start);
        Assert.assertEquals(1, q.end);
        Assert.assertEquals(2, q.array.length);
        q.addToLast("B");
        Assert.assertEquals(4, q.array.length);
        q.addToLast("C");
        Assert.assertEquals("(A,B,C,null)", IterableToString.toString(ArrayFromVarargs.create(q.array)));
    }

    @Test
    public void testExtendingByAddToFront() {
        DynamicArrayDeque<String> q = new DynamicArrayDeque<String>();
        q.addToFirst("A");
        Assert.assertEquals(0, q.start);
        Assert.assertEquals(1, q.end);
        Assert.assertEquals(2, q.array.length);
        q.addToFirst("B");
        q.addToFirst("C");
        Assert.assertEquals(4, q.array.length);
        Assert.assertEquals("(B,A,null,C)", IterableToString.toString(ArrayFromVarargs.create(q.array)));
    }

    @Test
    public void testSimpleScenario() {
        DynamicArrayDeque<String> q = new DynamicArrayDeque<String>();
        q.addToFirst("A");
        q.addToLast("B");
        Assert.assertEquals("A", q.getFirst());
        Assert.assertEquals("B", q.getLast());
    }

}
