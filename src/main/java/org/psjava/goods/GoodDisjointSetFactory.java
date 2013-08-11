package org.psjava.goods;

import org.psjava.ds.set.DisjointSet;
import org.psjava.ds.set.DisjointSetFactory;
import org.psjava.ds.set.DisjointSetForest;

public class GoodDisjointSetFactory {

	private static final DisjointSetFactory INSTANCE = new DisjointSetFactory() {
		@Override
		public <T> DisjointSet<T> create() {
			return DisjointSetForest.create(GoodMutableMapFactory.getInstance());
		}
	};

	public static DisjointSetFactory getInstance() {
		return INSTANCE;
	}

}
