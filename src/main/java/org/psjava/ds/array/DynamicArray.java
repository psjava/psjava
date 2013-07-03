package org.psjava.ds.array;

import java.util.Iterator;

import org.psjava.javautil.EqualityTester;
import org.psjava.javautil.IterableToString;
import org.psjava.javautil.StrictEqualityTester;
import org.psjava.math.ThomasWangHash;


public class DynamicArray<T> implements MutableArray<T>, EqualityTester<DynamicArray<T>> {
	
	public static <T> DynamicArray<T> create() {
		return new DynamicArray<T>();
	}
	
	private T[] a;
	private int asize;
	
	@SuppressWarnings("unchecked")
	public DynamicArray() {
		asize = 0;
		a = (T[])new Object[1];
	}

	public T get(int index) {
		return a[index];
	}	
	
	public void set(int index, T value) {
		a[index] = value;		
	}
	
	public int size() {
		return asize;
	}
	
	public void clear() {
		asize = 0;
	}
	
	@SuppressWarnings("unchecked")
	public void reserve(int size) {
		if(a.length < size) {
			T[] na = (T[])new Object[size];
			for(int i=0;i<a.length;i++)
				na[i] = a[i];
			a = na;
		}
	}
	
	@SuppressWarnings("unchecked")
	public void addToLast(T value) {
		if(a.length == asize) {
			T[] ta = (T[])new Object[asize*2];
			for(int i=0;i<asize;i++)
				ta[i] = a[i];
			a =ta;
		}
		a[asize++] = value;						
	}
	
	public void addToLastAll(Iterable<? extends T> values) { // TODO inline
		DynamicArrayUtil.addToLast(this, values);
	}

	public T removeLast() {
		T r = LastInArray.getLast(this);
		a[--asize] = null;
		return r;
	}
	
	@Override
	public boolean equals(Object obj) {
		return StrictEqualityTester.areEqual(this, obj, this);
	}

	@Override
	public boolean areEqual(DynamicArray<T> o1, DynamicArray<T> o2) {
		if(o1.size() != o2.size())
			return false;
		for(int i=0;i<o1.size();i++)
			if(!o1.get(i).equals(o2.get(i)))
				return false;		
		return true;
	}

	@Override
	public int hashCode() {
		int r = 0;
		for(int i=0;i<size();i++)
			r ^= ThomasWangHash.hash32bit(get(i).hashCode());
		return r;
	}

	@Override
	public final boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public final Iterator<T> iterator() {
		return ArrayIterator.create(this);
	}

	@Override
	public final String toString() {
		return IterableToString.toString(this);
	}
	
}
