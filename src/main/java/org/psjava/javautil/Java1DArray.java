package org.psjava.javautil;

public class Java1DArray {

	@SuppressWarnings("unchecked")
	public static <T> T[] create(Class<?> clazz, int n) {
		return (T[]) java.lang.reflect.Array.newInstance(clazz, n);
	}

}
