package org.psjava.util;

// TODO introduce static factor method
public class SingletonKeeper<T> {

    private Factory<T> factory;
    private T instance;

    public SingletonKeeper(Factory<T> factory) {
        this.factory = factory;
    }

    public T getInstance() {
        if (instance == null)
            instance = factory.create();
        return instance;
    }

}
