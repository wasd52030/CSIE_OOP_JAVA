// file encode utf8 build command -> javac -encoding utf-8 main.java

import java.util.Scanner;

public class main {

    static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        var c1 = getCharacter();
        var c2 = getCharacter();
        var c3 = getCharacter();

        c1.showProfile();
        c2.showProfile();
        c3.showProfile();
    }

    static Character getCharacter() {
        Character c = null;

        System.out.print("請輸入創立角色名: ");
        String name = scan.nextLine();
        System.out.println("1.Warrior");
        System.out.println("2.Mage");
        System.out.println("3.Hunter");
        System.out.print("輸入職業代號選擇職業: ");
        int j = Integer.valueOf(scan.nextLine());

        switch (j) {
            case 1:
                c = new Warrior(name, 250, 50, 15, 15, "Warrior");
                break;
            case 2:
                c = new Mage(name, 150, 150, 10, 20, "Mage");
                break;
            case 3:
                c = new Hunter(name, 180, 100, 20, 10, "Hunter");
                break;
            default:
                System.out.println("未知職業，請重新創建！");
                getCharacter();
                break;
        }

        return c;
    }

}