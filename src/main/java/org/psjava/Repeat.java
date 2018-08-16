package org.psjava;

import java.util.stream.IntStream;

public class Repeat {

    public static void run(int n, Runnable runnable) {
        IntStream.range(0, n).forEach(index -> runnable.run());
    }

}
