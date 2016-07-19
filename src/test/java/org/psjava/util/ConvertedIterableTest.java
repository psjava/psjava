package org.psjava.util;

import static org.psjava.TestUtil.assertEqualIterable;
import static org.psjava.TestUtil.toArrayList;

import java.util.List;

import org.junit.Test;

public class ConvertedIterableTest {

    class Wrapper {
        int v;

        public Wrapper(int v) {
            this.v = v;
        }
    }

    @Test
    public void test() { // TODO move to iterator's test
        List<Wrapper> list = toArrayList(new Wrapper(1), new Wrapper(2));
        Iterable<Integer> iterable = ConvertedIterable.create(list, new Converter<Wrapper, Integer>() {
            @Override
            public Integer convert(Wrapper v) {
                return v.v;
            }
        });
        Integer[] expected = {1, 2};
        assertEqualIterable(expected, iterable);
    }
}
