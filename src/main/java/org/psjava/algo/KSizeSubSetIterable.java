package org.psjava.algo;

import org.psjava.ds.array.Array;
import org.psjava.ds.array.UniformArray;
import org.psjava.util.*;

public class KSizeSubSetIterable {

    public static <T> Iterable<Iterable<T>> create(final Array<T> superSet, int k) {
        AssertStatus.assertTrue(k <= superSet.size());
        Array<Boolean> trues = UniformArray.create(true, k);
        Array<Boolean> falses = UniformArray.create(false, superSet.size() - k);
        Iterable<Boolean> flags = MergedIterable.wrap(VarargsIterable.create(trues, falses));
        Iterable<Array<Boolean>> permutations = PermutationWithRepetitionIterable.create(flags, ReversedComparator.wrap(new DefaultComparator<Boolean>()));
        return ConvertedIterable.create(permutations, new Converter<Array<Boolean>, Iterable<T>>() {
            @Override
            public Iterable<T> convert(final Array<Boolean> permutation) {
                return ConvertedIterable.create(FilteredIterable.create(ZeroTo.get(permutation.size()), new Filter<Integer>() {
                    @Override
                    public boolean isAccepted(Integer index) {
                        return permutation.get(index);
                    }
                }), new Converter<Integer, T>() {
                    @Override
                    public T convert(Integer index) {
                        return superSet.get(index);
                    }
                });
            }
        });
    }

}
