// file encode utf8 build command -> javac -encoding utf-8 main.java

import java.io.IOException;
import java.util.Scanner;

public class main {
    public static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        if (args.length == 1) {
            showArea(Integer.valueOf(args[0]));
        } else if (args.length == 2) {
            showArea(Integer.valueOf(args[0]), Integer.valueOf(args[1]));
        } else if (args.length == 3) {
            showArea(Integer.valueOf(args[0]), Integer.valueOf(args[1]), Integer.valueOf(args[2]));
        }
    }

    static void showArea(int x) {
        System.out.print("這是一個正方形，面積為: " + (x * x));
    }

    static void showArea(int x, int y) {
        System.out.print("這是一個正方形，面積為: " + (x * y));
    }

    static void showArea(int x, int y, int z) {
        if ((x * x) + (y * y) == (z * z)) {
            System.out.println("這是一個三角形，面積為: " + (x * y) / 2);
        } else if ((z * z) + (y * y) == (x * x)) {
            System.out.println("這是一個三角形，面積為: " + (y * z) / 2);
        } else if ((x * x) + (z * z) == (y * y)) {
            System.out.println("這是一個三角形，面積為: " + (x * z) / 2);
        } else {
            System.out.println("很抱歉您輸入的不是直角三角形我無法幫你計算面積");
        }
    }
}