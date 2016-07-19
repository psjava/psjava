package org.psjava.ds;

import org.psjava.goods.GoodSetFactory;

import java.util.Set;

public class IntersectionOfTwoSets {

    public static <T> Set<T> create(Set<T> s1, Set<T> s2) {
        Set<T> r = GoodSetFactory.getInstance().create();
        for (T v : s2)
            if (s1.contains(v))
                r.add(v);
        return r;
    }

}
