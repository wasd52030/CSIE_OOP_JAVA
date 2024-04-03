// file encode utf8 build command -> javac -encoding utf-8 main.java

import java.io.IOException;
import java.util.Scanner;

public class main {
    public static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        Employee e1 = new Employee();
        Employee e2 = new Employee("abc");
        Employee e3 = new Employee("def", 20);
        Employee e4 = new Employee("ghi", 30, "qwerty");
        Employee e5 = new Employee("kkk", 40, "asdfgh", 56000);

        setEmployee(e1);
        setEmployee(e2);
        setEmployee(e3);
        setEmployee(e4);
        setEmployee(e5);

        showProfile(1, e1);
        showProfile(2, e2);
        showProfile(3, e3);
        showProfile(4, e4);
        showProfile(5, e5);
    }

    static void setEmployee(Employee h) {
        if (h.name == null) {
            h.name = randomStr(5);
        }

        if (h.age == 0) {
            h.age = (int) (Math.random() * (65 - 24 + 1) + 24);
        }

        if (h.department == null) {
            h.department = randomStr(10);
        }

        if (h.salery == 0) {
            h.salery = (int) (Math.random() * (100000 - 27470 + 1) + 27470);
        }
    }

    static String randomStr(int n) {
        var res = "";

        for (int i = 0; i < n; i++) {
            res += (char) (Math.random() * (122 - 97 + 1) + 97);
        }

        return res;
    }

    static void divider(int n) {
        System.out.printf("------------------%d------------------\n", n);
    }

    static void showProfile(int id, Employee e) {
        divider(id);
        System.out.println(e);
    }
}

class Employee {
    String name, department;
    int age, salery;

    public Employee() {
    }

    public Employee(String name) {
        this.name = name;
    }

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Employee(String name, int age, String department) {
        this.name = name;
        this.department = department;
        this.age = age;
    }

    public Employee(String name, int age, String department, int salery) {
        this.name = name;
        this.department = department;
        this.age = age;
        this.salery = salery;
    }

    @Override
    public String toString() {
        var strbuild = new StringBuilder();

        strbuild.append(String.format("[%s]\n", name));
        strbuild.append(String.format("年齡: %d\n", age));
        strbuild.append(String.format("部門: %s\n", department));
        strbuild.append(String.format("每月薪水: %d元\n", salery));

        return strbuild.toString();
    }
}