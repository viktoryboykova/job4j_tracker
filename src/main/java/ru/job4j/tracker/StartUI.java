package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {

    public static void main(String[] args) {
        Item item = new Item();
        System.out.println(item.getCreated());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy HH:mm:ss");
        String currentDateTimeFormat = item.getCreated().format(formatter);
        System.out.println("Текущие дата и время после форматирования: " + currentDateTimeFormat);

    }
}
