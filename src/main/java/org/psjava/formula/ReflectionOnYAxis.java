package org.psjava.formula;

import org.psjava.ds.numbersystrem.AddInvert;
import org.psjava.ds.numbersystrem.IntegerDivisableNumberSystem;

import java.util.function.Function;

public class ReflectionOnYAxis {

    public static <O, I> Function<I, O> create(final IntegerDivisableNumberSystem<I> inputNumberSystem, final Function<I, O> original) {
        return new Function<I, O>() {
            @Override
            public O apply(I input) {
                return original.apply(AddInvert.calc(inputNumberSystem, input));
            }
        };
    }

    private ReflectionOnYAxis() {
    }

}
