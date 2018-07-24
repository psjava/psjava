package org.psjava.ds.numbersystrem;

import org.psjava.util.Assertion;

public class InfinitableNumber<T> {

    public static <T> InfinitableNumber<T> getFiniteInstance(T value) {
        return new InfinitableNumber<T>(value);
    }

    public static <T> InfinitableNumber<T> getInfinity() {
        return new InfinitableNumber<T>(null);
    }

    private final T valueOrNull; // null means infinity

    private InfinitableNumber(T valueOrNull) {
        this.valueOrNull = valueOrNull;
    }

    public boolean isInfinity() {
        return valueOrNull == null;
    }

    public T getValue() {
        Assertion.ensure(valueOrNull != null);
        return valueOrNull;
    }

    @Override
    public String toString() {
        return valueOrNull == null ? "INF" : valueOrNull.toString();
    }
}
