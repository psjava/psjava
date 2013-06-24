package org.psjava.math.ns;

import org.psjava.javautil.FactoryByInt;

public class CacheByIntegerRange<T> {
	
	private final FactoryByInt<T> factory;
	
	private int start;
	private int end;
	T[] cache;
	
	public CacheByIntegerRange(int start, int end, FactoryByInt<T> factory) {
		this.factory = factory;
		resize(start, end);
	}

	@SuppressWarnings("unchecked")
	private void resize(int start, int end) {
		this.start = start;
		this.end = end;
		int size = end-start;
		cache = (T[])new Object[size];
		for(int i=0;i<size;i++)
			cache[i] = this.factory.create(start+i);
	}
	
	public T get(int value) {
		return cache[value - start];
	}

	public boolean inCache(int value) {
		return start <= value && value < end;
	}
	
}