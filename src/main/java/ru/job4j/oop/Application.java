package ru.job4j.oop;

public class Application {

    public static void main(String[] args) {
        DummyDic dummyDic = new DummyDic();
        String word = dummyDic.engToRus("cat");
        System.out.println(word);
    }
}
