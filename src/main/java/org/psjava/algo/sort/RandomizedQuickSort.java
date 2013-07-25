package org.psjava.algo.sort;

import java.util.Comparator;
import java.util.Random;

import org.psjava.ds.array.ArraySwapper;
import org.psjava.ds.array.MutableArray;

public class RandomizedQuickSort {

	// TODO do heap sort when level becomes deep

	private static Random RANDOM = new Random();

	public static Sort getInstance() {
		return new Sort() {

			@Override
			public <T> void sort(MutableArray<T> a, Comparator<T> comparator) {
				sortInRange(a, 0, a.size(), comparator);
			}

			private <T> void sortInRange(MutableArray<T> a, int start, int end, Comparator<T> comp) {
				if (end - start <= 1)
					return;
				int randomIndex = RANDOM.nextInt(end - start) + start;
				ArraySwapper.swap(a, start, randomIndex);
				int pos = start;
				for (int i = start + 1; i < end; i++) {
					int c = comp.compare(a.get(i), a.get(start));
					// To prevent big cluster in uniform array, use random.
					if (c < 0 || c == 0 && RANDOM.nextBoolean())
						ArraySwapper.swap(a, i, ++pos);
				}
				ArraySwapper.swap(a, start, pos);
				sortInRange(a, start, pos, comp);
				sortInRange(a, pos + 1, end, comp);
			}

		};
	}
}