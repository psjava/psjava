package org.psjava.javautil;

public interface Visitor<T> {
	void visit(T value);		
}