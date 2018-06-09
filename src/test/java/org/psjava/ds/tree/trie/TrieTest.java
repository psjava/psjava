package org.psjava.ds.tree.trie;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.ds.array.PSArray;
import org.psjava.ds.array.CharacterArrayUsingString;
import org.psjava.goods.GoodTrieNodeFactory;

public class TrieTest {

    @Test
    public void testSize() {
        Trie<Character> trie = new Trie<Character>(GoodTrieNodeFactory.<Character>getInstance());
        trie.add(toArray("AAB"));
        trie.add(toArray("AAC"));
        Assert.assertEquals(1, trie.getRoot().getChildCount());
        Assert.assertEquals(1, trie.getRoot().getChild('A').getChildCount());
        Assert.assertEquals(2, trie.getRoot().getChild('A').getChild('A').getChildCount());
    }

    private PSArray<Character> toArray(String s) {
        return CharacterArrayUsingString.wrap(s);
    }

}
