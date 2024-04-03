// file encode utf8 build command -> javac -encoding utf-8 main.java

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class main {
    public static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        Book b1 = getBook(), b2 = getBook();
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
    // 設計上showprofile是依賴於重載的toString method
    // 而class init上已經交給constructor了
    // 且題目中沒有重新賦值的問題
    // 目前public跟private效果一樣
    // private變數的意義在於不讓class外部取得class內部的資料
    private String name, author;
    private int year, price;

    public Book() {
    }

    public Book(String name, String author, int year, int price) {
        setName(name);
        setAuthor(author);
        setYear(year);
        setPrice(price);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {

        if (year > 1938 && year < LocalDate.now().getYear()) {
            this.year = year;
        } else {
            System.out.println("出版日期需大於1938小於今年！");
            System.out.println("將自動設為0，請重新設定！");
            this.price = 0;
        }
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        if (price > 0) {
            this.price = price;
        } else {
            System.out.println("價格需大於0！");
            System.out.println("將自動設為0，請重新設定！");
            this.price = 0;
        }
    }

    public int getDiscount() {
        return (year <= 2010 && year > 1938) ? (int) Math.floor(price * 0.8) : price;
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