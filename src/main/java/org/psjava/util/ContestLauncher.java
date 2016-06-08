package org.psjava.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class ContestLauncher {

    public static void run(Runnable runnable, String inputInHome, String outputInHome) throws FileNotFoundException {
        String home = System.getProperty("user.home");
        System.setIn(new BufferedInputStream(new FileInputStream(home + inputInHome)));
        System.setOut(PrintStreamMerger.merge(System.out, new PrintStream(home + outputInHome)));
        runnable.run();
    }

}
