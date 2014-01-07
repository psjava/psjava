package org.psjava.example;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.algo.math.optimization.Memoization;
import org.psjava.algo.math.optimization.MemoizationFunction;
import org.psjava.goods.GoodMemoizationFactory;
import org.psjava.util.Index2D;

public class MemoizationExample {

	@Test
	public void example() {

		// this is a memoization to calculate the factorial of n

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

		// for n=10, the result is already memoized, so super fast.
		long res2 = factorial.get(10);

		// let's be more complex. this is a memoization to calculate
		// combinations (http://en.wikipedia.org/wiki/Combination)
		// by recursion.

		Memoization<Index2D, Integer> combination = GoodMemoizationFactory.getInstance().create(new MemoizationFunction<Index2D, Integer>() {
			@Override
			public Integer get(Index2D input, Memoization<Index2D, Integer> memo) {
				int n = input.i1;
				int k = input.i2;
				if (k == 0 || n == k)
					return 1;
				else
					return memo.get(new Index2D(n - 1, k - 1)) + memo.get(new Index2D(n - 1, k));
			}
		});

		// for (10, 5), the result is 252
		int res3 = combination.get(new Index2D(10, 5));

		// these are assertions for the results.
		Assert.assertEquals(2432902008176640000L, res1);
		Assert.assertEquals(3628800, res2);
		Assert.assertEquals(252, res3);
	}

}
