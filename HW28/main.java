// file encode utf8 build command -> javac -encoding utf-8 main.java

import java.io.IOException;
import java.util.Scanner;

public class main {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int[][] sales = new int[][] { { 33, 32, 56, 45, 33 }, { 77, 33, 68, 45, 23 }, { 43, 55, 43, 67, 65 } };
        int[] prices = new int[5];

        System.out.println("請輸入五個產品個別的單價");
        for (int i = 0; i < prices.length;) {
            System.out.printf("請輸入產品%c的單價: ", 'A' + i);
            int price = Integer.valueOf(scanner.nextLine());
            if (price > 0) {
                prices[i] = price;
                i++;
            } else {
                System.out.println("價格必須大於0！");
            }
        }

        menu(sales, prices);
    }

    static void menu(int[][] sales, int[] price) {
        int key = 0;
        int[] peoples = PeopleSales(sales, price);
        int[] products = ProductSales(sales, price);

        System.out.println("(1) 印出業績總表");
        System.out.println("(2) 每一個銷售員的銷售總金額");
        System.out.println("(3) 每一項產品的銷售總金額。");
        System.out.println("(4) 有最好業績（銷售總金額為最多者）的銷售員。");
        System.out.println("(5) 總銷售金額低於平均的銷售員");
        System.out.println("(6) 離開程式");

        key = Integer.valueOf(scanner.nextLine());

        switch (key) {
            case 1:
                SalesTable(sales, price);
                menu(sales, price);
                break;
            case 2:
                getTotalPersonSales(peoples);
                menu(sales, price);
                break;
            case 3:
                getTotalProductSales(products);
                menu(sales, price);
                break;
            case 4:
                findBestPerson(peoples);
                menu(sales, price);
                break;
            case 5:
                findLowerThanAvgPerson(peoples);
                menu(sales, price);
                break;
            case 6:
                System.exit(0);
                break;
            default:
                System.out.println("沒有此功能，請重新選擇");
                menu(sales, price);
                break;
        }
    }

    static void SalesTable(int[][] sales, int[] price) {
        System.out.println();
        System.out.println("銷售員\t產品A\t產品B\t產品C\t產品D\t產品E");

        StringBuilder strBuild = new StringBuilder();
        for (int i = 0; i < sales.length; i++) {
            strBuild.append(i + 1 + "\t");
            for (int j : sales[i]) {
                strBuild.append(j + "\t");
            }
            strBuild.setLength(strBuild.length() - 1);
            strBuild.append("\n");
        }

        strBuild.append("單價\t");
        for (int i : price) {
            strBuild.append(i + "\t");
        }
        strBuild.setLength(strBuild.length() - 1);

        System.out.println(strBuild.toString() + "\n");
    }

    static int[] PeopleSales(int[][] sales, int[] price) {
        int[] people = new int[sales.length];

        for (int i = 0; i < sales.length; i++) {
            int sum = 0;
            for (int j = 0; j < sales[i].length; j++) {
                int n = sales[i][j];
                sum += n * price[j];
            }
            people[i] = sum;
        }

        return people;
    }

    static int[] ProductSales(int[][] sales, int[] price) {
        int[] product = new int[price.length];

        for (int i = 0; i < sales.length; i++) {
            for (int j = 0; j < sales[i].length; j++) {
                product[j] += sales[i][j] * price[j];
            }
        }

        return product;
    }

    static void getTotalPersonSales(int[] peoples) {
        for (int i = 0; i < peoples.length; i++) {
            System.out.printf("銷售員%d銷售總金額:\t%d元\n", i + 1, peoples[i]);
        }
    }

    static void getTotalProductSales(int[] products) {
        for (int i = 0; i < products.length; i++) {
            System.out.printf("產品%c銷售總額:\t%d元\n", ('A' + i), products[i]);
        }
    }

    static void findBestPerson(int[] peoples) {
        int id = 0, max = peoples[0];
        for (int i = 0; i < peoples.length; i++) {
            if (peoples[i] > max) {
                max = peoples[i];
                id = i;
            }
        }
        System.out.println("業績最好銷售員: " + (id + 1) + "號");
    }

    static void findLowerThanAvgPerson(int[] peoples) {
        int avg = 0;
        StringBuilder strBuild = new StringBuilder();
        for (int people : peoples) {
            avg += people;
        }
        avg /= peoples.length;

        strBuild.append("低於平均的銷售員: ");
        for (int i = 0; i < peoples.length; i++) {
            if (peoples[i] < avg) {
                strBuild.append((i + 1) + "號" + " ");
            }
        }
        strBuild.setLength(strBuild.length() - 1);
        System.out.println(strBuild.toString());
    }
}