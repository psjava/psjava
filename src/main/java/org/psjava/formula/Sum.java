package org.psjava.formula;

import org.psjava.ds.numbersystrem.AddableNumberSystem;

public class Sum {
    public static <T> T calc(final AddableNumberSystem<T> ns, Iterable<T> iterable) {
        return Accumulate.calc(iterable, ns.getZero(), ns::add);
    }
}
