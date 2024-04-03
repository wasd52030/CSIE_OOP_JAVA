// file encode utf8 build command -> javac -encoding utf-8 main.java

import java.io.IOException;
import java.util.Scanner;

public class main {
    public static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        House h1 = new House();
        House h2 = new House("abc");
        House h3 = new House("def", 4000);
        House h4 = new House("ghi", 5000, "qwerty");

        setHouse(h1);
        setHouse(h2);
        setHouse(h3);
        setHouse(h4);

        divider(1);
        System.out.println(h1);

        divider(2);
        System.out.println(h2);

        divider(3);
        System.out.println(h3);

        divider(4);
        System.out.println(h4);
    }

    static void setHouse(House h) {
        String name;

        if (h.name == null && h.rent == 0 && h.address == null) {
            System.out.print("請輸入房屋名稱: ");
            name = scan.nextLine();
            h.name = name;

            System.out.printf("請輸入%s每月租金: ", name);
            h.rent = Integer.valueOf(scan.nextLine());

            System.out.printf("請輸入%s地址: ", name);
            h.address = scan.nextLine();
        } else if (h.rent == 0 && h.address == null) {
            System.out.printf("請輸入%s每月租金: ", h.name);
            h.rent = Integer.valueOf(scan.nextLine());

            System.out.printf("請輸入%s地址: ", h.name);
            h.address = scan.nextLine();
        } else if (h.address == null) {
            System.out.printf("請輸入%s地址: ", h.name);
            h.address = scan.nextLine();
        }
    }

    static void divider(int n) {
        System.out.printf("------------------%d------------------\n", n);
    }
}

class House {
    String name, address;
    int rent;

    public House() {
    }

    public House(String name) {
        this.name = name;
    }

    public House(String name, int rent) {
        this.name = name;
        this.rent = rent;
    }

    public House(String name, int rent, String address) {
        this.name = name;
        this.address = address;
        this.rent = rent;
    }

    @Override
    public String toString() {
        var strbuild = new StringBuilder();

        strbuild.append(String.format("[%s]\n", name));
        strbuild.append(String.format("每月租金: %d元\n", rent));
        strbuild.append(String.format("地址: %s\n", address));

        return strbuild.toString();
    }
}