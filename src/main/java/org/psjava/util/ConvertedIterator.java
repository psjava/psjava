package org.psjava.util;

import java.util.Iterator;

public class ConvertedIterator {

    public static <T1, T2> Iterator<T2> create(final Iterator<T1> original, final Converter<T1, T2> converter) {
        return new ReadOnlyIterator<T2>() {
            @Override
            public boolean hasNext() {
                return original.hasNext();
            }

            @Override
            public T2 next() {
                return converter.convert(original.next());
            }
        };
    }

    private ConvertedIterator() {
    }
}
