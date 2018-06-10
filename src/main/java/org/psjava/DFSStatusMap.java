package org.psjava;

import org.psjava.algo.graph.dfs.DFSStatus;

import java.util.Map;

public class DFSStatusMap<V> {

    private Map<V, DFSStatus> map = HashMapFactory.<V>create().create();

    public DFSStatus get(V v) {
        return map.getOrDefault(v, DFSStatus.NOT_DISCOVERED);
    }

    public void set(V v, DFSStatus s) {
        map.put(v, s);
    }

}
