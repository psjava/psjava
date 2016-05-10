package org.psjava.util;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class PrintStreamMerger {

    public static PrintStream merge(final PrintStream p1, final PrintStream p2) {
        return new PrintStream(new OutputStream() {
            @Override
            public void write(int b) throws IOException {
                p1.write(b);
                p2.write(b);
            }
        });
    }

}
