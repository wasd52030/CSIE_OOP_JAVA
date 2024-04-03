// file encode utf8 build command -> javac -encoding utf-8 main.java

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class main {

    static final Scanner scan = new Scanner(System.in);
    static final SimpleDateFormat ft = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        Book b1 = getBook();
        Book b2 = getBook();
        Book b3 = getBook();
        Book b4 = getBook();

        b1.borrowBook();
        b3.borrowBook();

        b1.showProfile();
        b2.showProfile();
        b3.showProfile();
        b4.showProfile();

        System.out.printf("總圖書數: %d%n", Book.getTotalBooks());
        System.out.printf("已借閱數: %d%n", Book.getTotalBorrowedBooks());
    }

    static Book getBook() {
        System.out.print("請輸入書名: ");
        String title = scan.nextLine();
        System.out.print("請輸入作者: ");
        String author = scan.nextLine();

        return new Book(title, author, ft.format(new Date()));
    }
}