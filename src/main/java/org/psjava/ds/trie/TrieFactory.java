package org.psjava.ds.trie;

public interface TrieFactory {
	<T> Trie<T> create();
}