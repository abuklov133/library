package ru.library;

public class LibraryWork {
    public void launch(Input input, Storage storage) {
        showMenu();
        boolean run = true;
        while (run) {
            int select = input.askInt("Select the action number: ");
            if (select == 0) {
                createBook(input, storage);
            } else if (select == 1) {
                displayAllBooks(storage);
            } else if (select == 2) {
                replaceBook(input, storage);
            } else if (select == 3) {
                deleteBook(input, storage);
            } else if (select == 4) {
                findBookByid(input, storage);
            } else if (select == 5) {
                findBooksByName(input, storage);
            } else if (select == 6) {
                run = false;
            }
        }
    }

    public static void findBooksByName(Input input, Storage storage) {
        System.out.println("==The book will be displayed according to the entered title==");
        String title = input.askStr("Enter a title");
        Book[] booksByName = storage.findByName(title);
        if (booksByName.length > 0) {
            for (Book book : booksByName) {
                System.out.println(book);
            }
        } else {
            System.out.println("No books were found by the entered name");
        }
    }

    public static void findBookByid(Input input, Storage storage) {
        System.out.println("==Find by number==");
        int id = input.askInt("Enter id: ");
        Book book = storage.findById(id);
        if (book != null) {
            System.out.println("The book was found by id: " + book);
        } else {
            System.out.println("The book with entered id was not found");
        }
    }

    public static void deleteBook(Input input, Storage storage) {
        System.out.println("==Deleting a book from a catalog==");
        int id = input.askInt("Enter id: ");
        Book book = storage.findById(id);
        storage.delete(id);
        System.out.println(book != null ? "The book was deleted successfully"
                : "Error of deleting");
    }

    public static void replaceBook(Input input, Storage storage) {
        System.out.println("==Replacing the book in the catalog==");
        int id = input.askInt("Enter id: ");
        String title = input.askStr("Enter a book's title: ");
        Book book = new Book(title);
        if (storage.replace(id, book)) {
            System.out.println("The book has been successfully replaced");
        } else {
            System.out.println("Replacement error");
        }
    }

    public static void displayAllBooks(Storage storage) {
        System.out.println("==We display the entire list of books==");
        Book[] books = storage.findAll();
        if (books.length > 0) {
            for (Book book : books) {
                System.out.println(book);
            }
        } else {
            System.out.println("There are not books in the vault yet.\n");
        }
    }

    public static void createBook(Input input, Storage storage) {
        System.out.println("==Add a new book to the catalog==");
        String name = input.askStr("Enter the title of the book:  ");
        Book book = new Book(name);
        storage.add(book);
        System.out.println("Added a new book: " + book);
    }

    private void showMenu() {
        String[] menu = {"Add a book", "Show the catalog", "Replace the book", "Find a book by number",
                "Find  books by name", "Delete the book from catalog", "Log out of the system"};
        System.out.println("Menu:");
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i + ". " + menu[i]);
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Storage storage = new Storage();
        new LibraryWork().launch(input, storage);
        LibraryWork.createBook(input, storage);

    }
}

