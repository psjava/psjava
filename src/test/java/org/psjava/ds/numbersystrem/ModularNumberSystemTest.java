package org.psjava.ds.numbersystrem;

import org.junit.Assert;
import org.junit.Test;

public class ModularNumberSystemTest {

    @Test
    public void testAdd() {
        ModularNumberSystem<Integer> ns = create();
        Assert.assertEquals(4, (int) ns.add(9, 5));
        Assert.assertEquals(6, (int) ns.add(-9, 5));
    }

    @Test
    public void testMultiply() {
        ModularNumberSystem<Integer> ns = create();
        Assert.assertEquals(4, (int) ns.multiply(-9, 4));
    }

    private static ModularNumberSystem<Integer> create() {
        return ModularNumberSystem.newInstance(IntegerNumberSystem.getInstance(), 10);
    }

}
