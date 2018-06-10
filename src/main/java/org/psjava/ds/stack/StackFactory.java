package org.psjava.ds.stack;

public interface StackFactory {
    <T> PSStack<T> create();
}
