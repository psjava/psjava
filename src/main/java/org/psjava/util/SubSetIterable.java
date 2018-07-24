package org.psjava.util;

import org.psjava.ds.array.PSArray;
import org.psjava.ds.array.MutableArrayFromIterable;

import java.util.function.Predicate;

public class SubSetIterable {

    public static <T> Iterable<Iterable<T>> create(final Iterable<T> superSet) {
        final PSArray<T> array = MutableArrayFromIterable.create(superSet);
        Assertion.ensure(array.size() <= 30, "too big set to iterate sub set");
        return ConvertedIterable.create(ZeroTo.get(1 << array.size()), new Converter<Integer, Iterable<T>>() {
            @Override
            public Iterable<T> convert(final Integer bits) {
                // Cannot get size of the sub st at this time. Because we use filter way
                return ConvertedIterable.create(FilteredIterable.create(ZeroTo.get(array.size()), new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer index) {
                        return IntBitUtil.get(bits, index);
                    }
                }), new Converter<Integer, T>() {
                    @Override
                    public T convert(Integer index) {
                        return array.get(index);
                    }
                });
            }
        });
    }

    private SubSetIterable() {
    }
}
