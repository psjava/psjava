package org.psjava.javautil;

import java.util.Iterator;

public class FilteredIterator {

	public static <T> Iterator<T> create(final Iterator<? extends T> a, final DataFilter<T> filter) {
		return new ReadOnlyIterator<T>() {
			T next = null;
			Iterator<? extends T> cursor = a;

			@Override
			public boolean hasNext() {
				tryToStepNext();
				return next != null;
			}

			@Override
			public T next() {
				tryToStepNext();
				T r = next;
				next = null;
				return r;
			}

			private void tryToStepNext() {
				if (next == null) {
					while (cursor.hasNext()) {
						T value = cursor.next();
						if (filter.isAccepted(value)) {
							next = value;
							break;
						}
					}
				}
			}

		};
	}

}