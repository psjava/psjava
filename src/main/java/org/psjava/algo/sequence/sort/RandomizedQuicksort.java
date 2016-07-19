package org.psjava.algo.sequence.sort;

import java.util.Comparator;
import java.util.Random;

import org.psjava.ds.array.ArraySwapper;
import org.psjava.ds.array.MutableArray;

public class RandomizedQuicksort {

    // TODO do heap sort when level becomes deep

    private static Random RANDOM = new Random();

    public static SortingAlgorithm getInstance() {
        return new SortingAlgorithm() {
            @Override
            public <T> void sort(MutableArray<T> a, Comparator<T> comparator) {
                sortRecursively(a, 0, a.size(), comparator);
            }
        };
    }

    private static <T> void sortRecursively(MutableArray<T> a, int start, int end, Comparator<T> comp) {
        if (end - start <= 1)
            return;
        int randomIndex = RANDOM.nextInt(end - start) + start;
        ArraySwapper.swap(a, start, randomIndex);
        int pos = start;
        for (int i = start + 1; i < end; i++) {
            int c = comp.compare(a.get(i), a.get(start));
            // Use random to prevent big half cluster by same items
            if (c < 0 || c == 0 && RANDOM.nextBoolean())
                ArraySwapper.swap(a, i, ++pos);
        }
        ArraySwapper.swap(a, start, pos);
        sortRecursively(a, start, pos, comp);
        sortRecursively(a, pos + 1, end, comp);
    }

    private RandomizedQuicksort() {
    }

}
