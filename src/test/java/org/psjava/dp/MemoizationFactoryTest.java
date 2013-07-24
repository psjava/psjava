package org.psjava.dp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.psjava.goods.GoodMutableMapFactory;



public class MemoizationFactoryTest {

	MemoizationFactory instance = new MemoizationFactory(GoodMutableMapFactory.getInstance());

	@Test
	public void testFibonacci() {
		Memoization<Integer, Integer> memo = instance.create(new MemoizationFunction<Integer, Integer>() {
			@Override
			public Integer get(Integer input, Memoization<Integer, Integer> memo) {
				if(input == 0)
					return 0;
				else if(input == 1)
					return 1;
				else
					return memo.get(input-2) + memo.get(input-1);
			}
		});
		assertEquals(55, (int)memo.get(10));
	}

}
