// file encode utf8 build command -> javac -encoding utf-8 main.java

import java.io.IOException;
import java.util.Scanner;

public class main {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws NumberFormatException, IOException {
        System.out.println("Enter tow numbers");
        int a = Integer.valueOf(scan.nextLine());
        int b = Integer.valueOf(scan.nextLine());

        try {
            System.out.println(quotient(a, b));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static int quotient(int number1, int number2) {
        if (number2 == 0) {
            throw new ArithmeticException("divisor cannot be zero");
        }

        return number1 / number2;
    }
}