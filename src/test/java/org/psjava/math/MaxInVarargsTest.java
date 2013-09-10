package org.psjava.math;

import static org.junit.Assert.*;

import org.junit.Test;
import org.psjava.javautil.DefaultComparator;
import org.psjava.math.MaxInVarargs;

public class MaxInVarargsTest {

	@Test
	public void max() {
		assertEquals(4, (int) MaxInVarargs.max(new DefaultComparator<Integer>(), 3, 4, 2));
	}

}
