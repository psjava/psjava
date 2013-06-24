package org.psjava.javautil;


public class ZeroTo {

	public static Iterable<Integer> get(int end) {
		return FromTo.get(0, end);
	}
	
}
