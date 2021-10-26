package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу сервиса банка
 * @author VIKTORIA BOYKOVA
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение пользователей осуществляется в коллекции типа Map
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход пользователя и проверяет, есть ли такой пользователь в системе
     * Если пользователя нет, то метод добавляет пользователя в систему
     * @param user пользователь, который добавляется в систему
     */
    public void addUser(User user) {
        if (!users.containsKey(user)) {
            users.put(user, new ArrayList<Account>());
        }
    }

    /**
     * Метод принимает на вход паспорт пользователя и банковский счет
     * Если пользователь найден по паспорту в системе, получаем список всех его счетов
     * и, если принимаемый в параметре счет не найдет, добавляем его в список
     * @param passport - паспорт пользователя
     * @param account - банковский счет
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод принимает на вход паспорт пользователя
     * В системе проверяем среди пользователей паспорт
     * Если паспортные данные совпадают, возвращаем пользователя
     * @param passport - паспорт пользователя
     * @return возвращает пользователя или null, если пользователь не найден
     */
    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(s -> s.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод принимает на вход паспорт и реквизиты пользователя
     * Если пользователь найдет по паспорту в системе, получаем список всех его счетов
     * Если реквизиты совпадают с реквизитами одного из счетов, возвращаем этот счет
     * @param passport - паспорт пользователя
     * @param requisite - реквизиты банковского счета
     * @return возвращает банковский сче6т или null, если не найдет пользователь или счет с такими реквизитами
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return users.get(user)
                    .stream()
                    .filter(s -> s.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * Метод принимает на вход паспорта и реквизиты счетов отправителя и получателя, сумму перевода
     * Находим по входным данным банковские счета отправителя и получателя
     * Если счета найдены и денег на счете отправителя достаточно, производим операцию перечисления денег
     * @param srcPassport - паспорт отправителя
     * @param srcRequisite - реквизиты отправителя
     * @param destPassport - паспорт получателя
     * @param destRequisite - реквизиты получателя
     * @param amount - сумма перевода
     * @return возвращает true, если деньги перечислены,
     * и false, если не найден один из счетов или суммы на счете отправителя недостаточно/равно 0
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount == null || destAccount == null || srcAccount.getBalance() < amount || amount <= 0) {
            return false;
        }
        srcAccount.setBalance(srcAccount.getBalance() - amount);
        destAccount.setBalance(destAccount.getBalance() + amount);
        return true;
    }
}
