package org.psjava.javautil;

import java.util.Iterator;



public class FilteredIterable {
	
	public static <T> Iterable<T> create(final Iterable<? extends T> original, final DataFilter<T> filter) {
		return new Iterable<T>() {
			public Iterator<T> iterator() {
				return new FilteredIterator<T>(filter, original);
			}
		};
	}

	private static final class FilteredIterator<T> extends ReadOnlyIterator<T> {
		private final DataFilter<T> filter;
		private final Iterator<? extends T> cursor;
		private T next = null;

		private FilteredIterator(DataFilter<T> filter, Iterable<? extends T> original) {
			this.filter = filter;
			cursor = original.iterator();
		}

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
				while(cursor.hasNext()) {
					T value = cursor.next();
					if(filter.isAccepted(value)) {
						next = value;
						break;
					}
				}
			}
		}
	}

	private FilteredIterable() {
	}

}