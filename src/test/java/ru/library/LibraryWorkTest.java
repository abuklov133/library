package ru.library;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LibraryWorkTest {
    @Test
    void whenAddBook() {
        String[] answers = {"Fix PC"};
        Input input = new ConsoleInput();
        Storage storage = new Storage();
        LibraryWork.createBook(input, storage);
        Book created = storage.findAll()[0];
        Book expected = new Book("Fix PC");
        assertThat(created.getName()).isEqualTo(expected.getName());
    }

}