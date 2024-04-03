// file encode utf8 build command -> javac -encoding utf-8 main.java

import java.util.Scanner;

public class main {

    static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Book b1=getBook();
        Book b2=getBook();

        b1.borrowBook();

        b1.showProfile();
        b2.showProfile();
    }

    static Book getBook(){
        System.out.print("請輸入書名: ");
        String title=scan.nextLine();
        System.out.print("請輸入作者: ");
        String author=scan.nextLine();

        return new Book(title, author);
    }
}