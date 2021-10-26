package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MatrixTest {

    @Test
    public void toList() {
        Integer[][] integers = {
                {1, 2},
                {3, 4}
        };
        Matrix mtrx = new Matrix();
        List<Integer> rsl = mtrx.toList(integers);
        List<Integer> exp = new ArrayList<>();
        exp.add(1);
        exp.add(2);
        exp.add(3);
        exp.add(4);
        assertThat(rsl, is(exp));
    }
}