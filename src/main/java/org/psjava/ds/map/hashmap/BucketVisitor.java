package org.psjava.ds.map.hashmap;

public interface BucketVisitor {
	boolean visitAndGetContinuity(int position);
}