package org.psjava.javautil;

public interface DataGetter<K, V> {
	V get(K v);
}