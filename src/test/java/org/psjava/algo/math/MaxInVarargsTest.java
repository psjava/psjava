package org.psjava.algo.math;

import static org.junit.Assert.*;

import org.junit.Test;
import org.psjava.algo.math.MaxInVarargs;
import org.psjava.util.DefaultComparator;

public class MaxInVarargsTest {

	@Test
	public void max() {
		assertEquals(4, (int) MaxInVarargs.max(new DefaultComparator<Integer>(), 3, 4, 2));
	}

}
