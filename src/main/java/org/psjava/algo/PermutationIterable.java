package org.psjava.algo;

import org.psjava.ds.ConvertedArray;
import org.psjava.ds.array.Array;
import org.psjava.util.ConvertedIterable;
import org.psjava.util.Converter;
import org.psjava.util.DefaultComparator;
import org.psjava.util.ZeroTo;

public class PermutationIterable {

    public static <T> Iterable<Array<T>> create(final Array<T> array) {
        Iterable<Array<Integer>> indexPermutations = PermutationWithRepetitionIterable.create(ZeroTo.get(array.size()), new DefaultComparator<Integer>());
        return ConvertedIterable.create(indexPermutations, new Converter<Array<Integer>, Array<T>>() {
            @Override
            public Array<T> convert(final Array<Integer> indexPermutation) {
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
