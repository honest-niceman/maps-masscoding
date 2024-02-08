package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibraryManagementSystemTest {
    @BeforeEach
    void setUp() {
        LibraryManagementSystem.bookCatalog.clear();
        LibraryManagementSystem.readerRecords.clear();
    }

    @Test
    void addBook() {
        LibraryManagementSystem.addBook("1234567890", "Test Book");
        assertTrue(LibraryManagementSystem.bookCatalog.containsKey("1234567890"));
        assertEquals("Test Book", LibraryManagementSystem.bookCatalog.get("1234567890").get("Title"));
        assertEquals("Available", LibraryManagementSystem.bookCatalog.get("1234567890").get("Status"));
    }

    @Test
    void removeBook() {
        LibraryManagementSystem.addBook("1234567890", "Test Book");
        LibraryManagementSystem.removeBook("1234567890");
        assertFalse(LibraryManagementSystem.bookCatalog.containsKey("1234567890"));
    }

    @Test
    void issueBook() {
        LibraryManagementSystem.addBook("1234567890", "Test Book");
        LibraryManagementSystem.issueBook("1234567890", 1);
        assertEquals("Issued", LibraryManagementSystem.bookCatalog.get("1234567890").get("Status"));
        assertTrue(LibraryManagementSystem.readerRecords.containsKey(1));
        assertTrue(LibraryManagementSystem.readerRecords.get(1).contains("1234567890"));
    }

    @Test
    void returnBook() {
        LibraryManagementSystem.addBook("1234567890", "Test Book");
        LibraryManagementSystem.issueBook("1234567890", 1);
        LibraryManagementSystem.returnBook("1234567890", 1);
        assertEquals("Available", LibraryManagementSystem.bookCatalog.get("1234567890").get("Status"));
        assertFalse(LibraryManagementSystem.readerRecords.get(1).contains("1234567890"));
    }

    @Test
    void getBooksByStatus() {
        LibraryManagementSystem.addBook("1234567890", "Test Book 1");
        LibraryManagementSystem.addBook("0987654321", "Test Book 2");
        LibraryManagementSystem.issueBook("1234567890", 1);
        List<String> availableBooks = LibraryManagementSystem.getBooksByStatus("Available");
        List<String> issuedBooks = LibraryManagementSystem.getBooksByStatus("Issued");
        assertTrue(availableBooks.contains("0987654321"));
        assertFalse(availableBooks.contains("1234567890"));
        assertTrue(issuedBooks.contains("1234567890"));
        assertFalse(issuedBooks.contains("0987654321"));
    }
}