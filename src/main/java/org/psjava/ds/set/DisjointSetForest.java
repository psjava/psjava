package org.psjava.ds.set;

import org.psjava.ds.map.MutableMap;
import org.psjava.goods.GoodMutableMapFactory;

/**
 * see http://en.wikipedia.org/wiki/Disjoint-set_data_structure
 */

public class DisjointSetForest<T> implements DisjointSet<T> {

    private static class NodeInfo<T> {
        T parent;
        int rank;

        NodeInfo(T p, int rank) {
            this.parent = p;
            this.rank = rank;
        }
    }

    final MutableMap<T, NodeInfo<T>> nodeInfo = GoodMutableMapFactory.getInstance().create();

    @Override
    public void makeSet(T value) {
        nodeInfo.add(value, new NodeInfo<T>(value, 0));
    }

    @Override
    public void union(T x, T y) {
        T xrep = find(x);
        T yrep = find(y);
        if (xrep == yrep)
            return;
        NodeInfo<T> xinfo = nodeInfo.get(xrep);
        NodeInfo<T> yinfo = nodeInfo.get(yrep);
        if (xinfo.rank > yinfo.rank) {
            yinfo.parent = xrep;
        } else {
            xinfo.parent = yrep;
            if (xinfo.rank == yinfo.rank)
                yinfo.rank++;
        }
    }

    @Override
    public T find(T x) {
        NodeInfo<T> info = nodeInfo.get(x);
        if (!info.parent.equals(x))
            info.parent = find(info.parent);
        return info.parent;
    }

}
