package library;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a library that manages books. The library allows adding, borrowing, returning,
 * and viewing available books.
 */
public class Library {
    private final Map<String, Book> books;

    /**
     * Constructs an empty Library.
     */
    public Library() {
        this.books = new HashMap<>();
    }

    /**
     * Adds a new book to the library.
     *
     * @param book the book to add
     * @throws IllegalArgumentException if a book with the same ISBN already exists in the library
     */
    public void addBook(Book book) {
        String isbn = book.getIsbn();
        if (books.containsKey(isbn)) {
            throw new IllegalArgumentException("Book with ISBN " + isbn + " already exists.");
        }
        books.put(isbn, book);
    }

    /**
     * Borrows a book from the library by its ISBN.
     *
     * @param isbn the ISBN of the book to borrow
     * @throws IllegalArgumentException if the book is not found in the library
     * @throws IllegalStateException    if the book is already borrowed
     */
    public void borrowBook(String isbn) {
        Book book = findBook(isbn);
        if (!book.isAvailable()) {
            throw new IllegalStateException("Book with ISBN " + isbn + " is already borrowed.");
        }
        book.setAvailable(false);
    }

    /**
     * Returns a borrowed book to the library by its ISBN.
     *
     * @param isbn the ISBN of the book to return
     * @throws IllegalArgumentException if the book is not found in the library
     * @throws IllegalStateException    if the book was not borrowed
     */
    public void returnBook(String isbn) {
        Book book = findBook(isbn);
        if (book.isAvailable()) {
            throw new IllegalStateException("Book with ISBN " + isbn + " is not borrowed.");
        }
        book.setAvailable(true);
    }

    /**
     * Displays all available books in the library.
     */
    public void viewAvailableBooks() {
        books.values().stream()
                .filter(Book::isAvailable)
                .forEach(System.out::println);
    }

    /**
     * Helper method to find a book by its ISBN.
     *
     * @param isbn the ISBN of the book
     * @return the book with the given ISBN
     * @throws IllegalArgumentException if the book is not found in the library
     */
    private Book findBook(String isbn) {
        Book book = books.get(isbn);
        if (book == null) {
            throw new IllegalArgumentException("Book with ISBN " + isbn + " not found.");
        }
        return book;
    }
}
