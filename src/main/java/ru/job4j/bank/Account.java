package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает банковские счета пользователей банка
 * @author VIKTORIA BOYKOVA
 * @version 1.0
 */
public class Account {
    private String requisite;
    private double balance;

    /**
     * @param requisite - реквизиты счета
     * @param balance - баланс на счету
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    public String getRequisite() {
        return requisite;
    }

    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
