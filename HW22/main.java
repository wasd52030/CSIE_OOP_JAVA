// file encode utf8 build command -> javac -encoding utf-8 main.java

import java.io.IOException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        System.out.println("請輸入房屋數量: ");
        int number = scan.nextInt();
        int[][] houses = new int[number][];
        Double[] avgs = new Double[number];
        double totalAvg = 0;

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

        int temp = 0;
        for (int i = 0; i < avgs.length; i++) {
            temp += avgs[i];
        }
        totalAvg = (double) temp / avgs.length;

        int key = 0;
        do {
            System.out.println("請選擇下列選項: ");
            System.out.println("(1) 列出每一間房屋的編號、過去5年的租金、租金平均值");
            System.out.println("(2) 查詢某一間房間的所有租金紀錄");
            System.out.println("(3) 列出價格高於平均的房屋的名稱及租金");
            System.out.println("(4) 列出價格低於平均的房屋的名稱及租金");
            System.out.println("(5) 退出");
            key = scan.nextInt();
            switch (key) {
                case 1:
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

                        System.out.printf("房屋編號: %d,租金紀錄: %s, 租金平均值: %.1f\n", i + 1, s, avgs[i]);
                    }
                    break;
                case 2:
                    System.out.println("請輸入選項: ");
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

                            System.out.printf("房屋編號: %d,租金紀錄: %s, 租金平均值: %.1f\n", i + 1, s, avgs[i]);
                        }
                    }
                    break;
                case 3:
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

                            System.out.printf("房屋編號: %d,租金紀錄: %s, 租金平均值: %.1f\n", i + 1, s, avgs[i]);
                        }
                    }
                    break;
                case 4:
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

                            System.out.printf("房屋編號: %d,租金紀錄: %s, 租金平均值: %.1f\n", i + 1, s, avgs[i]);
                        }
                    }
                    break;
                case 5:
                    break;
                default:
                    System.out.println("請輸入有效的選擇(1,2,3,4,5)");
                    continue;
            }
        } while (key > 5);
    }
}