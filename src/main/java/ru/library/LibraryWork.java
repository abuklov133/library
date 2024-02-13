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
                System.out.println("Enter the name of the book");
                String name = scanner.nextLine();
                Book book = new Book(name);
                storage.add(book);
                System.out.println("Added a new book: " + book);
            } else if (select == 6) {
                run = false;
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
