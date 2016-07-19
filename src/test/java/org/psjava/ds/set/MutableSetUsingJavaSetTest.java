package org.psjava.ds.set;

import org.junit.Test;

import java.util.HashSet;

public class MutableSetUsingJavaSetTest {

    @Test(expected = RuntimeException.class)
    public void testRemoveNotExist() {
        MutableSetUsingJavaSet<Integer> set = create();
        set.addIfAbsent(1);
        set.remove(2);
    }

    private MutableSetUsingJavaSet<Integer> create() {
        return new MutableSetUsingJavaSet<Integer>(new HashSet<Integer>());
    }

    @Test(expected = RuntimeException.class)
    public void testAddAlreadyExist() {
        MutableSetUsingJavaSet<Integer> set = create();
        set.add(1);
        set.add(1);
    }

}