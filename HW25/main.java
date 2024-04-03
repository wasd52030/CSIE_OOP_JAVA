// file encode utf8 build command -> javac -encoding utf-8 main.java

import java.io.IOException;
import java.util.Scanner;

public class main {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.print("請輸入分隔線的長度: ");
        int len = Integer.valueOf(scan.nextLine());
        System.out.print("請輸入分隔線的符號: ");
        char type = scan.nextLine().charAt(0);
        showLine(len, type);
    }

    static void showLine(int len, char type) {
        if (len == 0) {
            len = 15;
        } else if (len < 0) {
            len = 1;
            type = '@';
        }

        for (int i = 0; i < len; i++) {
            System.out.print(type);
        }
        System.out.println();
    }
}