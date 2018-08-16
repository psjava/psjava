package org.psjava;

import java.util.function.BiPredicate;

public class StrictEqualityTester {

    @SuppressWarnings("unchecked")
    public static <T> boolean areEqual(T me, Object you, BiPredicate<T, T> tester) {
        if (me == you)
            return true;
        if (you == null)
            return false;
        if (you.getClass() != me.getClass())
            return false;
        return tester.test(me, (T) you);
    }

}
