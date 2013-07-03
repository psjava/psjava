package org.psjava.javautil;

public class IntBitUtil {

	public static int set(int v, int pos) {
		return v | (1 << pos);
	}

	public static boolean get(int v, int pos) {
		return (v & (1 << pos)) > 0;
	}

}
