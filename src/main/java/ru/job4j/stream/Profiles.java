package ru.job4j.stream;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.Comparator;

public class Profiles {

    public List<Address> collect(List<Profile> profiles) {
       List<Address> list = profiles.stream()
               .map(profile -> profile.getAddress())
               .sorted((o1, o2) -> o1.getCity().compareTo(o2.getCity()))
               .distinct()
               .collect(Collectors.toList());
        return list;
    }
}
