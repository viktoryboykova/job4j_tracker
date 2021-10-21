package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] parts1 = left.split(". ");
        String[] parts2 = right.split(". ");
          Integer x = Integer.parseInt(parts1[0]);
          Integer y = Integer.parseInt(parts2[0]);
        return x.compareTo(y);
    }
}
