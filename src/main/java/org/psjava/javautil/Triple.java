package org.psjava.javautil;

import org.psjava.math.PairHash;

public class Triple<T1,T2,T3> implements EqualityTester<Triple<T1, T2, T3>>{
	
	public static <T1, T2, T3> Triple<T1, T2, T3> create(T1 v1, T2 v2, T3 v3) {
		return new Triple<T1, T2, T3>(v1, v2, v3);
	}
	
	public final T1 v1;
	public final T2 v2;
	public final T3 v3;
	
	public Triple(T1 v1, T2 v2, T3 v3) {
		this.v1 = v1;
		this.v2 = v2;
		this.v3 = v3;
	}
	
	@Override
	public boolean equals(Object obj) {
		return StrictEqualityTester.areEqual(this, obj, this);
	}
	
	@Override
	public boolean areEqual(Triple<T1, T2, T3> o1, Triple<T1, T2, T3> o2) {
		return o1.v1.equals(o2.v1) && o1.v2.equals(o2.v2) && o1.v3.equals(o2.v3);
	}
	
	@Override
	public int hashCode() {
		return PairHash.hash(PairHash.hash(v1.hashCode(), v2.hashCode()), v3.hashCode());
	}
	
	@Override
	public String toString() {
		return "(" + v1 + "," + v2 + "," + v3 + ")";
	}
}