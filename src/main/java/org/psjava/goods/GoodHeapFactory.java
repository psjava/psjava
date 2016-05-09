package org.psjava.goods;

import org.psjava.ds.heap.BinaryHeapFactory;
import org.psjava.ds.heap.HeapFactory;

public class GoodHeapFactory {

    public static HeapFactory getInstance() {
        return BinaryHeapFactory.getInstance();
    }

}
