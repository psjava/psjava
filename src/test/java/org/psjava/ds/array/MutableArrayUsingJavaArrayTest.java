package org.psjava.ds.array;

import org.junit.Test;

import static org.junit.Assert.*;

public class MutableArrayUsingJavaArrayTest {

    @Test
    public void test() {
        MutableArray<String> a = MutableArrayUsingJavaArray.wrap(new String[]{"A", "B", "C"});
        a.set(1, "D");
        assertEquals("(A,D,C)", a.toString());
    }

}