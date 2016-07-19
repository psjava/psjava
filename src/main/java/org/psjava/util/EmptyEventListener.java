package org.psjava.util;

public class EmptyEventListener<T> implements EventListener<T> {

    public static <T> EventListener<T> create() {
        return new EmptyEventListener<T>();
    }

    @Override
    public void onEvent(T value) {
    }

}
