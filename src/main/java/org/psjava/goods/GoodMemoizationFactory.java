package org.psjava.goods;



import org.psjava.dp.MemoizationFactory;

public class GoodMemoizationFactory {

	public static MemoizationFactory getInstance() {
		return new MemoizationFactory(GoodMutableMapFactory.getInstance());
	}

}
