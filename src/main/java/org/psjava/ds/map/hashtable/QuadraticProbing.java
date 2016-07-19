package org.psjava.ds.map.hashtable;

public class QuadraticProbing {

    public static HashProber create() {
        return new HashProber() {
            @Override
            public void probe(int start, int length, BucketVisitor visitor) {
                for (int round = 0; ; round++) {
                    for (int factor = 0; factor * factor < length; factor++) {
                        int p = (start + round + factor * factor) % length;
                        if (!visitor.visitAndGetContinuity(p))
                            return;
                    }
                }
            }
        };
    }

    private QuadraticProbing() {
    }

}
