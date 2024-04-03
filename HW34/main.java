// file encode utf8 build command -> javac -encoding utf-8 main.java

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class main {
    public static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] accounts = new String[10];
        Arrays.fill(accounts, "");

        String specialSymbols = "!#$%^'()*+-,/";
        String numbers = "0123456789";
        String upperLetter = "QWERTYUIOPASDFGHJKLZXCVBNM";
        String lowerLetter = "qwertyuiopasdfghjklzxcvbnm";

        int accountCounter = 0;

        System.out.print("請輸入帳號: ");
        String user = "";
        user = scan.nextLine();
        if (accountCounter == accounts.length) {
            System.out.println("人數已滿，無法進行註冊");
        }

        for (String account : accounts) {
            if (account.equals(user)) {
                System.out.println("帳號已存在，請重新註冊");
                return;
            }
        }

        accounts[accountCounter] = user;
        accountCounter++;

        System.out.print("請輸入密碼長度: ");
        int pwdLength = Integer.valueOf(scan.nextLine());
        if (pwdLength < 10) {
            System.out.println("密碼長度小於最低長度10，已自動設定成最低長度");
            pwdLength = 10;
        }

        String pwd = "";
        for (int i = 0; i < pwdLength; i++) {
            int t = (int) (Math.random() * 4);
            switch (t) {
                case 0:
                    pwd += specialSymbols.charAt((int) (Math.random() * specialSymbols.length()));
                    break;
                case 1:
                    pwd += numbers.charAt((int) (Math.random() * numbers.length()));
                    break;
                case 2:
                    pwd += upperLetter.charAt((int) (Math.random() * upperLetter.length()));
                    break;
                case 3:
                    pwd += lowerLetter.charAt((int) (Math.random() * lowerLetter.length()));
                    break;
                default:
                    break;
            }
        }
        System.out.printf("%s你好，您選擇的密碼是 %s…，請務必牢記你的密碼。", user, pwd);
    }
}