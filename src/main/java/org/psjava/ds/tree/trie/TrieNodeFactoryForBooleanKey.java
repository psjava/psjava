package org.psjava.ds.tree.trie;

import org.psjava.util.DataFilter;
import org.psjava.util.FilteredIterable;
import org.psjava.util.VarargsIterable;

public final class TrieNodeFactoryForBooleanKey {

	// specialized in speed for boolean keyed nodes.

	public static TrieNodeFactory<Boolean> getInstance() {
		return new TrieNodeFactory<Boolean>() {
			@Override
			public TrieNode<Boolean> create() {
				return new BooleanTrieNode();
			}
		};
	}
	
	private static class BooleanTrieNode implements TrieNode<Boolean> {
		
		private TrieNode<Boolean> zero, one;

		@Override
		public void putChild(Boolean ch, TrieNode<Boolean> node) {
			if(ch)
				one = node;
			else
				zero = node;
		}

		@Override
		public boolean hasChild(Boolean ch) {
			return (ch?one:zero) != null;
		}

		@Override
		public Iterable<Boolean> getEdges() {
			return FilteredIterable.create(VarargsIterable.create(false, true), new DataFilter<Boolean>() { // slow. improve when need.
				@Override
				public boolean isAccepted(Boolean v) {
					return hasChild(v);
				}
			});			
		}

		@Override
		public int getChildCount() {
			return (one==null?0:1) + (zero==null?0:1);
		}

		@Override
		public TrieNode<Boolean> getChild(Boolean ch) {
			TrieNode<Boolean> cand = getChild(ch, null);
			if(cand == null)
				throw new RuntimeException();
			return cand;
		}

		@Override
		public TrieNode<Boolean> getChild(Boolean ch, TrieNode<Boolean> def) {
			TrieNode<Boolean> cand = ch ? one : zero;
			if(cand != null)
				return cand;
			else
				return def;
		}
	}
	
	private TrieNodeFactoryForBooleanKey() {}

}