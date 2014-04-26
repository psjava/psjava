package org.psjava.ds.set;

import java.util.Iterator;

import org.psjava.ds.map.SetEqualityTester;
import org.psjava.util.EqualityTester;
import org.psjava.util.IterableToString;
import org.psjava.util.OrderFreeIterableHash;
import org.psjava.util.StrictEqualityTester;

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

	@Override
	public int hashCode() {
		return OrderFreeIterableHash.hash(this);
	}

	@Override
	public boolean equals(Object obj) {
		return StrictEqualityTester.areEqual(this, obj, new EqualityTester<Set<T>>() {
			@Override
			public boolean areEqual(Set<T> o1, Set<T> o2) {
				return SetEqualityTester.areEqual(o1, o2);
			}
		});
	}

}