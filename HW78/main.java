// file encode utf8 build command -> javac -encoding utf-8 main.java

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class main {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws NumberFormatException, IOException {
        Member[] company = new Member[] {
                new Manager("Lernen", "sdaska", 45, 114514000, "0976-725-974", "vuaizeo", "master"),
                new Manager("Macht", "sdgasdxka", 400, 114514000, "0975-625-574", "vuaizeo", "sub-master"),
                new Engineer("Aura", "qweqw", 500, 11451400, "0974-525-474", "Azeryuze"),
                new Engineer("Linie", "asd", 250, 11451400, "0973-425-374", "Eafuazen"),
                new Engineer("Lugner", "qweqwe", 240, 11451400, "0972-325-274", "Baruterie"),
                new Staff("Qual", "sdaqtexka", 300, 1145140, "0971-225-174", "das", 5f),
                new Staff("Draht", "sdashzcxka", 100, 114514, "0970-125-074", "ich", 3f)
        };

        for (Member member : company) {
            System.out.println(member);
            if (member instanceof Staff) {
                System.out.println(((Staff) member).getStaff());
            }
            System.out.println();
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

        strBuild.append(String.format("姓名: %s, 年齡: %d, ", name, age));
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

class Staff extends Member {

    private String title;
    private float workyear;

    public Staff() {
    }

    public Staff(String name) {
        super(name, null, 0, 0, null);
    }

    public Staff(String name, String address) {
        super(name, address, 0, 0, null);
    }

    public Staff(String name, String address, int age) {
        super(name, address, age, 0, null);
    }

    public Staff(String name, String address, int age, int salary) {
        super(name, address, age, salary, null);
    }

    public Staff(String name, String address, int age, int salary, String phone) {
        super(name, address, age, salary, phone);
    }

    public Staff(String name, String address, int age, int salary, String phone, String title) {
        super(name, address, age, salary, phone);
    }

    public Staff(String name, String address, int age, int salary, String phone, String title, float workyear) {
        super(name, address, age, salary, phone);
        setTitle(title);
        setWorkyear(workyear);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getWorkyear() {
        return workyear;
    }

    public void setWorkyear(float workyear) {
        if (workyear >= 0) {
            this.workyear = workyear;
        } else {
            throw new IllegalArgumentException("workyear cannot be negative!");
        }
    }

    public String getStaff() {
        if (workyear < 1) {
            return "新進員工";
        } else if (workyear >= 1 && workyear <= 3) {
            return "副領班";
        } else if (workyear >= 3 && workyear <= 5) {
            return "領班";
        }
        return "組長";
    }

    @Override
    public String toString() {
        String t = String.format("職稱: %s, ", title);
        String f = String.format("年資: %.0f", workyear);
        return super.toString() + t + f;
    }

    @Override
    void showProfile() {
        System.err.println(this);
    }
}