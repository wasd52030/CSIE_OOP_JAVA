// file encode utf8 build command -> javac -encoding utf-8 main.java

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class main {

    static final Scanner scan = new Scanner(System.in);
    static final SimpleDateFormat ft = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        Animal a1 = new Animal();
        Animal a2 = new Animal("dog", 14, 65, "www");

        // 如果不做任何事而直接呼叫toString()
        // 可以得到以下輸出
        // Animal@2f7c7260
        // Animal@2d209079
        // 已知java的物件都繼承自Object
        // 而Object中已經有定義了toString()
        // 得到的結果便是由Object.toString()而來

        // 在override toString之後
        // 可以得到以下輸出
        // I am a Animal instance,my name is null, 0 years oldweight = 0, voice = null
        // I am a Animal instance,my name is dog, 14 years oldweight = 65, voice = www
        System.out.println(a1.toString());
        System.out.println(a2.toString());
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