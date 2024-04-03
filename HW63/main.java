// file encode utf8 build command -> javac -encoding utf-8 main.java

import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.stream.Stream;

public class main {

    static final Scanner scan = new Scanner(System.in);
    static final SimpleDateFormat ft = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");

    public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException,
            IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        System.out.println("*****薪資計算系統*****");
        System.out.print("請輸入有幾位員工: ");
        int n = Integer.valueOf(scan.nextLine());
        Employee[] employees = new Employee[n];

        setArr(employees);

        System.out.println("*****本月員工薪資資料如下*****");
        Stream.of(employees).forEach(e -> System.err.println(e));
        System.out.printf("薪資總支出: %d", Stream.of(employees).map(i -> i.salary()).reduce(0, Integer::sum));
    }

    static <T extends Employee> void setArr(T[] arr) throws NoSuchMethodException, SecurityException,
            InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

        boolean flag = true;

        for (int i = 0; i < arr.length; i++) {
            System.out.print("請輸入員工姓名: ");
            String name = scan.nextLine();

            String sex = "";
            while (flag) {
                if (sex.equals("M") || sex.equals("F")) {
                    flag = false;
                } else {
                    System.out.print("請輸入性別: ");
                    sex = scan.nextLine();
                }
            }
            flag = true;

            System.out.print("請輸入犯錯次數: ");
            int mistake = Integer.valueOf(scan.nextLine());

            System.out.println("(1) 一般員工");
            System.out.println("(2) 一級主管");
            System.out.println("(3) 二級主管");
            System.out.print("請輸入職位: ");
            int type = Integer.valueOf(scan.nextLine());
            Class<T> jobType = null;
            while (flag) {
                switch (type) {
                    case 1:
                        flag = false;
                        jobType = (Class<T>) BasicEmployee.class;
                        break;
                    case 2:
                        flag = false;
                        jobType = (Class<T>) Managers.class;
                        break;
                    case 3:
                        flag = false;
                        jobType = (Class<T>) Supervisors.class;
                        break;
                    default:
                        System.out.println("未定義職位");
                        break;
                }
            }
            flag = true;

            var c = jobType.getConstructor(String.class, String.class, int.class);
            arr[i] = (T) c.newInstance(name, sex, mistake);
        }
    }
}

class BasicEmployee extends Employee {

    public BasicEmployee(String name, String sex, int mistake) {
        super(name, sex, mistake);
        setMistakeCount(getMistakeCount() + mistake);
    }

    private static int mistakeCount;

    public static int getMistakeCount() {
        return mistakeCount;
    }

    public static void setMistakeCount(int mc) {
        mistakeCount = mc;
    }

    @Override
    int salary() {
        return 32000 - (getMistake() * 300);
    }

    @Override
    public String toString() {
        return super.toString() + String.format("薪資所得: %d", salary());
    }
}

class Managers extends Employee {

    public Managers(String name, String sex, int mistake) {
        super(name, sex, mistake);
        setMistakeCount(getMistakeCount() + mistake);
    }

    private static int mistakeCount;

    public static int getMistakeCount() {
        return mistakeCount;
    }

    public static void setMistakeCount(int mc) {
        mistakeCount = mc;
    }

    @Override
    int salary() {
        var f = 37000 + 1800 + 3000 - (getMistake() * 1000);

        if (BasicEmployee.getMistakeCount() > 10) {
            f -= 2000;
        }

        return f;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("薪資所得: %d", salary());
    }

}

class Supervisors extends Employee {

    public Supervisors(String name, String sex, int mistake) {
        super(name, sex, 0);
    }

    @Override
    int salary() {
        var f = 50000 + 5000;

        if (BasicEmployee.getMistakeCount() + Managers.getMistakeCount() > 20) {
            f -= 5000;
        }

        return f;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("薪資所得: %d", salary());
    }
}

abstract class Employee {
    private String name, sex;
    private int mistake;

    public Employee(String name, String sex, int mistake) {
        setName(name);
        setSex(sex);
        setMistake(mistake);
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

    public int getMistake() {
        return mistake;
    }

    public void setMistake(int mistake) {
        this.mistake = mistake;
    }

    @Override
    public String toString() {
        var strBuild = new StringBuilder();

        strBuild.append(String.format("姓名: %s, 性別:%s, ", name, sex));
        strBuild.append(String.format("犯錯次數 %d, ", mistake));

        return strBuild.toString();
    }

    abstract int salary();
}