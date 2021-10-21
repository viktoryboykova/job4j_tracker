package ru.job4j.tracker;

import ru.job4j.collection.Job;

import java.util.Comparator;

public class SortByNameItem implements Comparator<Item> {
    @Override
    public int compare(Item first, Item second) {
        return first.getName().compareTo(second.getName());
    }
}
