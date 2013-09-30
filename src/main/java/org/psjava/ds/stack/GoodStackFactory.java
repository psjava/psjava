package org.psjava.ds.stack;


public class GoodStackFactory {

	public static StackFactory getInstance() {
		return new StackFactoryUsingDynamicArray();
	}

}
