package org.psjava.example;

import junit.framework.Assert;

import org.junit.Test;
import org.psjava.ds.array.MutableArrayFromValues;
import org.psjava.ds.set.MutableSet;
import org.psjava.ds.trie.Trie;
import org.psjava.ds.trie.TrieNode;
import org.psjava.goods.GoodMutableSetFactory;
import org.psjava.goods.GoodTrieFactory;

public class TrieExample {

	@Test
	public void example() {

		// Let's construct a character trie.
		// here, put three sequences.

		Trie<Character> trie = GoodTrieFactory.getInstance().create();
		trie.add(MutableArrayFromValues.create('A', '1'));
		trie.add(MutableArrayFromValues.create('A', '2'));
		trie.add(MutableArrayFromValues.create('X', 'Y', 'Z'));

		// We can get the number of children.
		// There is 2 child nodes from the root.

		int count = trie.getRoot().getChildCount();

		// To get a child node by key, use following methods.

		boolean exist = trie.getRoot().hasChild('A');
		TrieNode<Character> child = trie.getRoot().getChild('A');
		
		// To iterate available children, use getEdges() method.
		// There will be two edge('1', '2') for 'A' node.

		MutableSet<Character> edges = GoodMutableSetFactory.getInstance().create();
		for (Character c : child.getEdges()) {
			edges.insert(c);
		}

		// (assertions)
		Assert.assertEquals(2, count);
		Assert.assertTrue(exist);
		Assert.assertEquals(2, edges.size());
	}

}
