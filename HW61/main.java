// file encode utf8 build command -> javac -encoding utf-8 main.java

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class main {

    static final Scanner scan = new Scanner(System.in);
    static final SimpleDateFormat ft = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        Hamburger h = new Hamburger("漢堡", 2.5);
        Fries f = new Fries("薯條", 1.5);
        Cola c = new Cola("可樂", 1);

        System.out.println(h);
        h.Menu();

        System.out.println(f);
        f.Menu();

        System.out.println(c);
        c.Menu();
    }
}

class Hamburger extends Food {
    public Hamburger(String name, double CookTime) {
        super(name, CookTime);
    }

    @Override
    void Menu() {
        System.out.println("餐點類型: 主餐");
    }
}

class Fries extends Food {
    public Fries(String name, double CookTime) {
        super(name, CookTime);
    }

    @Override
    void Menu() {
        System.out.println("餐點類型: 副餐");
    }
}

class Cola extends Food {

    public Cola(String name, double CookTime) {
        super(name, CookTime);
    }

    @Override
    void Menu() {
        System.out.println("餐點類型: 飲品");
    }
}

abstract class Food {
    String name;
    Double CookTime;

    public Food(String name, double CookTime) {
        setName(name);
        setCookTime(CookTime);
    }

    abstract void Menu();

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCookTime(Double cookTime) {
        CookTime = cookTime;
    }

    public Double getCookTime() {
        return CookTime;
    }

    @Override
    public String toString() {
        var strBuild = new StringBuilder();

        strBuild.append(String.format("名稱: %s, 製作時間: %.1f", name, CookTime));

        return strBuild.toString();
    }
}