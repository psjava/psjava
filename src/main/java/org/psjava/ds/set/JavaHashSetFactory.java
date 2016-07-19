package org.psjava.ds.set;

import java.util.HashSet;

public class JavaHashSetFactory {

    public static MutableSetFactory getInstance() {
        return new MutableSetFactory() {
            @Override
            public <T> MutableSet<T> create() {
                return new MutableSetUsingJavaSet<T>(new HashSet<T>());
            }
        };
    }

    private JavaHashSetFactory() {
    }

}
