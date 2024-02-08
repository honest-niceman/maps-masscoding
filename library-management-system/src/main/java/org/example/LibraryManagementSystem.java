package org.example;

import java.util.*;

public class LibraryManagementSystem {
    public static final Map<String, Map<String, String>> bookCatalog = new HashMap<>(); // ISBN -> (Title, Status)
    public static final Map<Integer, List<String>> readerRecords = new HashMap<>(); // Reader ID -> List of ISBNs

    public static void addBook(String isbn, String title) {
    }

    public static void removeBook(String isbn) {
    }

    public static void issueBook(String isbn, int readerId) {
    }

    public static void returnBook(String isbn, int readerId) {
    }

    public static List<String> getBooksByStatus(String status) {
    }

    public static void main(String[] args) {
        LibraryManagementSystem.addBook("1", "The Catcher in the Rye");
        LibraryManagementSystem.addBook("2", "To Kill a Mockingbird");
        LibraryManagementSystem.addBook("3", "1984");

        LibraryManagementSystem.issueBook("1", 1);
        LibraryManagementSystem.issueBook("2", 2);

        LibraryManagementSystem.returnBook("1", 1);

        System.out.println("Books by Status:");
        List<String> booksByStatus = LibraryManagementSystem.getBooksByStatus("Available");
        booksByStatus.forEach((isbns) -> System.out.println("Available: " + isbns));

        System.out.println("\nReader Records:");
        Map<Integer, List<String>> readerRecords = LibraryManagementSystem.readerRecords;
        readerRecords.forEach((readerId, isbns) -> System.out.println("Reader #" + readerId + ": " + isbns));
    }
}
