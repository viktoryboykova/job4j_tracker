package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfilesTest {

    @Test
    public void getAdress() {
        List<Profile> profiles = List.of(
                new Profile(new Address("Москва", "Черкизовская", 30, 90)),
                new Profile(new Address("Балашиха", "Звездная", 8, 90)),
                new Profile(new Address("Волгоград", "Гороховцев", 4, 90))
        );
        Profiles prof = new Profiles();
        List<Address> rsl = prof.collect(profiles);
        List<Address> expected = new ArrayList<>();
        expected.add(new Address("Балашиха", "Звездная", 8, 90));
        expected.add(new Address("Волгоград", "Гороховцев", 4, 90));
        expected.add(new Address("Москва", "Черкизовская", 30, 90));
        assertThat(rsl, is(expected));
    }

    @Test
    public void notDublicate() {
        List<Profile> profiles = List.of(
                new Profile(new Address("Москва", "Черкизовская", 30, 90)),
                new Profile(new Address("Москва", "Черкизовская", 30, 90)),
                new Profile(new Address("Балашиха", "Звездная", 8, 90)),
                new Profile(new Address("Балашиха", "Звездная", 8, 90)),
                new Profile(new Address("Волгоград", "Гороховцев", 4, 90))
        );
        Profiles prof = new Profiles();
        List<Address> rsl = prof.collect(profiles);
        List<Address> expected = new ArrayList<>();
        expected.add(new Address("Балашиха", "Звездная", 8, 90));
        expected.add(new Address("Волгоград", "Гороховцев", 4, 90));
        expected.add(new Address("Москва", "Черкизовская", 30, 90));
        assertThat(rsl, is(expected));
    }
}