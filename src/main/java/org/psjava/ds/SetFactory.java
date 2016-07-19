package org.psjava.ds;

import java.util.Set;

public interface SetFactory {
    <T> Set<T> create();
}
