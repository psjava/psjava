package org.psjava.algo.math;

import static org.junit.Assert.*;

import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;
import org.psjava.algo.math.PairHash;

public class PairHashTest {

    // TODO improve speed.

    @Test
    public void testRareCollision() {
        Set<Integer> set = new TreeSet<Integer>();
        for (int i = 0; i < 1000; i++)
            for (int j = 0; j < 1000; j++)
                set.add(PairHash.hash(i, j));
        assertTrue(set.size() >= 1000000 * 0.99);
    }

}
