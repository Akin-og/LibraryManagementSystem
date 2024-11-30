import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", ISBN: " + isbn + ", Available: " + isAvailable;
    }
}

class Library {
    private ArrayList<Book> catalog;

    public Library() {
        catalog = new ArrayList<>();
    }

    public void addBook(Book book) {
        catalog.add(book);
    }

    public void displayCatalog() {
        for (Book book : catalog) {
            System.out.println(book);
        }
    }

    public Book searchByIsbn(String isbn) {
        for (Book book : catalog) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    public boolean borrowBook(String isbn) {
        Book book = searchByIsbn(isbn);
        if (book != null && book.isAvailable()) {
            book.setAvailable(false);
            return true;
        }
        return false;
    }

    public void returnBook(String isbn) {
        Book book = searchByIsbn(isbn);
        if (book != null) {
            book.setAvailable(true);
        }
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        library.addBook(new Book("Harry Potter", "J.K. Rowling", "1234567890"));
        library.addBook(new Book("Lord of the Rings", "J.R.R. Tolkien", "0987654321"));

        while (true) {
            System.out.println("Library Management System:");
            System.out.println("1. Display Catalog");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    library.displayCatalog();
                    break;
                case 2:
                    System.out.print("Enter ISBN of the book to borrow: ");
                    String isbn = scanner.nextLine();
                    if (library.borrowBook(isbn)) {
                        System.out.println("Book borrowed successfully.");
                    } else {
                        System.out.println("Book is not available.");
                    }
                    break;
                case 3:
                    System.out.print("Enter ISBN of the book to return: ");
                    isbn = scanner.nextLine();
                    library.returnBook(isbn);
                    System.out.println("Book returned successfully.");
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
