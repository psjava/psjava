package org.psjava.example.algo;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.IntPair;
import org.psjava.algo.math.optimization.Memoization;
import org.psjava.algo.math.optimization.MemoizationFactory;
import org.psjava.algo.math.optimization.MemoizationFunction;
import org.psjava.goods.GoodMemoizationFactory;

/**
 * @implementation {@link MemoizationFactory}
 */
public class MemoizationExample {

    @Test
    public void example() {

        // This is a memoization to calculate the factorial of n

        Memoization<Integer, Long> factorial = GoodMemoizationFactory.getInstance().create(new MemoizationFunction<Integer, Long>() {
            @Override
            public Long get(Integer input, Memoization<Integer, Long> memo) {
                if (input == 0)
                    return 1L;
                else
                    return input * memo.get(input - 1);
            }
        });

        // for n=20, the result is 2432902008176640000
        long res1 = factorial.get(20);
        Assert.assertEquals(2432902008176640000L, res1);

        // for n=10, the result is already memoized, so super fast.
        long res2 = factorial.get(10);
        Assert.assertEquals(3628800, res2);

        // let's be more complex. this is a memoization to calculate
        // combinations by recursion. (http://en.wikipedia.org/wiki/Combination)

        Memoization<IntPair, Integer> combination = GoodMemoizationFactory.getInstance().create((input, self) -> {
            int n = input.v1;
            int k = input.v2;
            if (k == 0 || n == k)
                return 1;
            else
                return self.get(new IntPair(n - 1, k - 1)) + self.get(new IntPair(n - 1, k));
        });

        int res3 = combination.get(new IntPair(10, 5)); // for (10, 5), the result is 252
        Assert.assertEquals(252, res3);
    }

}
