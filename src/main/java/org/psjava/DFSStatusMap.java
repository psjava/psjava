package org.psjava;

import org.psjava.algo.graph.dfs.DFSStatus;
import org.psjava.ds.map.MutableMap;
import org.psjava.goods.GoodMutableMapFactory;

public class DFSStatusMap<V> {

    private MutableMap<V, DFSStatus> map = GoodMutableMapFactory.getInstance().create(); // TODO to Map

    public DFSStatus get(V v) {
        DFSStatus dfsStatus = map.getOrNull(v);
        if (dfsStatus != null) {
            return dfsStatus;
        } else {
            return DFSStatus.NOT_DISCOVERED;
        }
    }

    public void set(V v, DFSStatus s) {
        map.addOrReplace(v, s);
    }

}
