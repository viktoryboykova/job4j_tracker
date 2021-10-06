package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Война и мир", 1000);
        Book book2 = new Book("Clean code", 0);
        Book book3 = new Book("Педиатрия по Нельсону", 800);
        Book book4 = new Book("Про котиков", 500);
        Book[] books = new Book[4];
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;
        for (int i = 0; i < books.length; i++) {
            Book bk = books[i];
            System.out.println("Книга " + bk.getName() + " - " + bk.getNumber() + " страниц ");
        }
        Book kek = books[0];
        books[0] = books[3];
        books[3] = kek;
        for (int i = 0; i < books.length; i++) {
            Book bk = books[i];
            System.out.println("Книга " + bk.getName() + " - " + bk.getNumber() + " страниц ");
        }
        for (int i = 0; i < books.length; i++) {
            Book bk = books[i];
            if ("Clean code".equals(bk.getName())) {
                System.out.println("Книга " + bk.getName() + " - " + bk.getNumber() + " страниц ");
            }
        }
    }
}
