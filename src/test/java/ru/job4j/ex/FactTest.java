package ru.job4j.ex;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenNLessZero() {
        Fact.calc(-1);
    }

    @Test
    public void whenNMore0() {
        int rsl = Fact.calc(3);
        assertThat(rsl, is(6));
    }
}