package ru.job4j.bank;

import java.util.*;
import java.util.stream.Stream;

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
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> accounts = users.get(user.get());
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
    public Optional<User> findByPassport(String passport) {
        Optional<User> rsl = Optional.empty();
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                rsl = Optional.of(user);
                break;
            }
        }
        return rsl;
    }

    /**
     * Метод принимает на вход паспорт и реквизиты пользователя
     * Если пользователь найдет по паспорту в системе, получаем список всех его счетов
     * Если реквизиты совпадают с реквизитами одного из счетов, возвращаем этот счет
     * @param passport - паспорт пользователя
     * @param requisite - реквизиты банковского счета
     * @return возвращает банковский сче6т или null, если не найдет пользователь или счет с такими реквизитами
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            Stream<Account> stream = users.get(user.get()).stream();
            return stream.filter(s -> s.getRequisite().equals(requisite)).findFirst();
        }
        return Optional.empty();
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
        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        if (!srcAccount.isPresent() || !destAccount.isPresent() || srcAccount.get().getBalance() < amount || amount <= 0) {
            return false;
        }
        srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
        destAccount.get().setBalance(destAccount.get().getBalance() + amount);
        return true;
    }
}
