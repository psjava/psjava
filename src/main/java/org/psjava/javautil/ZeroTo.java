package org.psjava.javautil;


public class ZeroTo {

	public static Iterable<Integer> get(int end) {
		return IntSequenceIterable.create(0, 1, end);
	}
	
}
