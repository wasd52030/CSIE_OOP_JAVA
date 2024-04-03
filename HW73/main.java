// file encode utf8 build command -> javac -encoding utf-8 main.java

import java.io.IOException;
import java.util.Scanner;

public class main {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws NumberFormatException, IOException {
        try {
            System.out.print("請輸入有幾個學生: ");
            int number = Integer.valueOf(scan.nextLine());
            var arr = new Student[number];

            for (int i = 0; i < arr.length; i++) {
                var name = getValue(String.class, "姓名");
                var sex = getValue(String.class, "性別");
                var age = getValue(Integer.class, "年齡");
                var department = getValue(String.class, "科系");
                var height = getValue(Double.class, "身高");
                var weight = getValue(Double.class, "體重");

                arr[i] = new Student(name, sex, age, department, height, weight);
            }

            menu(arr);
        } catch (Exception e) {
            System.out.println("輸入有誤，請重新輸入");
            main(args);
        }
    }

    static void menu(Student... arr) {
        System.out.println("(1) 顯示所有學生");
        System.out.println("(2) 查詢單一學生");
        System.out.println("(3) 離開");

        int key = Integer.valueOf(scan.nextLine());
        switch (key) {
            case 1:
                for (Student student : arr) {
                    System.out.println(student);
                }
                break;
            case 2:
                printStudentFromArr(arr);
                break;
            case 3:
                return;
            default:
                break;
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

    static void printStudentFromArr(Student... arr) {
        System.out.print("請輸入Index: ");
        int key = Integer.valueOf(scan.nextLine());

        try {
            var s = arr[key];
            System.out.println(s);
        } catch (Exception e) {
            System.out.println("找不到此學生");
            printStudentFromArr(arr);
        }
    }
}

class Student {
    private String name, sex, department;
    private int age;
    private double height, weight;

    public Student() {
    }

    public Student(String name, String sex, int age, String department, double height, double weight) {
        setName(name);
        setSex(sex);
        setAge(age);
        setDepartment(department);
        setHeight(height);
        setWeight(weight);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        var strBuild = new StringBuilder();

        strBuild.append(String.format("姓名: %s, 性別: %s, 年齡: %d", name, sex, age));
        strBuild.append(String.format("科系: %s, 身高: %.2f, 體重: %.2f", department, height, weight));

        return strBuild.toString();
    }
}