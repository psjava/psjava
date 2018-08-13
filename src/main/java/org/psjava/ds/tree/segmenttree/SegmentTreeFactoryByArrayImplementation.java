package org.psjava.ds.tree.segmenttree;

public class SegmentTreeFactoryByArrayImplementation {

    public static SegmentTreeFactory getInstance() {
        return SegmentTreeByArrayImplementation::new;
    }

}