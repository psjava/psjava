package org.psjava.ds.trie;
import org.psjava.javautil.ZeroTo;


public class Trie<T> {
	
	private final TrieNodeFactory<T> factory;
	private final TrieNode<T> root;

	public Trie(TrieNodeFactory<T> nodeFactory) {
		this.factory = nodeFactory;
		root = factory.create();
	}
	
	public void add(Iterable<T> sequence) {
		TrieNode<T> cur = root;
		for(T v : sequence) {
			TrieNode<T> subTrie = cur.getChild(v, null);
			if(subTrie == null) {
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
		StringBuilder sb = new StringBuilder();
		toString(root, 0, sb);		
		return sb.toString();
	}

	private void toString(TrieNode<T> node, int level, StringBuilder sb) {
		for(T c : node.getEdges()) {
			for (@SuppressWarnings("unused")
			int i : ZeroTo.get(level))
				sb.append(" ");
			sb.append(c + "\n");
			toString(node.getChild(c), level+1, sb);
		}
	}

}
