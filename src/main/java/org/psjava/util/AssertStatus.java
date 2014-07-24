package org.psjava.util;

public class AssertStatus {
	public static void assertTrue(boolean v) {
		assertTrue(v, "");
	}

	public static void assertNotNull(Object v) {
		assertTrue(v != null, "Object is cannot be a null");
	}

	public static void assertNotNull(Object v, String message) {
		assertTrue(v != null, message);
	}

	public static void assertTrue(boolean v, String message) {
		if (!v)
			throw new RuntimeException(message);
	}

	private AssertStatus() {
	}
}
