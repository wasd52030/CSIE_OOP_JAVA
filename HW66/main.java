// file encode utf8 build command -> javac -encoding utf-8 main.java

import java.util.Scanner;

public class main {

    static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Light light = new Light("燈", "客廳大燈", "客廳", 250);
        RobotVacuum robotVacuum = new RobotVacuum("掃地機器人", "掃地機器人", "廚房", 1000);
        SecurityCamera securityCamera = new SecurityCamera("安全攝影機", "監視器", "門口", 1000);

        menu(light, robotVacuum, securityCamera);
    }

    static void menu(Appliances... appliances) {
        System.out.print("請輸入要選擇的家電代號 (1)燈 (2)掃地機器人 (3)安全攝影機 (4)離開系統: ");
        var key = Integer.valueOf(scan.nextLine());
        if (key == 4) {
            return;
        } else {
            var a = appliances[key - 1];
            a.showProfile();

            if (a instanceof IOperate) {
                System.out.print("執行Operate(Y)/回到首頁(N): ");
                var k = scan.nextLine();
                if (k.equals("Y")) {
                    ((IOperate) a).Operate();
                } else if (k.equals("N")) {
                    menu(appliances);
                }
            } else {
                System.out.print("回到首頁(Y): ");
                if (scan.nextLine().equals("Y")) {
                    menu(appliances);
                }
                return;
            }
        }
    }
}