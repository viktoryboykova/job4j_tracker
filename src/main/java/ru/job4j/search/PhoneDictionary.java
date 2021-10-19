package ru.job4j.search;

import java.util.ArrayList;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (check(person.getName(), key) || check(person.getSurname(), key) || check(person.getPhone(), key) || check(person.getAddress(), key)) {
                result.add(person);
            }
        }
        return result;
    }

    private boolean check(String value, String key) {
        return value != null && value.contains(key);
    }
}
