package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {

    @Test
    public void when000To201Then2_23() {
        Point a = new Point(0, 0, 0);
        Point b = new Point(2, 0, 1);
        double expected = 2.23;
        double out = a.distance3d(b);
        Assert.assertEquals(expected, out, 0.01);
    }
}