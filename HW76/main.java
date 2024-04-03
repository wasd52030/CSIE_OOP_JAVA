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
        var department = getValue(String.class, "部門");
        var officecall = getValue(String.class, "職務");

        try {
            Member m = new Manager(name, address, age, salery, phone, department, officecall);
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

    public Member(String n, String addr, int age, int s, String phone) {
        setName(n);
        setAddress(addr);
        setPhone(phone);
        setAge(age);
        setSalery(s);
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
        strBuild.append(String.format("地址: %s, 電話: %s, 薪水: %d, ", address, phone, salery));

        return strBuild.toString();
    }
}

class Manager extends Member {
    private String department, officecall;

    Manager(String name) {
    }

    Manager(String name, String address) {
    }

    Manager(String name, String address, int age) {
    }

    Manager(String name, String address, int age, int salary) {
    }

    public Manager(String name, String address, int age, int salary, String phone) {
        super(name, address, age, salary, phone);
    }

    public Manager(String name, String address, int age, int salary, String phone, String department) {
        super(name, address, age, salary, phone);
        setDepartment(department);
    }

    public Manager(String name, String address, int age, int salary, String phone, String department,
            String officecall) {
        super(name, address, age, salary, phone);
        setDepartment(department);
        setOfficecall(officecall);
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setOfficecall(String officecall) {
        this.officecall = officecall;
    }

    @Override
    public String toString() {
        String d = String.format("部門: %s, ", department);
        String o = String.format("職務: %s", officecall);
        return super.toString() + d + o;
    }
}