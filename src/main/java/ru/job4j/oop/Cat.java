package ru.job4j.oop;

public class Cat {

    public void mew() {
        System.out.println("Киса Васильев любит мяу-мяу-мяу");
    }

        public static void main(String[] args) {
            Cat peppy = new Cat();
            Cat sparky = new Cat();
            Cat kisaVasilev = new Cat();
            kisaVasilev.mew();
        }
}
