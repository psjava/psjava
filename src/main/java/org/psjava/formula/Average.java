package org.psjava.formula;

import org.psjava.ds.Collection;
import org.psjava.ds.numbersystrem.DivisableNumberSystem;

public class Average {

    public static <T> T calc(Collection<T> a, DivisableNumberSystem<T> ns) {
        T sum = Sum.calc(ns, a);
        return ns.divide(sum, ns.getByInt(a.size()));
    }

    private Average() {
    }
}
