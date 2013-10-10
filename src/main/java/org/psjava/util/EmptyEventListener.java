package org.psjava.util;

public class EmptyEventListener {

	public static <T> EventListener<T> create() {
		return new EventListener<T>() {
			@Override
			public void visit(T value) {
			}
		};
	}

}
