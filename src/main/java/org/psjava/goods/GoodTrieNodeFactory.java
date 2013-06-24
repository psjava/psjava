package org.psjava.goods;

import org.psjava.ds.trie.TrieNodeFactory;
import org.psjava.ds.trie.TrieNodeFactoryUsingMap;

public class GoodTrieNodeFactory {

	public static <T> TrieNodeFactory<T> getInstance() {
		return TrieNodeFactoryUsingMap.create(GoodMutableMapFactory.getInstance());
	}

}
