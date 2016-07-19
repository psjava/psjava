package org.psjava.ds.geometry;

import org.junit.Assert;
import org.junit.Test;
import org.psjava.ds.geometry.Azimuth;

public class AzimuthTest {

    @Test
    public void testEqualityOfZeroDirection() {
        Assert.assertEquals(new Azimuth(0), new Azimuth(Math.PI * 2));
    }

    @Test
    public void testEqualityOfSameDirection() {
        Assert.assertEquals(new Azimuth(-Math.PI), new Azimuth(Math.PI));
    }

    @Test
    public void testBigNegativeDirection() {
        Assert.assertEquals(new Azimuth(0.1234).radian(), new Azimuth(-Math.PI * 20 + 0.1234).radian(), 1e-10);
    }

    @Test
    public void testBigPositiveDirection() {
        Assert.assertEquals(new Azimuth(0.1234).radian(), new Azimuth(Math.PI * 30 + 0.1234).radian(), 1e-10);
    }

}
