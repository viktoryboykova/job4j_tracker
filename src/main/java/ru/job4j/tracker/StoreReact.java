package ru.job4j.tracker;

import java.util.function.Consumer;

public interface StoreReact {
    void findAll(Consumer<Item> observer);
}
