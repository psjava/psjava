package org.psjava.formula;

import org.psjava.ds.numbersystrem.MultipliableNumberSystem;

public class ProductOfVarargs {
    public static <T> T product(MultipliableNumberSystem<T> ns, T... v) {
        T r = ns.getOne();
        for (T a : v)
            r = ns.multiply(r, a);
        return r;
    }

    private ProductOfVarargs() {
    }
}
