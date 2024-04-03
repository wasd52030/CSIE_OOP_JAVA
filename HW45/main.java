// file encode utf8 build command -> javac -encoding utf-8 main.java

import java.io.IOException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException {
        Car c1 = new Car();
        c1.setBarand("dllm");
        c1.setLength(3);
        c1.setPower(600);
        c1.setYear(2015);

        Car c2 = new Car("Benz", 4.2);
        c2.setPower(1145);
        c2.setYear(1999);

        Car c3 = new Car("Bugatti", 6.2, 7993);
        c3.setYear(2019);

        Car c4 = new Car("Bentley", 5.2, 4500, 2022);

        showProfile(c1);
        showProfile(c2);
        showProfile(c3);
        showProfile(c4);
    }

    static void showProfile(Car c) {
        System.out.println(c);
    }
}

class Car {
    private static final Scanner scan = new Scanner(System.in);

    private String barand;
    private int year;
    private double length, power;

    public Car() {
    }

    public Car(String barand, double length) {
        setBarand(barand);
        setLength(length);
    }

    public Car(String barand, double length, double power) {
        this(barand, length);
        setPower(power);
    }

    public Car(String barand, double length, double power, int year) {
        this(barand, length, power);
        setYear(year);
    }

    public String getBarand() {
        return barand;
    }

    public void setBarand(String barand) {
        while (barand == null || barand.equals("")) {
            System.out.println("車子品牌必不為空字串或null！");
            System.out.print("請重新輸入: ");
            barand = scan.nextLine();
        }
        this.barand = barand;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        while (!(length > 4)) {
            System.out.println("車長必大於4！");
            System.out.print("請重新輸入: ");
            length = Double.valueOf(scan.nextLine());
        }
        this.length = length;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {

        while (!(power >= 500 && power <= 5000)) {
            System.out.println("排氣量必介於500-5000！");
            System.out.print("請重新輸入: ");
            power = Double.valueOf(scan.nextLine());
        }
        this.power = power;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {

        while (!(year >= 2000 && year <= 2023)) {
            System.out.println("年分必介於2000-2023！");
            System.out.print("請重新輸入: ");
            year = Integer.valueOf(scan.nextLine());
        }
        this.year = year;
    }

    @Override
    public String toString() {
        var strBuild = new StringBuilder();

        strBuild.append(String.format("汽車品牌: %s\n", getBarand()));
        strBuild.append(String.format("車長: %.3f m\n", getLength()));
        strBuild.append(String.format("排氣量: %.3f cc\n", getPower()));
        strBuild.append(String.format("出廠年份: %d\n", getYear()));

        return strBuild.toString();
    }
}
