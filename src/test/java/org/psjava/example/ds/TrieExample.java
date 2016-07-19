package org.psjava.example.ds;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.ds.array.ArrayFromVarargs;
import org.psjava.ds.tree.trie.Trie;
import org.psjava.ds.tree.trie.TrieNode;
import org.psjava.goods.GoodTrieFactory;

/**
 * @implementation {@link Trie}
 */
public class TrieExample {

    @Test
    public void example() {

        // Let's construct a character trie.
        // here, put three sequences.

        Trie<Character> trie = GoodTrieFactory.getInstance().create();
        trie.add(ArrayFromVarargs.create('A', '1'));
        trie.add(ArrayFromVarargs.create('A', '2'));
        trie.add(ArrayFromVarargs.create('X', 'Y', 'Z'));

        // We can get the number of children.
        // There is 2 child nodes from the root.

        int count = trie.getRoot().getChildCount(); // must be 2
        Assert.assertEquals(2, count);

        // To get a child node by key, use following methods.

        boolean hasChild = trie.getRoot().hasChild('A'); // must be true
        Assert.assertTrue(hasChild);

        // To iterate available children, use getEdges() method.
        // There will be two edge('1', '2') for 'A' node.

        TrieNode<Character> nodeA = trie.getRoot().getChild('A');
        for (Character c : nodeA.getEdges()) {
            TrieNode<Character> child = nodeA.getChild(c);
            Assert.assertNotNull(child);
        }
    }

}
