package org.psjava.ds.tree.trie;

import org.psjava.ds.map.MutableMapFactory;

public class TrieFactoryUsingMap {

    public static TrieFactory create(final MutableMapFactory mapFactory) {
        return new TrieFactory() {
            @Override
            public <T> Trie<T> create() {
                TrieNodeFactory<T> nodeFactory = TrieNodeFactoryUsingMap.create(mapFactory);
                return new Trie<T>(nodeFactory);
            }
        };
    }

    private TrieFactoryUsingMap() {
    }

}
