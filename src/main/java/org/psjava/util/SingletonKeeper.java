package org.psjava.util;

import java.util.function.Supplier;

public class SingletonKeeper<T> {

    private Supplier<T> factory;
    private T instance;

    public SingletonKeeper(Supplier<T> factory) {
        this.factory = factory;
    }

    public T getInstance() {
        if (instance == null)
            instance = factory.get();
        return instance;
    }

}
