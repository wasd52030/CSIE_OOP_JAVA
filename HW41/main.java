// file encode utf8 build command -> javac -encoding utf-8 main.java

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class main {
    public static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        ArrayList<User> Users = new ArrayList<>();

        boolean flag = false, aflag = false;

        while (!flag) {
            aflag = false;
            while (!aflag) {
                System.out.print("請輸入帳號: ");
                String account = scan.nextLine();
                if (Users.size() > 0) {
                    var exists = Users.stream().filter(u -> u.account.equals(account)).count();
                    if (exists > 0) {
                        System.out.println("帳號已存在，請重新註冊");
                    } else {
                        Users.add(new User(account));
                        aflag = true;
                        break;
                    }
                } else {
                    Users.add(new User(account));
                    aflag = true;
                }
            }

            System.out.println("還需要註冊嗎(不需要請輸入N)？");
            String key = scan.nextLine();
            if (key.equals("N")) {
                flag = true;
            }
        }

        Users.forEach((u) -> u.welcome());
    }
}

class User {
    public static final Scanner scan = new Scanner(System.in);

    String account, password, email;

    private final String specialSymbols = "!#$%^'()*+-,/";
    private final String numbers = "0123456789";
    private final String upperLetter = "QWERTYUIOPASDFGHJKLZXCVBNM";
    private final String lowerLetter = "qwertyuiopasdfghjklzxcvbnm";
    private final Date registerDate = new Date();
    private String[] emailSplit;
    private SimpleDateFormat ft = new SimpleDateFormat("YYYY/MM/dd hh:mm:ss");

    public User(String account) {
        setAccount(account);
        setDefaultPassWord();
        setEmail();
        changePassword();
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setEmail() {
        boolean flag = false;
        while (!flag) {
            System.out.print("請輸入email address: ");
            email = scan.nextLine();
            if (email.indexOf("@") == -1 || email.indexOf("@") == 0 || email.indexOf("@") == email.length() - 1) {
                System.out.println("不合法的email，請重新輸入");
            } else {
                flag = true;
            }
        }

        emailSplit = email.split("@");
    }

    public void changePassword() {
        boolean flag = false;
        System.out.println("需要更改預設密碼嗎(不需要請輸入N)？");
        String key = scan.nextLine();
        if (key.equals("N")) {
            return;
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

            this.password = newPWD;
        }
        System.out.println("更改成功");
    }

    public void welcome() {
        System.out.printf("%s你好，歡迎你來自%s，您的註冊時間是 %s，您選擇的密碼是 %s…，請務必牢記你的密碼。\n", emailSplit[0], emailSplit[1],
                ft.format(registerDate),
                String.format("%c%s%c", password.charAt(0), "*".repeat(password.length() - 2),
                        password.charAt(password.length() - 1)));
    }

    private void setDefaultPassWord() {
        System.out.print("請輸入密碼長度: ");
        int pwdLength = Integer.valueOf(scan.nextLine());
        if (pwdLength < 10) {
            System.out.println("密碼長度小於最低長度10，已自動設定成最低長度");
            pwdLength = 10;
        }

        for (int i = 0; i < pwdLength; i++) {
            int t = (int) (Math.random() * 4);
            switch (t) {
                case 0:
                    this.password += specialSymbols.charAt((int) (Math.random() * specialSymbols.length()));
                    break;
                case 1:
                    this.password += numbers.charAt((int) (Math.random() * numbers.length()));
                    break;
                case 2:
                    this.password += upperLetter.charAt((int) (Math.random() * upperLetter.length()));
                    break;
                case 3:
                    this.password += lowerLetter.charAt((int) (Math.random() * lowerLetter.length()));
                    break;
                default:
                    break;
            }
        }
    }
}