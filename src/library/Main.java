package library;

/**
 * Main class to demonstrate the functionality of the Library.
 * It performs operations such as adding books, borrowing, returning, and viewing available books.
 */
public class Main {

    /**
     * Entry point of the application.
     * It creates a library, adds books, performs borrow and return operations, and displays available books.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        Library library = new Library();

        // Add books to the library
        addSampleBooks(library);

        // Borrow a book and display available books
        borrowAndDisplayAvailableBooks(library, "1234", "Effective Java");

        // Return the borrowed book and display available books again
        returnAndDisplayAvailableBooks(library, "1234", "Effective Java");
    }

    /**
     * Adds sample books to the library.
     *
     * @param library the library to add books to
     */
    private static void addSampleBooks(Library library) {
        library.addBook(new Book("1234", "Effective Java", "Joshua Bloch", 2018));
        library.addBook(new Book("5678", "Clean Code", "Robert C. Martin", 2008));
    }

    /**
     * Borrows a book and displays the available books in the library.
     *
     * @param library the library from which the book is borrowed
     * @param isbn the ISBN of the book to borrow
     * @param bookTitle the title of the book (for display purposes)
     */
    private static void borrowAndDisplayAvailableBooks(Library library, String isbn, String bookTitle) {
        library.borrowBook(isbn);
        System.out.println("Available books after borrowing '" + bookTitle + "':");
        library.viewAvailableBooks();
        System.out.println();
    }

    /**
     * Returns a borrowed book and displays the available books in the library.
     *
     * @param library the library to which the book is returned
     * @param isbn the ISBN of the book to return
     * @param bookTitle the title of the book (for display purposes)
     */
    private static void returnAndDisplayAvailableBooks(Library library, String isbn, String bookTitle) {
        library.returnBook(isbn);
        System.out.println("Available books after returning '" + bookTitle + "':");
        library.viewAvailableBooks();
        System.out.println();
    }
}
