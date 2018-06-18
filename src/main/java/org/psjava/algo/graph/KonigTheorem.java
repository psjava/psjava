package org.psjava.algo.graph;

import org.psjava.MaximumBipartiteMatching;
import org.psjava.ds.graph.BipartiteGraph;

// implementation : Konig theorem
// TODO rename MinimumVertexCover
public class KonigTheorem {

    public static <V> int calculate(BipartiteGraph<V> bg) {
        return MaximumBipartiteMatching.calculate(bg);
    }

}
