package org.psjava.ds.map.hashmap;

public class LinearProbing {

	public static HashProber create() {
		return new HashProber() {
			@Override
			public void probe(int start, int length, BucketVisitor visitor) {
				for (int i = 0; i < length; i++)
					visitor.visitAndGetContinuity((start + i) % length);
			}
		};
	}

	private LinearProbing() {
	}

}
