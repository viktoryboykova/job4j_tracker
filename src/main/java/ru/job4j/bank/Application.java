package ru.job4j.bank;

import java.util.Optional;

public class Application {

    public static void main(String[] args) {
        BankService bank = new BankService();
        bank.addUser(new User("321", "Petr Arsentev"));
        Optional<User> opt = bank.findByPassport("321");
        if (opt.isPresent()) {
            System.out.println(opt.get().getUsername());
        }
    }
}
