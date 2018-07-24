package org.psjava.algo.math.optimization;

import org.psjava.ds.map.MutableMap;
import org.psjava.ds.map.MutableMapFactory;
import org.psjava.ds.set.MutableSet;
import org.psjava.ds.set.MutableSetFactory;
import org.psjava.util.Assertion;

public class MemoizationFactory {

    private MutableMapFactory mapFactory;
    private MutableSetFactory setFactory;

    public MemoizationFactory(MutableMapFactory mapFactory, MutableSetFactory setFactory) {
        this.mapFactory = mapFactory;
        this.setFactory = setFactory;
    }

    public <I, O> Memoization<I, O> create(final MemoizationFunction<I, O> f) {
        final MutableMap<I, O> table = mapFactory.create();
        final MutableSet<I> inStack = setFactory.create();
        return new Memoization<I, O>() {
            @Override
            public O get(I input) {
                Assertion.ensure(!inStack.contains(input), "The function calls infinite recursion. check the logic.");
                inStack.add(input);
                O v = table.getOrNull(input);
                if (v == null) {
                    v = f.get(input, this);
                    table.add(input, v);
                }
                inStack.remove(input);
                return v;
            }
        };
    }

}
