package org.psjava.ds.array;

import org.junit.Test;

import static org.junit.Assert.*;

public class CharacterArrayUsingStringTest {

    @Test
    public void test() {
        assertEquals("(A,B,C)", CharacterArrayUsingString.wrap("ABC").toString());
    }

}