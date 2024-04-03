// file encode utf8 build command -> javac -encoding utf-8 main.java

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class main {

    static final Scanner scan = new Scanner(System.in);
    static final SimpleDateFormat ft = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        Cat c1 = new Cat();
        System.out.println(c1.toString());

        // 可以編譯，無法執行
        // 因為不能確保Animal型別的物件一定是Cat Class的Instance
        Animal c3 = new Animal("小花", 10, 8, "喵~喵");
        c3.toString();
        Cat c2 = (Cat) c3;
        c2.toString();
    }
}

class Cat extends Animal {
    String breed;

    public Cat() {
    }

    public Cat(String name, int age, int weight, String voice, String breed) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.voice = voice;
        this.breed = breed;
    }

    @Override
    public String toString() {
        return (super.toString() + String.format(", breed=%s", breed)).replace("Animal",
                this.getClass().getSimpleName());
    }
}

class Animal {
    String name;
    int age;
    int weight;
    String voice;

    public Animal() {
        System.out.println("我是 Animal 的無參數建構式");
    }

    public Animal(String name, int age, int weight, String voice) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.voice = voice;
    }

    @Override
    public String toString() {
        var strBuild = new StringBuilder();

        strBuild.append("I am a Animal instance,");
        strBuild.append(String.format("my name is %s, %d years old, ", name, age));
        strBuild.append(String.format("weight = %d, voice = %s", weight, voice));

        return strBuild.toString();
    }
}