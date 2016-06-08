package org.psjava.ds;

import org.junit.Test;

import static org.junit.Assert.*;

public class ListUsingStringTest {

    @Test
    public void test() {
        assertEquals("[A, B, C]", ListUsingString.wrap("ABC").toString());
    }

}