package ru.job4j.oop;

public class Cat {

    public String sound() {
        String voice = "mew-mew";
        return voice;
    }

        public static void main(String[] args) {
            Cat peppy = new Cat();
            Cat sparky = new Cat();
            Cat kisaVasilev = new Cat();
            String say = kisaVasilev.sound();
            System.out.println("Kisa Vasilev says " + say);
        }
}
