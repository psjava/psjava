package org.psjava.util;

public class DataKeeper<T> {

    public static <T> DataKeeper<T> create(T v) {
        return new DataKeeper<T>(v);
    }

    private T v;

    public DataKeeper(T v) {
        this.v = v;
    }

    public void set(T v) {
        this.v = v;
    }

    public T get() {
        return v;
    }
}
