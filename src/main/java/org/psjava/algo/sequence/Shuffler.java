package org.psjava.algo.sequence;

import java.util.Random;

import org.psjava.ds.array.ArraySwapper;
import org.psjava.ds.array.MutableArray;
import org.psjava.util.ZeroTo;

public class Shuffler {

    private static final Random RANDOM = new Random();

    public static <T> void shuffle(MutableArray<T> a) {
        for (int i : ZeroTo.get(a.size()))
            ArraySwapper.swap(a, i, i + RANDOM.nextInt(a.size() - i));
    }

    private Shuffler() {
    }
}
