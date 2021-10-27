package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class NotifyAccountTest {

    @Test
    public void sent() {
        List<Account> accounts = Arrays.asList(
                new Account("123", "Petr Arsentev", "eDer3432f"),
                new Account("123", "duplicate", "v"),
                new Account("142", "Petr Arsentev", "000001")
        );
        HashSet<Account> result = NotifyAccount.sent(accounts);

        HashSet<Account> expect = new HashSet<>(Set.of(
                new Account("123", "Petr Arsentev", "eDer3432f"),
                new Account("142", "Petr Arsentev", "000001")
        ));
        assertThat(result, is(expect));
    }
}