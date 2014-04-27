package org.psjava.ds.stack;

public class GoodStackFactory {

	private static final StackFactory INSTANCE = StackFactoryUsingDynamicArray.getInstance();

	public static StackFactory getInstance() {
		return INSTANCE;
	}

	private GoodStackFactory() {
	}

}
