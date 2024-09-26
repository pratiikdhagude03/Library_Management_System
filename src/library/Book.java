package library;

/**
 * Represents a book in the library with an ISBN, title, author, year of publication,
 * and availability status.
 */
public class Book {
    private final String isbn;
    private final String title;
    private final String author;
    private final int publicationYear;
    private boolean available;

    /**
     * Constructs a Book with the given ISBN, title, author, and publication year.
     * The book is available by default upon creation.
     *
     * @param isbn  the International Standard Book Number of the book
     * @param title the title of the book
     * @param author the author of the book
     * @param publicationYear the year the book was published
     */
    public Book(String isbn, String title, String author, int publicationYear) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.available = true;
    }

    /**
     * Returns the ISBN of the book.
     *
     * @return the ISBN
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Returns the title of the book.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the author of the book.
     *
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Returns the publication year of the book.
     *
     * @return the publication year
     */
    public int getPublicationYear() {
        return publicationYear;
    }

    /**
     * Checks if the book is currently available for borrowing.
     *
     * @return true if the book is available, false otherwise
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * Sets the availability status of the book.
     *
     * @param available the new availability status
     */
    public void setAvailable(boolean available) {
        this.available = available;
    }

    /**
     * Provides a string representation of the book, including its ISBN, title, author,
     * publication year, and availability status.
     *
     * @return the string representation of the book
     */
    @Override
    public String toString() {
        return String.format("Book {ISBN='%s', title='%s', author='%s', year=%d, available=%b}",
                isbn, title, author, publicationYear, available);
    }
}
