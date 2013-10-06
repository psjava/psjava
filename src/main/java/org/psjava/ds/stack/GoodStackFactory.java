package org.psjava.ds.stack;

public class GoodStackFactory {

	private static final StackFactoryUsingDynamicArray INSTANCE = new StackFactoryUsingDynamicArray();

	public static StackFactory getInstance() {
		return INSTANCE;
	}

}
