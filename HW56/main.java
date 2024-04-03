// file encode utf8 build command -> javac -encoding utf-8 main.java

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import book.Book;


public class main {

    static final Scanner scan = new Scanner(System.in);
    static final SimpleDateFormat ft = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        Book b1 = getBook();

        b1.showProfile();
    }

    static Book getBook() {
        System.out.print("請輸入書名: ");
        String title = scan.nextLine();
        System.out.print("請輸入作者: ");
        String author = scan.nextLine();

        return new Book(title, author, ft.format(new Date()));
    }
}