package org.psjava.ds;

import java.util.HashSet;
import java.util.Set;

public class HashSetFactory {
    public static final SetFactory INSTANCE = new SetFactory() {
        @Override
        public <T> Set<T> create() {
            return new HashSet<T>();
        }
    };
}
