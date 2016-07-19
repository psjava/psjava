package org.psjava.ds.tree.trie;

import org.psjava.ds.map.KeysInMap;
import org.psjava.ds.map.MutableMap;
import org.psjava.ds.map.MutableMapFactory;

public class TrieNodeFactoryUsingMap {

    public static <T> TrieNodeFactory<T> create(final MutableMapFactory mapFactory) {
        return new TrieNodeFactory<T>() {
            @Override
            public TrieNode<T> create() {
                return new Node<T>(mapFactory);
            }
        };
    }

    private static class Node<T> implements TrieNode<T> {

        private final MutableMap<T, TrieNode<T>> children;

        public Node(MutableMapFactory mapFactory) {
            children = mapFactory.create();
        }

        @Override
        public boolean hasChild(T ch) {
            return children.containsKey(ch);
        }

        @Override
        public TrieNode<T> getChildOrNull(T ch) {
            return children.getOrNull(ch);
        }

        @Override
        public void putChild(T ch, TrieNode<T> node) {
            children.addOrReplace(ch, node);
        }

        @Override
        public int getChildCount() {
            return children.size();
        }

        @Override
        public TrieNode<T> getChild(T ch) {
            return children.get(ch);
        }

        @Override
        public Iterable<T> getEdges() {
            return KeysInMap.get(children);
        }

    }

    private TrieNodeFactoryUsingMap() {
    }

}
