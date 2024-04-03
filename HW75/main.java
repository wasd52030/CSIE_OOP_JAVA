// file encode utf8 build command -> javac -encoding utf-8 main.java

import java.io.IOException;
import java.util.Scanner;

public class main {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws NumberFormatException, IOException {
        var name = getValue(String.class, "姓名");
        var age = getValue(Integer.class, "年齡");
        var address = getValue(String.class, "地址");
        var salery = getValue(Integer.class, "薪水");
        var phone = getValue(String.class, "電話");

        try {
            Member m = new Member(name, address, phone, age, salery);
            m.showProfile();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static <T> T getValue(Class<T> classType, String fieldName) {
        try {
            T result = null;
            System.out.printf("請輸入%s: ", fieldName);
            switch (classType.getSimpleName()) {
                case "Integer":
                    result = (T) Integer.valueOf(scan.nextLine());
                    break;
                case "Double":
                    result = (T) Double.valueOf(scan.nextLine());
                    break;
                case "String":
                    result = (T) scan.nextLine();
                    break;
                default:
                    break;
            }

            return result;
        } catch (Exception e) {
            System.out.println("輸入有誤，請重新輸入");
            return getValue(classType, fieldName);
        }
    }
}

class Member {
    private String name, address, phone;
    private int age, salery;

    public Member() {
    }

    public Member(String name, String address, String phone, int age, int salery) {
        setName(name);
        setAddress(address);
        setPhone(phone);
        setAge(age);
        setSalery(salery);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("age must greater than 0!");
        }
    }

    public int getSalery() {
        return salery;
    }

    public void setSalery(int salery) {
        if (salery > 0) {
            this.salery = salery;
        } else {
            throw new IllegalArgumentException("salery must greater than 0!");
        }
    }

    public void showProfile() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        var strBuild = new StringBuilder();

        strBuild.append(String.format("姓名: %s, 年齡: %d", name, age));
        strBuild.append(String.format("地址: %s, 電話: %s, 薪水: %d", address, phone, salery));

        return strBuild.toString();
    }
}