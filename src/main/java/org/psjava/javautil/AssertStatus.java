package org.psjava.javautil;

public class AssertStatus {
	public static void assertTrue(boolean v) {
		if (!v)
			throw new RuntimeException();
	}
}
