package org.psjava.ds.set;

import java.util.Iterator;

import org.psjava.util.IterableToString;

public class MutableSetUsingJavaSet<T> implements MutableSet<T> {
	
	private final java.util.Set<T> javaset;
	
	public MutableSetUsingJavaSet(java.util.Set<T> set) {
		this.javaset = set;
	}

	@Override
	public void clear() {
		javaset.clear();		
	}
	
	@Override
	public boolean contains(T v) {
		return javaset.contains(v);		
	}
	
	@Override
	public void insert(T v) {
		javaset.add(v);
	}

	@Override
	public Iterator<T> iterator() {
		return javaset.iterator();
	}
	
	@Override
	public int size() {
		return javaset.size();
	}
	
	@Override
	public void remove(T v) {
		javaset.remove(v);
	}
	
	@Override
	public boolean isEmpty() {
		return size() == 0;
	}
	
	@Override
	public String toString() {
		return IterableToString.toString(this);
	}

}