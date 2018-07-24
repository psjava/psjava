package org.psjava;

public interface MaximumBipartiteMatchingResult<V> {
    int getCount();

    boolean isMatch(V left, V right);
}
