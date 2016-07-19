package org.psjava.example.algo;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.ds.numbersystrem.IntegerNumberSystem;
import org.psjava.formula.NumberOfTrailingZerosInFactorial;

/**
 * @implementation {@link NumberOfTrailingZerosInFactorial}
 */
public class NumberOfTrailingZerosInFactorialExample {

    @Test
    public void example() {
        // 20! = 2432902008176640000
        int res = NumberOfTrailingZerosInFactorial.calc(20, IntegerNumberSystem.getInstance()); // must be 4
        Assert.assertEquals(4, res);
    }
}
