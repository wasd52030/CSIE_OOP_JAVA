package book.manager;

import book.Book;

public class LibraryManager {
    public void borrowBook(Book book) {
        book.borrowBook();
    }

    public void returnBook(Book book) {
        book.returnBook();
    }
}
