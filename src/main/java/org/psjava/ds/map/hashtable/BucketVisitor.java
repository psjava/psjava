package org.psjava.ds.map.hashtable;

public interface BucketVisitor {
    boolean visitAndGetContinuity(int position);
}