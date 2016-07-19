package org.psjava.example.ds;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.ds.set.InsertAllToSet;
import org.psjava.ds.set.MutableSet;
import org.psjava.ds.set.Set;
import org.psjava.ds.set.SetFromVarargs;
import org.psjava.goods.GoodMutableSetFactory;
import org.psjava.util.VarargsIterable;

public class SetExample {

    @Test
    public void example() {
        // Set is an read-only interface which is different from java.util.Set
        // MutableSet interface is modifiable.

        MutableSet<String> set1 = GoodMutableSetFactory.getInstance().create();
        set1.add("A"); // 'add' method's parameter value is must not be exsit in the set
        set1.addIfAbsent("A"); // 'addIfAbsent' is more generous.
        set1.add("B");
        set1.add("C");

        int size = set1.size(); // must be 3
        Assert.assertEquals(3, size);

        // You can insert many items at once.
        InsertAllToSet.insertAll(set1, VarargsIterable.create("X", "Y", "Z"));
        Assert.assertEquals(6, set1.size());

        // You can simply create a set from values.
        Set<Integer> set2 = SetFromVarargs.create(1, 2, 3, 4);
        Assert.assertEquals(4, set2.size());
    }
}
