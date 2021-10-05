package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaxTest {

    @Test
    public void whenF10S5Expected10() {
        int first = 10;
        int second = 5;
        int expected = 10;
        int out = Max.max(first, second);
        Assert.assertEquals(expected, out);
    }

    @Test
    public void whenF10S5T11Expected11() {
        int first = 10;
        int second = 5;
        int third = 11;
        int expected = 11;
        int out = Max.max(first, Max.max(second, third));
        Assert.assertEquals(expected, out);
    }

    @Test
    public void whenF10S5T4F15Expected15() {
        int first = 10;
        int second = 5;
        int third = 4;
        int fourth = 15;
        int expected = 15;
        int out = Max.max(Max.max(first, second), Max.max(third, fourth));
        Assert.assertEquals(expected, out);
    }
}