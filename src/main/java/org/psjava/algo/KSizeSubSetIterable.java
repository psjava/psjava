package org.psjava.algo;

import org.psjava.ds.array.PSArray;
import org.psjava.ds.array.UniformArray;
import org.psjava.util.*;

import java.util.function.Predicate;

public class KSizeSubSetIterable {

    public static <T> Iterable<Iterable<T>> create(final PSArray<T> superSet, int k) {
        Assertion.ensure(k <= superSet.size());
        PSArray<Boolean> trues = UniformArray.create(true, k);
        PSArray<Boolean> falses = UniformArray.create(false, superSet.size() - k);
        Iterable<Boolean> flags = MergedIterable.wrap(VarargsIterable.create(trues, falses));
        Iterable<PSArray<Boolean>> permutations = PermutationWithRepetitionIterable.create(flags, ReversedComparator.wrap(new DefaultComparator<Boolean>()));
        return ConvertedIterable.create(permutations, new Converter<PSArray<Boolean>, Iterable<T>>() {
            @Override
            public Iterable<T> convert(final PSArray<Boolean> permutation) {
                return ConvertedIterable.create(FilteredIterable.create(ZeroTo.get(permutation.size()), new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer index) {
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
