// file encode utf8 build command -> javac -encoding utf-8 main.java

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import book.*;
import book.manager.LibraryManager;

public class main {

    static final Scanner scan = new Scanner(System.in);
    static final SimpleDateFormat ft = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        LibraryManager manager = new LibraryManager();

        var book = getBook(Book.class);
        var Ebook = getBook(EBook.class);
        var PrintedBook = getBook(PrintedBook.class);

        manager.borrowBook(book);
        manager.borrowBook(Ebook);
        manager.borrowBook(PrintedBook);

        manager.returnBook(Ebook);

        book.showProfile();
        Ebook.showProfile();
        PrintedBook.showProfile();
    }

    static <T extends Book> T getBook(Class<T> bookType) {
        System.out.print("請輸入書名: ");
        String title = scan.nextLine();
        System.out.print("請輸入作者: ");
        String author = scan.nextLine();

        if (bookType.equals(Book.class)) {
            return (T) new Book(title, author, ft.format(new Date()));
        } else if (bookType.equals(EBook.class)) {
            System.out.print("請輸入格式: ");
            String format = scan.nextLine();
            return (T) new EBook(title, author, format, ft.format(new Date()));
        } else if (bookType.equals(PrintedBook.class)) {
            System.out.print("請輸入頁數: ");
            int pages = Integer.valueOf(scan.nextLine());
            return (T) new PrintedBook(title, author, pages, ft.format(new Date()));
        } else {
            return null;
        }
    }
}