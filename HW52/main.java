// file encode utf8 build command -> javac -encoding utf-8 main.java

import java.util.Scanner;

public class main {

    static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Equipment e1 = new Equipment("劍", 10, 0);
        Equipment e2 = new Equipment("杖", 0, 15);

        var c1 = getCharacter(e1, e2);
        var c2 = getCharacter(e1, e2);
        var c3 = getCharacter(e1, e2);
        System.out.println();

        c1.showProfile();
        c2.showProfile();
        c3.showProfile();
    }

    static Character getCharacter(Equipment e1, Equipment e2) {
        Character c = null;
        Equipment e = null;

        System.out.print("請輸入創立角色名: ");
        String name = scan.nextLine();
        System.out.println("1.Warrior");
        System.out.println("2.Mage");
        System.out.println("3.Hunter");
        System.out.print("輸入職業代號選擇職業: ");
        int j = Integer.valueOf(scan.nextLine());

        switch (j) {
            case 1:
                e = gEquipment(e1, e2);
                c = new Warrior(name, 250, 50, 15, 15, "Warrior", e);
                break;
            case 2:
                e = gEquipment(e1, e2);
                c = new Mage(name, 150, 150, 10, 20, "Mage", e);
                break;
            case 3:
                e = gEquipment(e1, e2);
                c = new Hunter(name, 180, 100, 20, 10, "Hunter", e);
                break;
            default:
                System.out.println("未知職業，請重新創建！");
                getCharacter(e1, e2);
                break;
        }

        return c;
    }

    static Equipment gEquipment(Equipment e1, Equipment e2) {
        Equipment E = null;

        System.out.println("1.劍");
        System.out.println("2.杖");
        System.out.println("3.不裝備");
        System.out.print("輸入職業代號選擇裝備: ");
        int e = Integer.valueOf(scan.nextLine());

        switch (e) {
            case 1:
                E = e1;
                break;
            case 2:
                E = e2;
                break;
            case 3:
                E = null;
                break;
            default:
                System.out.println("未知武器，請重新選擇！");
                gEquipment(e1, e2);
                break;
        }

        return E;
    }
}