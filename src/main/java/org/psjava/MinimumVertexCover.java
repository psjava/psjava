package org.psjava;

// implementation : Konig theorem
public class MinimumVertexCover {

    public static <V> int calculate(BipartiteGraph<V> bg) {
        return MaximumBipartiteMatching.calculate(bg).getCount();
    }

}
