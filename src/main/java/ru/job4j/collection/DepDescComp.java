package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] part1 = o1.split("/");
        String[] part2 = o2.split("/");
        int a = part2[0].compareTo(part1[0]);
        if (a != 0) {
            return a;
        }
        for (int i = 1; i < Math.min(part1.length, part2.length); i++) {
            int a2 = part1[i].compareTo(part2[i]);
            if (a2 != 0) {
                return a2;
            }
        }
        return Integer.compare(part1.length, part2.length);
    }
}
