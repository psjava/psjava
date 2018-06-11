package org.psjava;

import java.util.List;

public class First {
    public static <T> T first(List<T> a) {
        return a.get(0);
    }
}
