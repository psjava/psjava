package org.psjava.util;

public class Emptiness {

    public static <T> boolean is(Iterable<T> items) {
        return items.iterator().hasNext();
    }

}
