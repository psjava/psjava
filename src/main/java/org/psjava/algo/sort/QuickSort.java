package org.psjava.algo.sort;

import java.util.Comparator;
import java.util.Random;

import org.psjava.ds.array.ArraySwapper;
import org.psjava.ds.array.MutableArray;



public class QuickSort implements Sort {
	
	private static Random RANDOM = new Random();

	// TODO do heap sort when level becomes deep
	
	@Override
	public <T> void sort(MutableArray<T> a, Comparator<T> comparator) {
		sort(a, 0, a.size()-1, comparator);		
	}

	public <T> void sort(MutableArray<T> list, int start, int end, Comparator<T> comparator) {
		if(start < end) {
			ArraySwapper.swap(list, start, RANDOM.nextInt(end-start) + start + 1);
			int pos = start;
			for(int i=start+1;i<=end;i++) {
				int c = comparator.compare(list.get(i), list.get(start)); 
				if(c < 0 || c == 0 && i%2==0)
					ArraySwapper.swap(list, i,++pos);
			}
			ArraySwapper.swap(list, start, pos);
			sort(list, start,pos-1, comparator);
			sort(list, pos+1, end, comparator);
		}
	}
	
}