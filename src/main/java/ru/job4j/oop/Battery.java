package ru.job4j.oop;

public class Battery {

    private int load;

    public Battery(int size) {
        this.load = size;
    }

    public void exchange(Battery another) {
        this.load = this.load + another.load;
        another.load = 0;
    }

    public static void main(String[] args) {
        Battery battery1 = new Battery(10);
        Battery battery2 = new Battery(20);
        System.out.println("Заряд батареи 1: " + battery1.load + ". Заряд батареи 2: " + battery2.load);
        battery1.exchange(battery2);
        System.out.println("Заряд батареи 1: " + battery1.load + ". Заряд батареи 2: " + battery2.load);
    }
}
