package org.psjava.util;

public class Java1DArrayFiller {

    public static <T> void fill(T[] array, T value) {
        for (int i = 0; i < array.length; i++)
            array[i] = value;
    }

    private Java1DArrayFiller() {
    }

}
