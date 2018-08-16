package org.psjava.goods;

import org.psjava.ds.tree.segmenttree.SegmentTreeByArrayImplementation;
import org.psjava.ds.tree.segmenttree.SegmentTreeFactory;

public class GoodSegmentTreeFactory {

    public static SegmentTreeFactory getInstance() {
        return SegmentTreeByArrayImplementation::new;
    }

}
