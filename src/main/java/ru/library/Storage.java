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
        int index = indexOfId(id);
        return index != -1 ? books[index] : null;
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
            if (book.getName().equals(key)) {
                result[count++] = book;
            }
        }
        return Arrays.copyOf(result, count);
    }

    public boolean replace(int id, Book book) {
        int index = indexOfId(id);
        boolean result = index != -1;
        if (result) {
            book.setId(id);
            books[index] = book;
        }
        return result;
    }

    private int indexOfId(int id) {
        int result = -1;
        for (int i = 0; i < size; i++) {
            if (books[i].getId() == id) {
                result = i;
                break;
            }
        }
        return result;
    }
}
