package org.psjava.algo.math;

public class PairHash {
	public static int hash(int h1, int h2) {
		return ThomasWangHash.hash64bit((((long) h1) << 32) | h2);
	}

	private PairHash() {
	}
}
