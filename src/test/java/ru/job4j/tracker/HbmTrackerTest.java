package ru.job4j.tracker;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class HbmTrackerTest {
    @Test
    public void whenCreate() {
        HbmTracker hbmTracker = new HbmTracker();
        Item item = new Item("Еда кота", "Купить еду коту");
        hbmTracker.add(item);
        List<Item> items = hbmTracker.findAll();
        assertEquals(item, items.get(0));
    }

    @Test
    public void whenUpdate() {
        HbmTracker hbmTracker = new HbmTracker();
        Item item = new Item("Еда кота", "Купить еду коту");
        hbmTracker.add(item);
        item.setName("Зоомагазин");
        hbmTracker.replace(item.getId(), item);
        Item updatedItem = hbmTracker.findById(item.getId());
        assertEquals(updatedItem.getName(), "Зоомагазин");
    }

    @Test
    public void whenDelete() {
        HbmTracker hbmTracker = new HbmTracker();
        Item item1 = new Item("Еда кота", "Купить еду коту");
        Item item2 = new Item("Посуда", "Помыть посуду");
        Item item3 = new Item("Ужин", "Приготовить рагу");
        hbmTracker.add(item1);
        hbmTracker.add(item2);
        hbmTracker.add(item3);
        List<Item> items = hbmTracker.findAll();
        assertEquals(items.size(), 3);
        hbmTracker.delete(item3.getId());
        List<Item> itemsAfterDelete = hbmTracker.findAll();
        assertEquals(itemsAfterDelete.size(), 2);
    }

    @Test
    public void whenFindByName() {
        HbmTracker hbmTracker = new HbmTracker();
        Item item1 = new Item("Еда кота", "Купить еду коту");
        Item item2 = new Item("Посуда", "Помыть посуду");
        Item item3 = new Item("Ужин", "Приготовить рагу");
        hbmTracker.add(item1);
        hbmTracker.add(item2);
        hbmTracker.add(item3);
        List<Item> items = hbmTracker.findByName("Ужин");
        assertEquals(items.size(), 1);
        assertEquals(items.get(0), item3);
    }
}