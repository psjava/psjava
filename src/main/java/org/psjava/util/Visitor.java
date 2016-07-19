package org.psjava.util;

public interface Visitor<T> {
    void visit(T value);
}