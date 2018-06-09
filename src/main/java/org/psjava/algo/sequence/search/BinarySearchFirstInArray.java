package org.psjava.algo.sequence.search;

import java.util.Comparator;

import org.psjava.ds.array.PSArray;
import org.psjava.ds.array.FunctionByArray;
import org.psjava.ds.numbersystrem.IntegerNumberSystem;

public class BinarySearchFirstInArray {

    public static <T> int search(PSArray<T> array, Comparator<T> sortedOrder, T target, int def) {
        return BinarySearchFirst.search(IntegerNumberSystem.getInstance(), FunctionByArray.wrap(array), sortedOrder, 0, array.size(), target, def);
    }

    private BinarySearchFirstInArray() {
    }

}
