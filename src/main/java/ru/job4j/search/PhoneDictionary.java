package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> pr1 = person -> person.getName() != null && person.getName().contains(key);
        Predicate<Person> pr2 = person -> person.getSurname() != null && person.getSurname().contains(key);
        Predicate<Person> pr3 = person -> person.getPhone() != null && person.getPhone().contains(key);
        Predicate<Person> pr4 = person -> person.getAddress() != null && person.getAddress().contains(key);
        Predicate<Person> combine = pr1.or(pr2.or(pr3.or(pr4)));
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
