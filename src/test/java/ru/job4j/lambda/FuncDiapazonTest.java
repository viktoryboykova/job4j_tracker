package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FuncDiapazonTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = FuncDiapazon.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenKvadrFunctionThenLinearResults() {
        List<Double> result = FuncDiapazon.diapason(1, 4, x -> 2 * x * x + x + 1);
        List<Double> expected = Arrays.asList(4D, 11D, 22D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenPokazFunctionThenLinearResults() {
        List<Double> result = FuncDiapazon.diapason(1, 6, x -> Math.pow(2, x));
        List<Double> expected = Arrays.asList(2D, 4D, 8D, 16D, 32D);
        assertThat(result, is(expected));
    }
}