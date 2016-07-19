package org.psjava.goods;

import org.psjava.ds.tree.segmenttree.SegmentTreeFactory;
import org.psjava.ds.tree.segmenttree.SegmentTreeFactoryByArrayImplementation;

public class GoodSegmentTreeFactory {

    public static SegmentTreeFactory getInstance() {
        return SegmentTreeFactoryByArrayImplementation.getInstance();
    }

    private GoodSegmentTreeFactory() {
    }
}
