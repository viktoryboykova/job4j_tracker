package ru.job4j.collection;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@Ignore
public class ConvertList2ArrayTest {
    @Test
    public void when7ElementsThen9() {
        int[][] result = ConvertList2Array.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                3
        );
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void when2ElementsThen() {
        int[][] result = ConvertList2Array.toArray(
                Arrays.asList(1, 2),
                10
        );
        int[][] expect = {
                {1, 2, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        assertThat(result, is(expect));
    }

    @Test
    public void when10ElementsThen10() {
        int[][] result = ConvertList2Array.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
                1
        );
        int[][] expect = {
                {1}, {2}, {3},
                {4}, {5}, {6},
                {7}, {8}, {9},{10}
        };
        assertThat(result, is(expect));
    }
}