package org.psjava.util;

public interface EventListener<T> {
	void visit(T value);
}