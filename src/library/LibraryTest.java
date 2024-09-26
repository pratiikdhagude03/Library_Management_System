package library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Library class.
 * Ensures all core functionalities of the library such as adding books, borrowing, returning,
 * and viewing available books work as expected.
 */
class LibraryTest {
    private Library library;

    /**
     * Sets up the initial library state with some predefined books before each test.
     */
    @BeforeEach
    public void setUp() {
        library = new Library();
        library.addBook(new Book("1234", "Effective Java", "Joshua Bloch", 2018));
        library.addBook(new Book("5678", "Clean Code", "Robert C. Martin", 2008));
    }

    /**
     * Test to verify that adding a new book works correctly.
     */
    @Test
    public void testAddBook() {
        // Add a new book and check if it can be borrowed without throwing an exception.
        library.addBook(new Book("9101", "Refactoring", "Martin Fowler", 2012));
        assertDoesNotThrow(() -> library.borrowBook("9101"), "Book should be borrowable after adding.");
    }

    /**
     * Test to ensure that adding a book with a duplicate ISBN throws an IllegalArgumentException.
     */
    @Test
    public void testAddDuplicateBook() {
        // Try to add a duplicate book and verify the exception message.
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            library.addBook(new Book("1234", "Duplicate Book", "Some Author", 2020));
        });
        assertEquals("Book with ISBN 1234 already exists.", exception.getMessage(),
                "Adding a duplicate book should throw an appropriate exception.");
    }

    /**
     * Test to ensure borrowing a book works as expected and prevents re-borrowing.
     */
    @Test
    public void testBorrowBook() {
        // Borrow the book and verify that no exception is thrown the first time.
        assertDoesNotThrow(() -> library.borrowBook("1234"), "Borrowing a book should not throw an exception.");

        // Try to borrow the same book again, which should throw an exception.
        assertThrows(IllegalStateException.class, () -> library.borrowBook("1234"),
                "Borrowing an already borrowed book should throw an exception.");
    }

    /**
     * Test to ensure borrowing a non-existing book throws an IllegalArgumentException.
     */
    @Test
    public void testBorrowNonExistingBook() {
        // Attempt to borrow a book that doesn't exist and verify the exception message.
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            library.borrowBook("9999");
        });
        assertEquals("Book with ISBN 9999 not found.", exception.getMessage(),
                "Borrowing a non-existent book should throw an appropriate exception.");
    }

    /**
     * Test to ensure returning a borrowed book works as expected.
     */
    @Test
    public void testReturnBook() {
        // Borrow a book first, then return it, verifying no exceptions are thrown.
        library.borrowBook("5678");
        assertDoesNotThrow(() -> library.returnBook("5678"), "Returning a borrowed book should not throw an exception.");
    }

    /**
     * Test to ensure returning a book that hasn't been borrowed throws an IllegalStateException.
     */
    @Test
    public void testReturnNonBorrowedBook() {
        // Try to return a book that was not borrowed, which should throw an exception.
        assertThrows(IllegalStateException.class, () -> {
            library.returnBook("5678");
        }, "Returning a non-borrowed book should throw an exception.");
    }

    /**
     * Test to verify that viewing available books doesn't throw an exception, even after borrowing some.
     */
    @Test
    public void testViewAvailableBooks() {
        // Borrow one book and ensure viewing available books still works without exceptions.
        library.borrowBook("1234");
        assertDoesNotThrow(() -> library.viewAvailableBooks(), "Viewing available books should not throw an exception.");
    }
}
