package org.psjava.util;

public class Java1DArray {

    @SuppressWarnings("unchecked")
    public static <T> T[] create(Class<?> clazz, int n) {
        return (T[]) java.lang.reflect.Array.newInstance(clazz, n);
    }

    private Java1DArray() {
    }

}
