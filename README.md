# Library Management System

## Description

This Java program implements a simple **Library Management System**, providing functionality for managing a collection of books. It allows users to perform key operations like viewing the catalog, borrowing books, and returning them using a command-line interface.

## Features

- **Book Catalog Management**:  
  Add books to the catalog and display the list of available books.

- **Search by ISBN**:  
  Locate books in the catalog using their unique ISBN.

- **Borrow and Return Books**:  
  Mark books as borrowed or returned while maintaining their availability status.

   ```

 **Choose an Option**:  
   The menu provides the following choices:  
   - Display all books in the catalog.  
   - Borrow a book by entering its ISBN.  
   - Return a borrowed book by entering its ISBN.  
   - Exit the application.

## Classes

### `Book`
Represents a book in the library.  
**Attributes**:
- `title`: The title of the book.
- `author`: The author of the book.
- `isbn`: The unique identifier of the book.
- `isAvailable`: Boolean indicating availability.

**Methods**:
- `getTitle()`, `getAuthor()`, `getIsbn()`: Access book details.
- `isAvailable()`: Check if the book is available.
- `setAvailable(boolean)`: Update availability.
- `toString()`: Display book details.

### `Library`
Handles library operations.  
**Attributes**:
- `catalog`: A collection of `Book` objects.

**Methods**:
- `addBook(Book book)`: Add a book to the catalog.
- `displayCatalog()`: Display all books in the library.
- `searchByIsbn(String isbn)`: Find a book by ISBN.
- `borrowBook(String isbn)`: Borrow a book if available.
- `returnBook(String isbn)`: Return a borrowed book.

