package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {
    public List<Student> collect(List<Student> students, Predicate<Student> predict) {
        List<Student> exp = students.stream()
                .filter(predict)
                .collect(Collectors.toList());
        return exp;
    }

    public Map<String, Student> toMap(List<Student> students) {
        Map<String, Student> exp = students.stream()
                .distinct()
                .collect(
                        Collectors.toMap(
                                student -> student.getSurname(),
                                student -> student
                        )
                );
        return exp;
    }
}
