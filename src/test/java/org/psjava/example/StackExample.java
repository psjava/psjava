package org.psjava.example;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.ds.stack.GoodStackFactory;
import org.psjava.ds.stack.Stack;
import org.psjava.ds.stack.StackFactory;
import org.psjava.ds.stack.StackFactoryUsingDynamicArray;
import org.psjava.ds.stack.StackFactoryUsingLinkedList;

public class StackExample {

	@Test
	public void example() {
		StackFactory factory = StackFactoryUsingDynamicArray.getInstance();

		Stack<String> stack = factory.create();
		stack.push("A");
		stack.push("B");
		stack.push("C");

		// Here are operations

		String top = stack.top();
		boolean empty = stack.isEmpty();
		String pop1 = stack.pop();
		String pop2 = stack.pop();

		// There are several stack factories.

		StackFactoryUsingDynamicArray.getInstance();
		StackFactoryUsingLinkedList.getInstance();
		GoodStackFactory.getInstance(); // We choose the good one for you.

		Assert.assertEquals("C", top);
		Assert.assertFalse(empty);
		Assert.assertEquals("C", pop1);
		Assert.assertEquals("B", pop2);
	}
}
