package ru.job4j.stream;

import java.util.stream.Stream;

public class Card {
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public static void main(String[] args) {
        Suit[] suits = Suit.values();
        Value[] values = Value.values();
        Stream.of(suits)
                .flatMap(suit -> Stream.of(values)
                        .map(value -> new Card(suit, value)))
                .forEach(System.out::println);

    }

    @Override
    public String toString() {
        return "Card{" +
                "suit=" + suit +
                ", value=" + value +
                '}';
    }
}
