package org.psjava.util;

public class Assertion {
    public static void ensure(boolean v) {
        ensure(v, "");
    }

    public static void ensureNotNull(Object v) {
        ensure(v != null, "Value cannot be a null");
    }

    public static void ensureNotNull(Object v, String message) {
        ensure(v != null, message);
    }

    public static void ensure(boolean v, String message) {
        if (!v)
            throw new RuntimeException(message);
    }
}
