package org.psjava.ds.numbersystrem;

import org.psjava.StrictEqualityTester;

public class Fraction<T> {

    public static <T> Fraction<T> valueOf(T numerator, T denominator) {
        // cache? difficult because of generic. :(
        return new Fraction<T>(numerator, denominator);
    }

    public final T numerator;
    public final T denominator;

    private Fraction(T numerator, T denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    @Override
    public String toString() {
        String denom = denominator.toString();
        if (denom.equals("1"))
            return numerator.toString();
        else
            return numerator + "/" + denom;
    }

    @Override
    public boolean equals(Object obj) {
        return StrictEqualityTester.areEqual(this, obj, (o1, o2) -> o1.numerator.equals(o2.numerator) && o1.denominator.equals(o2.denominator));
    }

    @Override
    public int hashCode() {
        return numerator.hashCode() ^ denominator.hashCode();
    }

}
