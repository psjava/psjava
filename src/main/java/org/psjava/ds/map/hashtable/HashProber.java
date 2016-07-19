package org.psjava.ds.map.hashtable;

public interface HashProber {
    void probe(int start, int length, BucketVisitor visitor);
}