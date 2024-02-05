package org.example;

import java.util.*;

public class LibraryManagementSystem {
    public static final Map<String, Map<String, String>> bookCatalog = new HashMap<>(); // ISBN -> (Title, Status)
    public static final Map<Integer, List<String>> readerRecords = new HashMap<>(); // Reader ID -> List of ISBNs

    public void addBook(String isbn, String title) {
        //todo
    }

    public void removeBook(String isbn) {
        //todo
    }

    public void issueBook(String isbn, int readerId) {
        //todo
    }

    public void returnBook(String isbn, int readerId) {
        //todo
    }

    public List<String> getBooksByStatus(String status) {
        //todo
    }

    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem();

        library.addBook("1", "The Catcher in the Rye");
        library.addBook("2", "To Kill a Mockingbird");
        library.addBook("3", "1984");

        library.issueBook("1", 1);
        library.issueBook("2", 2);

        library.returnBook("1", 1);

        System.out.println("Books by Status:");
        List<String> booksByStatus = library.getBooksByStatus("Available");
        booksByStatus.forEach((isbns) -> System.out.println("Available: " + isbns));

        System.out.println("\nReader Records:");
        Map<Integer, List<String>> readerRecords = LibraryManagementSystem.readerRecords;
        readerRecords.forEach((readerId, isbns) -> System.out.println("Reader #" + readerId + ": " + isbns));
    }
}
