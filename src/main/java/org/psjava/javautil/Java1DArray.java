package org.psjava.javautil;

public class Java1DArray {

	@SuppressWarnings("unchecked")
	public static <W> W[] create(Class<?> clazz, int n) {
		return (W[]) java.lang.reflect.Array.newInstance(clazz, n);
	}

}
