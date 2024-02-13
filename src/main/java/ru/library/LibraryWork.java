package ru.library;

import java.util.Scanner;

public class LibraryWork {
    public void launch(Scanner scanner, Storage storage) {
        showMenu();
        boolean run = true;
        while (run) {
            System.out.print("Select the action number:");
            int select = Integer.parseInt(scanner.nextLine());
            if (select == 0) {
                System.out.println("The user has selected " + select);
                System.out.println("==Add a new book to the catalog==");
                System.out.println("Enter the title of the book");
                String name = scanner.nextLine();
                Book book = new Book(name);
                storage.add(book);
                System.out.println("Added a new book: " + book);
            } else if (select == 1) {
                System.out.println("==We display the entire list of books==");
                Book[] books = storage.findAll();
                if (books.length != 0) {
                    for (Book book : books) {
                        System.out.println(book);
                    }
                } else {
                    System.out.println("There are not books in the vault yet.\n");
                }
            } else if (select == 2) {
                System.out.println("==Replacing the book in the catalog==");
                System.out.println("Enter id:");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter a book's title");
                String title = scanner.nextLine();
                Book book = new Book(title);
               if (storage.replace(id, book)) {
                   System.out.println("The book has been successfully replaced");
               } else {
                   System.out.println("Replacement error");
               }
            }
        }
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
        Scanner scanner = new Scanner(System.in);
        Storage storage = new Storage();
        new LibraryWork().launch(scanner, storage);

    }
}
