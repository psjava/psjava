package org.psjava.ds.tree.trie;

import org.psjava.util.ConvertedIterable;
import org.psjava.util.Converter;
import org.psjava.util.StringMerger;

public class Trie<T> {

    private final TrieNodeFactory<T> factory;
    private final TrieNode<T> root;

    public Trie(TrieNodeFactory<T> nodeFactory) {
        this.factory = nodeFactory;
        root = factory.create();
    }

    public void add(Iterable<T> sequence) {
        TrieNode<T> cur = root;
        for (T v : sequence) {
            TrieNode<T> subTrie = cur.getChildOrNull(v);
            if (subTrie == null) {
                subTrie = factory.create();
                cur.putChild(v, subTrie);
            }
            cur = subTrie;
        }
    }

    public TrieNode<T> getRoot() {
        return root;
    }

    @Override
    public String toString() {
        return getNodeString(root);
    }

    private String getNodeString(final TrieNode<T> node) {
        String r = "";
        if (node == root)
            r += "Trie";
        if (node.getChildCount() > 0) {
            r += "(";
            r += StringMerger.merge(ConvertedIterable.create(node.getEdges(), new Converter<T, String>() {
                @Override
                public String convert(T c) {
                    return c + getNodeString(node.getChild(c));
                }
            }), ",");
            r += ")";
        }
        return r;
    }

}
