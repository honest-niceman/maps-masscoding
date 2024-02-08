package org.example;

import java.util.*;

public class LibraryManagementSystem {
    public static final Map<String, Map<String, String>> bookCatalog = new HashMap<>(); // ISBN -> (Title, Status)
    public static final Map<Integer, List<String>> readerRecords = new HashMap<>(); // Reader ID -> List of ISBNs

    public static void addBook(String isbn, String title) {
        bookCatalog.put(isbn, new HashMap<>());
        bookCatalog.get(isbn).put("Title", title);
        bookCatalog.get(isbn).put("Status", "Available");
    }

    public static void removeBook(String isbn) {
        bookCatalog.remove(isbn);
    }

    public static void issueBook(String isbn, int readerId) {
        if (bookCatalog.containsKey(isbn) && bookCatalog.get(isbn).get("Status").equals("Available")) {
            bookCatalog.get(isbn).put("Status", "Issued");
            readerRecords.computeIfAbsent(readerId, k -> new ArrayList<>()).add(isbn);
        }
    }

    public static void returnBook(String isbn, int readerId) {
        if (readerRecords.containsKey(readerId) && readerRecords.get(readerId).contains(isbn)) {
            bookCatalog.get(isbn).put("Status", "Available");
            readerRecords.get(readerId).remove(isbn);
        }
    }

    public static List<String> getBooksByStatus(String status) {
        List<String> result = new ArrayList<>();

        for (Map.Entry<String, Map<String, String>> entry : bookCatalog.entrySet()) {
            String isbn = entry.getKey();
            String bookStatus = entry.getValue().get("Status");

            if (status.equals(bookStatus)) {
                result.add(isbn);
            }
        }

        return result;
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
