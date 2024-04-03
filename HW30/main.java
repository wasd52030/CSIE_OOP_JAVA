// file encode utf8 build command -> javac -encoding utf-8 main.java

import java.io.IOException;
import java.util.Scanner;

public class main {
    public static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        System.out.println("請輸入房屋數量: ");
        int number = scan.nextInt();
        int[][] houses = new int[number][];

        double[] avgs = new double[number];
        setHouseData(houses, avgs);

        double totalAvg = getTotalAvg(avgs);

        menu(houses, avgs, totalAvg);
    }

    static void menu(int[][] houses, double[] avgs, double totalAvg) {
        int key = 0;
        String result = "";
        System.out.println("請選擇下列選項: ");
        System.out.println("(1) 列出每一間房屋的編號、過去5年的租金、租金平均值");
        System.out.println("(2) 查詢某一間房間的所有租金紀錄");
        System.out.println("(3) 列出價格高於平均的房屋的名稱及租金");
        System.out.println("(4) 列出價格低於平均的房屋的名稱及租金");
        System.out.println("(5) 退出");
        key = scan.nextInt();
        switch (key) {
            case 1:
                result = getHouseTable(houses, avgs);
                System.out.println(result);

                menu(houses, avgs, totalAvg);
                break;
            case 2:
                result = findHouseById(houses, avgs);
                System.out.println(result);

                menu(houses, avgs, totalAvg);
                break;
            case 3:
                result = findHouseHigherThanAvg(houses, avgs, totalAvg);
                System.out.println(result);

                menu(houses, avgs, totalAvg);
                break;
            case 4:
                result = findHouseLowerThanAvg(houses, avgs, totalAvg);
                System.out.println(result);

                menu(houses, avgs, totalAvg);
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("請輸入有效的選擇(1,2,3,4,5)");
                menu(houses, avgs, totalAvg);
        }
    }

    static void setHouseData(int[][] houses, double[] avgs) {
        for (int i = 0; i < houses.length; i++) {
            houses[i] = new int[5];
            int rSum = 0;
            for (int j = 0; j < houses[i].length; j++) {
                int r = (int) (Math.random() * (30000 - 10000 + 1)) + 10000;
                houses[i][j] = r;
                rSum += r;
            }
            avgs[i] = (double) rSum / 5;
        }
    }

    static double getTotalAvg(double[] avgs) {
        int temp = 0;
        for (int i = 0; i < avgs.length; i++) {
            temp += avgs[i];
        }

        return (double) temp / avgs.length;
    }

    static String getHouseTable(int[][] houses, double[] avgs) {
        String result = "";
        for (int i = 0; i < houses.length; i++) {
            var s = "[";
            for (int j = 0; j < houses[i].length; j++) {
                if (j == houses[i].length - 1) {
                    s += houses[i][j];
                } else {
                    s += houses[i][j] + ", ";
                }
            }
            s += "]";

            result += String.format("房屋編號: %d,租金紀錄: %s, 租金平均值: %.1f\n", i + 1, s, avgs[i]);
        }

        return result;
    }

    static String findHouseById(int[][] houses, double[] avgs) {
        int key = 0;
        String result = "";

        System.out.println("請輸入房屋編號: ");
        key = scan.nextInt();
        for (int i = 0; i < houses.length; i++) {
            if ((key - 1) == i) {
                var s = "[";
                for (int j = 0; j < houses[i].length; j++) {
                    if (j == houses[i].length - 1) {
                        s += houses[i][j];
                    } else {
                        s += houses[i][j] + ", ";
                    }
                }
                s += "]";

                result += String.format("房屋編號: %d,租金紀錄: %s, 租金平均值: %.1f\n", i + 1, s, avgs[i]);
            }
        }

        return result;
    }

    static String findHouseHigherThanAvg(int[][] houses, double[] avgs, double totalAvg) {
        String result = "";

        for (int i = 0; i < houses.length; i++) {
            if (avgs[i] > totalAvg) {
                var s = "[";
                for (int j = 0; j < houses[i].length; j++) {
                    if (j == houses[i].length - 1) {
                        s += houses[i][j];
                    } else {
                        s += houses[i][j] + ", ";
                    }
                }
                s += "]";

                result += String.format("房屋編號: %d,租金紀錄: %s, 租金平均值: %.1f\n", i + 1, s, avgs[i]);
            }
        }

        return result;
    }

    static String findHouseLowerThanAvg(int[][] houses, double[] avgs, double totalAvg) {
        String result = "";

        for (int i = 0; i < houses.length; i++) {
            if (avgs[i] < totalAvg) {
                var s = "[";
                for (int j = 0; j < houses[i].length; j++) {
                    if (j == houses[i].length - 1) {
                        s += houses[i][j];
                    } else {
                        s += houses[i][j] + ", ";
                    }
                }
                s += "]";

                result += String.format("房屋編號: %d,租金紀錄: %s, 租金平均值: %.1f\n", i + 1, s, avgs[i]);
            }
        }

        return result;
    }
}