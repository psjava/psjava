package org.psjava.ds.array;

import java.util.Iterator;

import org.psjava.javautil.IterableToString;



public class CharacterArrayUsingString {
	
	public static Array<Character> create(final String s) {
		return new Array<Character>() {

			@Override
			public Character get(int i) {
				return s.charAt(i);
			}

			@Override
			public int size() {
				return s.length();
			}

			@Override
			public boolean isEmpty() {
				return s.length() == 0;
			}

			@Override
			public Iterator<Character> iterator() {
				return ArrayIterator.create(this);
			}

			@Override
			public String toString() {
				return IterableToString.toString(this);
			}

		};
	}

	private CharacterArrayUsingString() {
	}

}
