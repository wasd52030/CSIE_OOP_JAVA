// file encode utf8 build command -> javac -encoding utf-8 main.java

import java.io.IOException;
import java.util.Scanner;

public class main {
    public static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        Dog d1 = getDog();

        showProfile(d1);
    }

    static Dog getDog() {

        System.out.print("請輸入寵物姓名: ");
        String name = scan.nextLine();

        System.out.print("請輸入寵物品種: ");
        String variety = scan.nextLine();

        System.out.print("請輸入寵物年齡: ");
        int age = Integer.valueOf(scan.nextLine());

        return new Dog(name, age, variety);
    }

    static void divider() {
        System.out.printf("------------------你的寵物資訊------------------\n");
    }

    static void showProfile(Dog d) {
        divider();
        System.out.println(d);
    }
}

class Dog {
    private final String[] varieties = new String[] {
            "哈士奇", "鬆獅", "柴犬", "臘腸犬", "吉娃娃",
            "博美犬", "貴賓犬", "牧羊犬", "藏敖", "柯基"
    };

    String name, variety;
    int age;

    public Dog() {
    }

    public Dog(String name) {
        setName(name);
    }

    public Dog(String name, int age) {
        setName(name);
        setAge(age);
    }

    public Dog(String name, int age, String variety) {
        setName(name);
        setVariety(variety);
        setAge(age);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        if (age < 1) {
            age = 1;
        }
        this.age = age;
    }

    public void setVariety(String variety) {
        for (String v : varieties) {
            if (v.equals(variety)) {
                this.variety = variety;
                return;
            }
        }

        this.variety = "其他品種";
    }

    @Override
    public String toString() {
        var strbuild = new StringBuilder();

        strbuild.append(String.format("[%s]\n", name));
        strbuild.append(String.format("年齡: %d\n", age));
        strbuild.append(String.format("品種: %s\n", variety));

        return strbuild.toString();
    }
}