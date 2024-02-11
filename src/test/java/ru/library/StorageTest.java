package ru.library;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StorageTest {

    @Test
    void whenAdded100ElementsThenSizeMustBede100() {
        Storage storage = new Storage();
        Book[] books = new Book[100];
        for (int i = 0; i < 100; i++) {
            books[i] = new Book("book" + i);
            storage.add(books[i]);
        }
        assertThat(books.length).isEqualTo(100);
    }

    @Test
    void whenTestFindById() {
        Storage storage = new Storage();
        Book book = new Book("book");
        storage.add(book);
        Book result = storage.findById(book.getId());
        assertThat(result.getName()).isEqualTo(book.getName());
    }

    @Test
    void whenTestFindAll() {
        Storage storage = new Storage();
        Book book = new Book("book");
        Book book1 = new Book("book1");
        storage.add(book);
        storage.add(book1);
        Book result = storage.findAll()[0];
        Book result1 = storage.findAll()[1];
        assertThat(result.getName()).isEqualTo(book.getName());
        assertThat(result1.getName()).isEqualTo(book1.getName());
    }

    @Test
    void whenTestFindByNameCheckArrayLength() {
        Storage storage = new Storage();
        Book book = new Book("book");
        Book book1 = new Book("book1");
        storage.add(book);
        storage.add(book1);
        storage.add(new Book("book"));
        storage.add(new Book("book3"));
        storage.add(new Book("book"));
        Book[] result = storage.findByName("book");
        assertThat(result.length).isEqualTo(3);
    }

    @Test
    void whenTestFindByNameCheckSecondBookName() {
        Storage storage = new Storage();
        Book first = new Book("first");
        Book second = new Book("second");
        storage.add(first);
        storage.add(second);
        Book[] result = storage.findByName(second.getName());
        assertThat(result[0].getName()).isEqualTo(second.getName());
    }
}