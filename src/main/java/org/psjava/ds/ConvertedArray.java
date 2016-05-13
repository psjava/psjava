package org.psjava.ds;

import org.psjava.ds.array.Array;
import org.psjava.util.Converter;
import org.psjava.util.GetterByIndex;

public class ConvertedArray {

    public static <T1, T2> Array<T2> create(final Array<T1> original, final Converter<T1, T2> converter) {
        return ArrayFromItemGetter.create(original.size(), new GetterByIndex<T2>() {
            @Override
            public T2 get(int index) {
                return converter.convert(original.get(index));
            }
        });
    }

}