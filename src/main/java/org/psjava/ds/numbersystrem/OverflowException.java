package org.psjava.ds.numbersystrem;

public class OverflowException {

    public static ArithmeticException create() {
        return new ArithmeticException("Overflow");
    }

    private OverflowException() {
    }

}
