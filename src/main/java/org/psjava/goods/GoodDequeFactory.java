package org.psjava.goods;

import org.psjava.ds.deque.DequeFactory;
import org.psjava.ds.deque.DynamicArrayDequeFactory;

public class GoodDequeFactory {
    public static DequeFactory getInstance() {
        return DynamicArrayDequeFactory.getInstance();
    }

    private GoodDequeFactory() {
    }
}
