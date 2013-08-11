package org.psjava.goods;

import org.psjava.ds.trie.TrieFactory;
import org.psjava.ds.trie.TrieFactoryUsingMap;

public class GoodTrieFactory {
	private static final TrieFactory INSTANCE = TrieFactoryUsingMap.create(GoodMutableMapFactory.getInstance());

	public static TrieFactory getInstance() {
		return INSTANCE;
	}
}
