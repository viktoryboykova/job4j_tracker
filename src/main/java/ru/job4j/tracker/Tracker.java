package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;
    private int size = 0;



    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public Item[] findAll() {
        Item[] itemsWithoutNull = new Item[items.size()];
        int size1 = 0;
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            if (item != null) {
                itemsWithoutNull[size1] = item;
                size1++;
            }
        }
        return Arrays.copyOf(itemsWithoutNull, size1);
    }

    public Item[] findByName(String key) {
        Item[] itemsWhisKey = new Item[items.size()];
        int size2 = 0;
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            if (item != null && key.equals(item.getName())) {
                itemsWhisKey[size2] = item;
                size2++;
            }
        }
        return Arrays.copyOf(itemsWhisKey, size2);
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index): null;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            item.setId(id);
            items.set(index, item);
        }
        return rsl;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            items.remove(index);
        }
        return rsl;
    }
}
