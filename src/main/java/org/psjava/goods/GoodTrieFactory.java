package org.psjava.goods;

import org.psjava.ds.trie.TrieFactory;
import org.psjava.ds.trie.TrieFactoryUsingMap;

public class GoodTrieFactory {
	public static TrieFactory getInstance() {
		return TrieFactoryUsingMap.create(GoodMutableMapFactory.getInstance());
	}
}
