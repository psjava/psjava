package org.psjava.ds.map.hashmap;

public interface HashProber {
	void probe(int start, int length, BucketVisitor visitor);
}