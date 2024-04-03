// file encode utf8 build command -> javac -encoding utf-8 main.java

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
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

        String user = "";
        boolean flag = false;

        while (!flag) {
            System.out.print("請輸入帳號: ");
            user = scan.nextLine();
            if (accountCounter == accounts.length) {
                System.out.println("人數已滿，無法進行註冊");
            }

            for (String account : accounts) {
                if (account.equals(user)) {
                    System.out.println("帳號已存在，請重新註冊");
                    break;
                } else {
                    flag = true;
                }
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

        String email = "";
        flag = false;
        while (!flag) {
            System.out.print("請輸入email address: ");
            email = scan.nextLine();
            if (email.indexOf("@") == -1 || email.indexOf("@") == 0 || email.indexOf("@") == email.length() - 1) {
                System.out.println("不合法的email，請重新輸入");
            } else {
                flag = true;
            }
        }
        String[] emailSplit = email.split("@");
        SimpleDateFormat ft = new SimpleDateFormat("YYYY/MM/dd hh:mm:ss");

        flag = false;
        System.out.println("需要更改預設密碼嗎(不需要請輸入N)？");
        String key = scan.nextLine();
        if (key.equals("N")) {
            flag = true;
        }
        while (!flag) {
            System.out.println("請輸入新密碼: ");
            String newPWD = scan.nextLine();

            boolean isOneUpper = false;
            for (char i : newPWD.toCharArray()) {
                if (i >= 'A' && i <= 'Z') {
                    isOneUpper = true;
                    break;
                }
            }

            if (newPWD.length() < 10) {
                System.out.println("密碼必須長於10！");
                System.out.println("請重新輸入！");
            } else if (!isOneUpper) {
                System.out.println("至少有一個大寫字母！");
            } else {
                flag = false;
                while (!flag) {
                    System.out.println("請重新輸入一次新密碼: ");
                    String secondNewPWD = scan.nextLine();
                    if (newPWD.equals(secondNewPWD)) {
                        flag = true;
                    } else {
                        System.out.println("兩次輸入不一，請重新輸入！");
                    }
                }
            }

            pwd = newPWD;
        }
        System.out.println("更改成功");

        System.out.printf("%s你好，歡迎你來自%s，您的註冊時間是 %s，您選擇的密碼是 %s…，請務必牢記你的密碼。\n", emailSplit[0], emailSplit[1],
                ft.format(new Date()), String.format("%c%s%c", pwd.charAt(0), "*".repeat(pwd.length()-2), pwd.charAt(pwd.length() - 1)));
    }
}