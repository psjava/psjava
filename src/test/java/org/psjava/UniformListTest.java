package org.psjava;

import org.junit.Test;
import org.psjava.UniformList;

import static org.junit.Assert.assertEquals;

public class UniformListTest {

    @Test
    public void test() {
        assertEquals("[A, A, A]", UniformList.create("A", 3).toString());
    }

}