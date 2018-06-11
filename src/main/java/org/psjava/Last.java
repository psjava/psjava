package org.psjava;

import java.util.List;

public class Last {
    public static <T> T last(List<T> a) {
        return a.get(a.size() - 1);
    }
}
