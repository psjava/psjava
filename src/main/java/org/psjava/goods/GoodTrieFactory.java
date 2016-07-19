package org.psjava.goods;

import org.psjava.ds.tree.trie.TrieFactory;
import org.psjava.ds.tree.trie.TrieFactoryUsingMap;

public class GoodTrieFactory {
    private static final TrieFactory INSTANCE = TrieFactoryUsingMap.create(GoodMutableMapFactory.getInstance());

    public static TrieFactory getInstance() {
        return INSTANCE;
    }

    private GoodTrieFactory() {
    }
}
