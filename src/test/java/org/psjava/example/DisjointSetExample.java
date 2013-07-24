package org.psjava.example;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.ds.set.DisjointSet;
import org.psjava.ds.set.DisjointSetForest;
import org.psjava.goods.GoodMutableMapFactory;

public class DisjointSetExample {
	
	@Test
	public void example() {

		DisjointSet<String> dset = DisjointSetForest.create(GoodMutableMapFactory.getInstance());

		dset.makeSet("A");
		dset.makeSet("B");
		dset.makeSet("C");
		dset.makeSet("D");

		dset.union("C", "D");
		
		// Two representiatives are now same.

		String rep1 = dset.find("C");
		String rep2 = dset.find("D");
		Assert.assertEquals(rep1, rep2);
	}

}
