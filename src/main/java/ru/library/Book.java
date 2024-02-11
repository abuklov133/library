package ru.library;

import java.time.LocalDateTime;

public class Book {
    private int id;
    private String name;
    private LocalDateTime created = LocalDateTime.now();

    public Book() {
    }

    public Book(int id) {
        this.id = id;
    }

    public Book(String name) {
        this.name = name;
    }

    public Book(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "Book{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", created=" + created
                + '}';
    }
}
