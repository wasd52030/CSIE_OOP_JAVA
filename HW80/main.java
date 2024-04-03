// file encode utf8 build command -> javac -encoding utf-8 main.java

import java.io.IOException;
import java.util.Scanner;

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

        Member[] company2 = new Member[4];

        for (int i = 0; i < company2.length; i++) {
            if (i < 2) {
                company2[i] = getMember(Manager.class);
            } else {
                company2[i] = getMember(Engineer.class);
            }
        }

        for (Member member : company2) {
            System.out.println(member);
            if (member instanceof Staff) {
                System.out.println(((Staff) member).getStaff());
            }
            System.out.println();
        }
    }

    static <T> T getMember(Class<T> job) {
        Member m = null;

        var name = getValue(String.class, "姓名");
        var address = getValue(String.class, "地址");
        var age = getValue(Integer.class, "年齡");
        var salary = getValue(Double.class, "薪水");
        var phone = getValue(String.class, "電話");

        if (job == Manager.class) {
            var department = getValue(String.class, "部門");
            var officecall = getValue(String.class, "職位");
            m = new Manager(name, address, age, salary, phone, department, officecall);
        } else if (job == Engineer.class) {
            var expertise = getValue(String.class, "專業技能");
            m = new Engineer(name, address, age, salary, phone, expertise);
        }

        return (T) m;
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