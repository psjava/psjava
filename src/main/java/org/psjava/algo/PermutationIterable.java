package org.psjava.algo;

import org.psjava.ds.ConvertedArray;
import org.psjava.ds.array.PSArray;
import org.psjava.util.ConvertedIterable;
import org.psjava.util.Converter;
import org.psjava.util.DefaultComparator;
import org.psjava.util.ZeroTo;

public class PermutationIterable {

    public static <T> Iterable<PSArray<T>> create(final PSArray<T> array) {
        Iterable<PSArray<Integer>> indexPermutations = PermutationWithRepetitionIterable.create(ZeroTo.get(array.size()), new DefaultComparator<Integer>());
        return ConvertedIterable.create(indexPermutations, new Converter<PSArray<Integer>, PSArray<T>>() {
            @Override
            public PSArray<T> convert(final PSArray<Integer> indexPermutation) {
                return ConvertedArray.create(indexPermutation, new Converter<Integer, T>() {
                    @Override
                    public T convert(Integer index) {
                        return array.get(index);
                    }
                });
            }
        });
    }

}
