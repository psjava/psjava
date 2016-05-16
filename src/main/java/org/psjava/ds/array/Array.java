package org.psjava.ds.array;

import org.psjava.ds.Collection;

// TODO 구현체는 equals 를 구현하자?
public interface Array<T> extends Collection<T> {
	T get(int index);
}
