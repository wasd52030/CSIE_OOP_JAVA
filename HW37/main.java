// file encode utf8 build command -> javac -encoding utf-8 main.java

import java.io.IOException;
import java.util.Scanner;

public class main {
    public static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        House h1, h2;

        h1 = getHouse();
        h2 = getHouse();

        divider(1);
        System.out.println(h1);
        divider(2);
        System.out.println(h2);
    }

    static House getHouse() {
        System.out.print("請輸入房屋名稱: ");
        String name = scan.nextLine();

        System.out.printf("請輸入%s每月租金: ", name);
        int rent = Integer.valueOf(scan.nextLine());

        System.out.printf("請輸入%s地址: ", name);
        String address = scan.nextLine();

        return new House(name, address, rent);
    }

    static void divider(int n) {
        System.out.printf("------------------%d------------------\n", n);
    }
}

class House {
    String name, address;
    int rent;

    public House(String name, String address, int rent) {
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