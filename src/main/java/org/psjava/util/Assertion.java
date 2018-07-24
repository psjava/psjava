package org.psjava.util;

import java.util.function.Supplier;

public class Assertion {
    public static void ensure(boolean v) {
        ensure(v, "assertion failed");
    }

    public static void ensureNotNull(Object v) {
        ensure(v != null, "Value cannot be a null");
    }

    public static void ensureNotNull(Object v, String message) {
        ensure(v != null, message);
    }

    public static void ensure(boolean v, String message) {
        ensure(v, () -> message);
    }

    public static void ensure(boolean c, Supplier<String> msg) {
        if (!c)
            throw new RuntimeException(msg.get());
    }
}
