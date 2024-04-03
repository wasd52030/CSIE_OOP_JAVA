// file encode utf8 build command -> javac -encoding utf-8 main.java

import java.io.IOException;
import java.util.Scanner;

public class main {
    public static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        Book b1=getBook(),b2=getBook();
        b1.showProfile();
        System.out.println();
        b2.showProfile();
    }

    static Book getBook() {
        System.out.print("請輸入書籍名稱: ");
        String name = scan.nextLine();
        System.out.print("請輸入書籍出版年份: ");
        int year = Integer.valueOf(scan.nextLine());
        System.out.print("請輸入書籍作者: ");
        String author = scan.nextLine();
        System.out.print("請輸入書籍價格: ");
        int price = Integer.valueOf(scan.nextLine());

        return new Book(name, author, year, price);
    }
}

class Book {
    String name, author;
    int year, price;

    public Book() {
    }

    public Book(String name, String author, int year, int price) {
        this.name = name;
        this.author = author;
        this.year = year;
        this.price = price;
    }

    public int getDiscount() {
        return (year <= 2010) ? (int) Math.floor(price * 0.8) : price;
    }

    public void showProfile() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        var strBuild = new StringBuilder();

        var discount = getDiscount();

        strBuild.append(String.format("書籍名稱: %s\n", name));
        strBuild.append(String.format("出版年份: %d\n", year));
        strBuild.append(String.format("書籍作者: %s\n", author));

        if (price != discount) {
            strBuild.append(String.format("原價: %d，售價: %d\n", price, discount));
        } else {
            strBuild.append(String.format("售價: %d\n", price));
        }
        return strBuild.toString();
    }
}