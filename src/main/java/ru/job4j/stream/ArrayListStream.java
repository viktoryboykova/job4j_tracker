package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ArrayListStream {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(-5);
        nums.add(-4);
        nums.add(-3);
        nums.add(-2);
        nums.add(-1);
        nums.add(0);
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        nums.add(5);

        List<Integer> newNums = nums.stream().filter(num -> num > 0).collect(Collectors.toList());
        newNums.forEach(System.out::println);
    }
}
