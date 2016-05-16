package org.psjava.ds.array;

import org.junit.Test;

import static org.junit.Assert.*;

public class MutableArrayUsingCharArrayTest {

    @Test
    public void test() {
        MutableArray<Character> a = MutableArrayUsingCharArray.wrap(new char[]{'A', 'B', 'C'});
        a.set(1, 'D');
        assertEquals("(A,D,C)", a.toString());
    }

}