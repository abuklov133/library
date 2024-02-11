package ru.library;

import java.util.Arrays;

public class Storage {
    private final Book[] books = new Book[100];
    private int ids = 1;
    private int size = 0;

    public Book add(Book book) {
        book.setId(ids++);
        books[size++] = book;
        return book;
    }

    public Book findById(int id) {
        Book result = null;
        for (int i = 0; i < size; i++) {
            Book book = books[i];
            if (books[i].getId() == id) {
                result = book;
                break;
            }
        }
        return result;
    }

    public Book[] findAll() {
        int count = 0;
        Book[] result = new Book[books.length];
        for (int i = 0; i < size; i++) {
            Book book = books[i];
            if (book != null) {
                result[count] = book;
                count++;
            }
        }
        return Arrays.copyOf(result, count);
    }

    public Book[] findByName(String key) {
        int count = 0;
        Book[] result = new Book[size];
        for (int i = 0; i < size; i++) {
            Book book = books[i];
            if (book.getName() == key) {
                result[count] = book;
                count++;
            }
        }
        return Arrays.copyOf(result, count);
    }

    public static void main(String[] args) {
        Book book = new Book();
        Book book2 = new Book();
        Book book1 = new Book();
        Storage storage = new Storage();
        book.setName("test");
        book2.setName("test");
        book1.setName("test1");
        storage.add(book);
        storage.add(book1);
        storage.add(book2);
       Book result = storage.findById(2);
        System.out.println(result);

    }
}
