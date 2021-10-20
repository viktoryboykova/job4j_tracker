package ru.job4j.collection;

import java.util.HashSet;

public class UniqueText {
    public static boolean isEquals(String originText, String duplicateText) {
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        for (String orig : origin) {
            check.add(orig);
        }
        for (String duplic : text) {
            if(!check.contains(duplic)) {
                return false;
            }
        }
        /* for-each text -> hashSet.contains */
        return true;
    }
}
