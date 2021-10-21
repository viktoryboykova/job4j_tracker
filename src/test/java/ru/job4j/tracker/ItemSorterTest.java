package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ItemSorterTest {

    @Test
    public void sort1plus() {
        List<Item> items = Arrays.asList(
                new Item(5, "Киса Васильев"),
                new Item(1, "Егор Васильев"),
                new Item(3, "Викуха"),
                new Item(2, "Мама"),
                new Item(4, "Миша")
        );
        Collections.sort(items);
        List<Item> exp = Arrays.asList(
                new Item(1, "Егор Васильев"),
                new Item(2, "Мама"),
                new Item(3, "Викуха"),
                new Item(4, "Миша"),
                new Item(5, "Киса Васильев")
    );
        Assert.assertThat(items, is(exp));
    }

    @Test
    public void sort2minus() {
        Item egor = new Item(1, "Егор Васильев");
        Item kisa = new Item(5, "Киса Васильев");
        Item vika = new Item(3, "Викуха");
        Item mama = new Item(2, "Мама");
        Item misha = new Item(4, "Миша");
        List<Item> items = Arrays.asList(kisa, egor, vika, mama, misha);
        Collections.sort(items, Collections.reverseOrder());
        List<Item> exp = Arrays.asList(kisa, misha, vika, mama, egor);
        Assert.assertThat(items, is(exp));
    }
}