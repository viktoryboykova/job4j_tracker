package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void drive() {
        System.out.println("дебильное");
    }

    @Override
    public void passengers(int num) {
        System.out.println("задание");
    }

    @Override
    public int refuel(int ml) {
        return 0;
    }
}
