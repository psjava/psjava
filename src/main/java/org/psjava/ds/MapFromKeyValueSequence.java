package org.psjava.ds;

import org.psjava.util.Assertion;
import org.psjava.util.IntSequenceIterable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapFromKeyValueSequence {

    public static <T> Map<T, T> create(List<T> keyValueSequence) {
        Map<T, T> map = new HashMap<T, T>();
        Assertion.ensure(keyValueSequence.size() % 2 == 0);
        for (int i : IntSequenceIterable.create(0, 2, keyValueSequence.size() / 2))
            map.put(keyValueSequence.get(i), keyValueSequence.get(i + 1));
        return map;

    }
}
