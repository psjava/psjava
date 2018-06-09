package org.psjava.ds.array;

public class FirstInArray {

    public static <T> T getFirst(PSArray<T> a) {
        return a.get(0);
    }

    private FirstInArray() {
    }

}
