package org.psjava.util;

import java.util.Iterator;

public interface IteratorFactory<T> {
    Iterator<T> create();
}
