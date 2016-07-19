package org.psjava.ds.tree.trie;

public interface TrieFactory {
    <T> Trie<T> create();
}