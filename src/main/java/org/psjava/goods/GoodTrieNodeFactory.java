package org.psjava.goods;

import org.psjava.ds.tree.trie.TrieNodeFactory;
import org.psjava.ds.tree.trie.TrieNodeFactoryUsingMap;

public class GoodTrieNodeFactory {

    public static <T> TrieNodeFactory<T> getInstance() {
        return TrieNodeFactoryUsingMap.create(GoodMutableMapFactory.getInstance());
    }

    private GoodTrieNodeFactory() {
    }

}
