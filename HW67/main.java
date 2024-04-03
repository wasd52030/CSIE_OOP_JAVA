// file encode utf8 build command -> javac -encoding utf-8 main.java

import java.util.Scanner;

public class main {

    static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Rental r = null;

        System.out.print("提供(1)汽車 (2)摩托車的出租服務，請選擇: ");
        int key = Integer.valueOf(scan.nextLine());

        System.out.print("請輸入租賃天數: ");
        int days = Integer.valueOf(scan.nextLine());

        System.out.print("請選擇顏色: ");
        String color = scan.nextLine();

        switch (key) {
            case 1:
                System.out.print("需要幾門的汽車: ");
                int door = Integer.valueOf(scan.nextLine());
                r = new Car(color, door);
                break;
            case 2:
                System.out.print("需要籃子嗎(需要輸入Y)？");
                r = new Motorcycle(color, scan.nextLine().equals("Y"));
                break;
            default:
                break;
        }

        System.out.println(r);
        System.out.printf("總租金: %.2f\n", r.TotalRent(days));
    }
}