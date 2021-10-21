package ru.job4j.tracker;

import ru.job4j.collection.Job;
import ru.job4j.collection.SortByNameJob;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ItemSorter {
    public static void main(String[] args) {
        List<Item> items = Arrays.asList(
                new Item(3, "Киса Васильев"),
                new Item(1, "Егор Васильев"),
                new Item(2, "Викуха")
        );
        System.out.println(items);
        Collections.sort(items);
        System.out.println(items);
        Collections.sort(items, Collections.reverseOrder());
        System.out.println(items);
        Collections.sort(items, new SortByNameItem());
        System.out.println(items);
    }


}
