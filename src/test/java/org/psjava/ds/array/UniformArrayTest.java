package org.psjava.ds.array;

import org.junit.Test;

import static org.junit.Assert.*;

public class UniformArrayTest {

    @Test
    public void test() {
        assertEquals("(A,A,A)", UniformArray.create("A", 3).toString());
    }

}