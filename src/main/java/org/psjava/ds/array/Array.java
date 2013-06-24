package org.psjava.ds.array;

import org.psjava.ds.Collection;

public interface Array<T> extends Collection<T> {
	T get(int index);
}
