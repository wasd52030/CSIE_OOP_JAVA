// file encode utf8 build command -> javac -encoding utf-8 main.java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        int a;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.print("請輸入你的年齡: ");
            a = Integer.parseInt(reader.readLine());
            System.out.println("您的年齡為: " + a);
        } catch (Exception e) {
            if (e instanceof NumberFormatException) {
                System.out.println("請輸入數字！");
            }
        }
    }
}