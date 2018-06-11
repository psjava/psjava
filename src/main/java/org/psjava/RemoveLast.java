package org.psjava;

import java.util.List;

public class RemoveLast {
    public static <V> void removeLast(List<V> path) {
        path.remove(path.size() - 1);
    }
}
