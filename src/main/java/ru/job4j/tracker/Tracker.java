package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;



    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        Item[] itemsWithoutNull = new Item[items.length];
        int size1 = 0;
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            if (item != null) {
                itemsWithoutNull[size1] = item;
                size1++;
            }
        }
        return Arrays.copyOf(itemsWithoutNull, size1);
    }

    public Item[] findByName(String key) {
        Item[] itemsWhisKey = new Item[items.length];
        int size2 = 0;
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            if (item != null && key.equals(item.getName())) {
                itemsWhisKey[size2] = item;
                size2++;
            }
        }
        return Arrays.copyOf(itemsWhisKey, size2);
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }
}