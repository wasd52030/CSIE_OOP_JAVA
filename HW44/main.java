// file encode utf8 build command -> javac -encoding utf-8 main.java

import java.io.IOException;
import java.util.Scanner;

public class main {
    public static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        Car c1 = new Car();
        c1.setBarand("TOMATO");
        c1.setLength(3);
        c1.setPower(600);
        c1.setYear(2015);

        Car c2 = new Car();
        c2.setBarand("dllm");
        c2.setLength(114.514);
        c2.setPower(1919.810);
        c2.setYear(2028);

        showProfile(c1);
        showProfile(c2);
    }

    static void showProfile(Car c) {
        System.out.println(c);
    }
}

class Car {
    private String barand;
    private int year;
    private double length, power;

    public String getBarand() {
        return barand;
    }

    public void setBarand(String barand) {
        if (barand == null || barand.equals("")) {
            this.barand = null;
        } else {
            this.barand = barand;
        }
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        if (length > 4) {
            this.length = length;
        } else {
            this.length = 4;
        }
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        if (power >= 500 && power <= 5000) {
            this.power = power;
        } else {
            this.power = 500;
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year >= 2000 && year <= 2023) {
            this.year = year;
        } else {
            this.year = 2000;
        }
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
