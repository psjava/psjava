package org.psjava.example.algo;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.algo.sequence.search.BinarySearchFirst;
import org.psjava.algo.sequence.search.BinarySearchFirstInArray;
import org.psjava.ds.array.PSArray;
import org.psjava.ds.array.ArrayFromVarargs;
import org.psjava.ds.numbersystrem.IntegerNumberSystem;
import org.psjava.util.DefaultComparator;
import org.psjava.util.ReversedComparator;

import java.util.function.Function;

/**
 * @implementation {@link BinarySearchFirst}
 * @implementation {@link org.psjava.algo.sequence.search.BinarySearchFirstTrue}
 * @implementation {@link org.psjava.algo.sequence.search.BinarySearchFirstFalse}
 * @implementation {@link BinarySearchFirstInArray}
 * @implementation {@link org.psjava.algo.sequence.search.BinarySearchLast}
 * @implementation {@link org.psjava.algo.sequence.search.BinarySearchLastInArray}
 * @implementation {@link org.psjava.algo.sequence.search.BinarySearchLastTrue}
 * @implementation {@link org.psjava.algo.sequence.search.BinarySearchLastFalse}
 */
public class BinarySearchExample {

    @Test
    public void example() {

        // Let's search 5 in a increasingly sorted array.

        PSArray<Integer> inc = ArrayFromVarargs.create(1, 3, 5, 7, 9);
        int res1 = BinarySearchFirstInArray.search(inc, new DefaultComparator<Integer>(), 5, -1); // must be 2
        int res2 = BinarySearchFirstInArray.search(inc, new DefaultComparator<Integer>(), 6, -1); // must be -1, given by argument.
        Assert.assertEquals(2, res1);
        Assert.assertEquals(-1, res2);

        // Following is an example for decreasing array.
        // In this example, you can use a reversed comparator.

        PSArray<Integer> dec = ArrayFromVarargs.create(9, 7, 5, 3, 1);
        int res3 = BinarySearchFirstInArray.search(dec, ReversedComparator.wrap(new DefaultComparator<Integer>()), 3, -1);
        Assert.assertEquals(3, res3);

        // You don't have to prepare an array. Any function is enough.
        // Create a function 'y=8x', and let's search 'x' for 'y'=800.

        Function<Integer, Integer> f = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer x) {
                return x * 8;
            }
        };

        // x must be 100.
        int x = BinarySearchFirst.search(IntegerNumberSystem.getInstance(), f, new DefaultComparator<Integer>(), 0, 999999, 800, -1);
        Assert.assertEquals(100, x);
    }

}
