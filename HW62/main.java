// file encode utf8 build command -> javac -encoding utf-8 main.java

import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class main {

    static final Scanner scan = new Scanner(System.in);
    static final SimpleDateFormat ft = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");

    public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException,
            IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Hamburger[] hs = new Hamburger[2];
        Fries[] fs = new Fries[2];
        Cola[] cs = new Cola[1];

        setArr(hs);
        setArr(fs);
        setArr(cs);

        printArr(hs);
        printArr(fs);
        printArr(cs);
    }

    static <T extends Food> void setArr(T[] arr) throws NoSuchMethodException, SecurityException,
            InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        for (int i = 0; i < arr.length; i++) {
            System.out.print("請輸入餐點名稱: ");
            String name = scan.nextLine();
            System.out.print("請輸入製作時間: ");
            Double CookTime = Double.valueOf(scan.nextLine());

            var c = arr.getClass().getComponentType().getConstructor(String.class, double.class, int.class);
            arr[i] = (T) c.newInstance(name, CookTime, i + 1);
        }
    }

    static <T extends Food> void printArr(T[] arr) {
        for (T t : arr) {
            System.out.println(t);
            t.Menu();
        }
    }
}

class Hamburger extends Food {
    public Hamburger(String name, double CookTime, int id) {
        super(name, CookTime, id);
    }

    @Override
    void Menu() {
        System.out.println("餐點類型: 主餐");
        System.out.printf("編號: %d\n", id);
    }
}

class Fries extends Food {
    public Fries(String name, double CookTime, int id) {
        super(name, CookTime, id);
    }

    @Override
    void Menu() {
        System.out.println("餐點類型: 副餐");
        System.out.printf("編號: %d\n", id);
    }
}

class Cola extends Food {

    public Cola(String name, double CookTime, int id) {
        super(name, CookTime, id);
    }

    @Override
    void Menu() {
        System.out.println("餐點類型: 飲品");
        System.out.printf("編號: %d\n", id);
    }
}

abstract class Food {
    String name;
    Double CookTime;
    int id;

    public Food(String name, double CookTime, int id) {
        setName(name);
        setCookTime(CookTime);
        this.id = id;
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