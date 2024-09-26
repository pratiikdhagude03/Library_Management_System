# Library Management System

This project is a simple *Library Management System* written in Java. The system allows users to perform basic library operations such as adding books, borrowing books, returning books, and viewing available books. The project follows *Test-Driven Development (TDD), with unit tests written using **JUnit 5* to ensure functionality.

## Requirements

* JDK verison 21.0.4 or any version

## Installation

1. Clone the repository: git clone https://github.com/pratiikdhagude03/Library_Management_System
2. Install any java interpretor to run this project. (like: Intellij, Ecllipse, Netbeans).

## Features

1. *Add Books*:
   - Add new books to the library with details such as ISBN, title, author, and publication year.
   - Each book has a unique identifier (ISBN).

2. *Borrow Books*:
   - Borrow a book from the library if it is available.
   - Ensures the book is available before borrowing.

3. *Return Books*:
   - Return a borrowed book.
   - Updates the book's availability in the library.

4. *View Available Books*:
   - View a list of all books currently available in the library.

## Technologies Used

- *Java*: Programming language.
- *JUnit 5*: Used for unit testing.
- *Eclipse IDE*: Development environment.

## Project Structure

```plaintext
LibraryManagementSystem/
│
├── src/
│   └── library/
│       ├── Book.java           # Represents a book object
│       ├── Library.java        # Contains the main library operations
│       └── LibraryTest.java    # JUnit test cases for Library class
│       └── Main.java           # Main class to interact with the system
│
│
└── README.md                   # Project documentation
