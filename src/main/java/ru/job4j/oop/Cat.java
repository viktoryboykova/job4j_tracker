package ru.job4j.oop;

public class Cat {

    private String food;
    private String name;

    public void nick(String name) {
        this.name = name;
    }

    public void show() {
        System.out.println("Это котик " + this.name + ". Он ест " +this.food);
    }

    public void eat(String food) {
        this.food = food;
    }

        public static void main(String[] args) {
            Cat twix = new Cat();
            twix.nick("Твикс");
            twix.eat("Мнямс-палочки");
            twix.show();
            Cat kisa = new Cat();
            kisa.nick("Кексик");
            kisa.eat("Мнямс-подушечки");
            kisa.show();
        }

}
