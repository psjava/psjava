package org.psjava.example.ds;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.ds.IntersectionOfTwoSets;
import org.psjava.ds.SetFromVarargs;

import java.util.Set;

/**
 * @implementation {@link IntersectionOfTwoSets}
 */
public class IntersectionOfTwoSetsExample {

    @Test
    public void test() {
        Set<Integer> set1 = SetFromVarargs.create(1, 2, 3, 4);
        Set<Integer> set2 = SetFromVarargs.create(3, 4, 5, 6);
        Set<Integer> intersection = IntersectionOfTwoSets.create(set1, set2); // must be (3,4)
        Assert.assertEquals("[3, 4]", intersection.toString());
    }

}
