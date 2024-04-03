// file encode utf8 build command -> javac -encoding utf-8 main.java

import java.util.Scanner;

public class main {

    static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        // 任意物件只要implements Flyer interface，便可視作一種flyer變數
        Flyer[] flyers = new Flyer[] {
                new Bird("a", "white"), new Bird("b", "black"),
                new Plane("py747", 114514d), new Plane("jp0s", 1919810d),
                new Balloon("yellow")
        };

        for (Flyer flyer : flyers) {
            System.out.println(flyer);
            flyer.fly();
        }
    }
}