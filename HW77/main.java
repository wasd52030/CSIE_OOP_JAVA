// file encode utf8 build command -> javac -encoding utf-8 main.java

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class main {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws NumberFormatException, IOException {
        var name = getValue(String.class, "姓名");
        var age = getValue(Integer.class, "年齡");
        var address = getValue(String.class, "地址");
        var salery = getValue(Integer.class, "薪水");
        var phone = getValue(String.class, "電話");
        var expertise = getValue(String.class, "專業技能");

        try {
            Member m = new Engineer(name, address, age, salery, phone, expertise);
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

abstract class Member {
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
        if (Pattern.matches("09\\d{2}-\\d{3}-\\d{3}", phone)) {
            this.phone = phone;
        } else {
            throw new IllegalArgumentException("illegal phone format!");
        }
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

    abstract void showProfile();

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

    public Manager() {
    }

    public Manager(String name) {
        super(name, null, 0, 0, null);
    }

    public Manager(String name, String address) {
        super(name, address, 0, 0, null);
    }

    public Manager(String name, String address, int age) {
        super(name, address, age, 0, null);
    }

    public Manager(String name, String address, int age, int salary) {
        super(name, address, age, salary, null);
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

    @Override
    void showProfile() {
        System.err.println(this);
    }
}

class Engineer extends Member {

    private String expertise;

    public Engineer() {
    }

    public Engineer(String name) {
        super(name, null, 0, 0, null);
    }

    public Engineer(String name, String address) {
        super(name, address, 0, 0, null);
    }

    public Engineer(String name, String address, int age) {
        super(name, address, age, 0, null);
    }

    public Engineer(String name, String address, int age, int salary) {
        super(name, address, age, salary, null);
    }

    public Engineer(String name, String address, int age, int salary, String phone) {
        super(name, address, age, salary, phone);
    }

    public Engineer(String name, String address, int age, int salary, String phone, String expertise) {
        super(name, address, age, salary, phone);
        setExpertise(expertise);
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    @Override
    void showProfile() {
        System.err.println(this);
    }

    @Override
    public String toString() {
        String e = String.format("專業技能: %s", expertise);
        return super.toString() + e;
    }
}