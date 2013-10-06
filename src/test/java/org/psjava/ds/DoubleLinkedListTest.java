package org.psjava.ds;

import org.junit.Assert;
import org.junit.Test;


public class DoubleLinkedListTest {

	@Test
	public void testEmpty() {
		DoubleLinkedList<String> a = DoubleLinkedList.create();
		Assert.assertEquals(0, a.size());
		Assert.assertEquals("()", a.toString());
	}

}
