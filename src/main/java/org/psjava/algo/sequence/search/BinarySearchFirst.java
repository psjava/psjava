package org.psjava.algo.sequence.search;

import java.util.Comparator;
import java.util.function.Function;

import org.psjava.ds.numbersystrem.IntegerDivisableNumberSystem;
import org.psjava.formula.FloorDivide;

public class BinarySearchFirst {

    public static <I, O> I search(IntegerDivisableNumberSystem<I> inputNumberSystem, Function<I, O> f, Comparator<O> sortedOrder, I begin, I end, O target, I def) {
        I r = searchFirstPositionCanBeInserted(inputNumberSystem, begin, end, target, f, sortedOrder);
        if (!r.equals(end) && f.apply(r).equals(target))
            return r;
        else
            return def;
    }

    private static <I, O> I searchFirstPositionCanBeInserted(IntegerDivisableNumberSystem<I> ns, I begin, I end, O value, Function<I, O> f, Comparator<O> sortedOrder) {
        I one = ns.getOne();
        I two = ns.add(one, one);
        while (ns.compare(begin, end) < 0) {
            I midKey = FloorDivide.calc(ns, ns.add(begin, end), two);
            O midValue = f.apply(midKey);
            if (sortedOrder.compare(midValue, value) < 0)
                begin = ns.add(midKey, one);
            else
                end = midKey;
        }
        return end;
    }

    private BinarySearchFirst() {
    }

}
