// file encode utf8 build command -> javac -encoding utf-8 main.java

import java.io.IOException;
import java.util.Scanner;

public class main {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        System.out.print("請輸入有幾位業務員: ");
        int salesNumber = Integer.valueOf(scanner.nextLine());

        int[][] sales = new int[salesNumber][5];
        String[] saleNames = new String[salesNumber];
        int[] prices = new int[5];

        getProductPrice(prices);
        getSalesPerformance(sales, saleNames);
        menu(sales, saleNames, prices);
    }

    static int checkSalesPerformance(String prompt) {
        int price = 0;

        do {
            System.out.print(prompt);
            price = Integer.valueOf(scanner.nextLine());
            if (price < 0 || price > 500) {
                System.out.println("業績必須介於0~500之間！");
            }
        } while (price < 0 || price > 500);

        return price;
    }

    static void getProductPrice(int[] prices) {
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
    }

    static void getSalesPerformance(int[][] sales, String[] saleNames) {
        for (int i = 0; i < sales.length; i++) {
            System.out.printf("請輸入第%d位銷售員的姓名: ", i + 1);
            saleNames[i] = scanner.nextLine();
            for (int j = 0; j < sales[i].length; j++) {
                sales[i][j] = checkSalesPerformance(String.format("請輸入%s在產品%c的業績: ", saleNames[i], ('A' + j)));
            }
        }
    }

    static void menu(int[][] sales, String[] saleNames, int[] price) {
        int key = 0;
        // 各銷售員銷售額
        int[] peoples = PeopleSales(sales, price);
        // 各產品銷售額
        int[] products = ProductSales(sales, price);

        System.out.println("(1) 印出業績總表");
        System.out.println("(2) 每一個銷售員的銷售總金額");
        System.out.println("(3) 每一項產品的銷售總金額");
        System.out.println("(4) 有最好業績（銷售總金額為最多者）的銷售員");
        System.out.println("(5) 總銷售金額低於平均的銷售員");
        System.out.println("(6) 修改銷售員業績");
        System.out.println("(7) 產品業績總圖");
        System.out.println("(8) 離開程式");

        key = Integer.valueOf(scanner.nextLine());

        switch (key) {
            case 1:
                SalesTable(sales, saleNames, price);
                menu(sales, saleNames, price);
                break;
            case 2:
                getTotalPersonSales(peoples, saleNames);
                menu(sales, saleNames, price);
                break;
            case 3:
                getTotalProductSales(products);
                menu(sales, saleNames, price);
                break;
            case 4:
                findBestPerson(peoples, saleNames);
                menu(sales, saleNames, price);
                break;
            case 5:
                findLowerThanAvgPerson(peoples, saleNames);
                menu(sales, saleNames, price);
                break;
            case 6:
                updateSalesPerformance(sales, saleNames, price);
                menu(sales, saleNames, price);
                break;
            case 7:
                productPerformanceGraph(products);
                menu(sales, saleNames, price);
                break;
            case 8:
                System.exit(0);
                break;
            default:
                System.out.println("沒有此功能，請重新選擇");
                menu(sales, saleNames, price);
                break;
        }
    }

    static void SalesTable(int[][] sales, String[] saleNames, int[] price) {
        System.out.println();
        System.out.println("銷售員\t\t產品A\t產品B\t產品C\t產品D\t產品E");

        StringBuilder strBuild = new StringBuilder();
        for (int i = 0; i < sales.length; i++) {
            strBuild.append(String.format("編號: %d 姓名: %s\t", (i + 1), saleNames[i]));
            for (int j : sales[i]) {
                strBuild.append(j + "\t");
            }
            strBuild.setLength(strBuild.length() - 1);
            strBuild.append("\n");
        }

        strBuild.append("單價\t\t");
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

    static void getTotalPersonSales(int[] peoples, String[] saleNames) {
        for (int i = 0; i < peoples.length; i++) {
            System.out.printf("銷售員[編號: %d,姓名: %s]銷售總金額:\t%d元\n", (i + 1), saleNames[i], peoples[i]);
        }
    }

    static void getTotalProductSales(int[] products) {
        for (int i = 0; i < products.length; i++) {
            System.out.printf("產品%c銷售總額:\t%d元\n", ('A' + i), products[i]);
        }
    }

    static void findBestPerson(int[] peoples, String[] saleNames) {
        int id = 0, max = peoples[0];
        for (int i = 0; i < peoples.length; i++) {
            if (peoples[i] > max) {
                max = peoples[i];
                id = i;
            }
        }
        System.out.printf("業績最好銷售員: [編號: %d,姓名: %s]\n", (id + 1), saleNames[id]);
    }

    static void findLowerThanAvgPerson(int[] peoples, String[] saleNames) {
        int avg = 0;
        StringBuilder strBuild = new StringBuilder();
        for (int people : peoples) {
            avg += people;
        }
        avg /= peoples.length;

        strBuild.append("低於平均的銷售員: ");
        for (int i = 0; i < peoples.length; i++) {
            if (peoples[i] < avg) {
                strBuild.append(String.format("[編號: %d,姓名: %s]", (i + 1), saleNames[i]));
            }
        }

        System.out.println(strBuild.toString());
    }

    static void updateSalesPerformance(int[][] sales, String[] saleNames, int[] products) {
        SalesTable(sales, saleNames, products);
        System.out.printf("請輸入欲修改的銷售員編號: ");
        int targetId = Integer.valueOf(scanner.nextLine());
        for (int i = 0; i < sales.length; i++) {
            for (int j = 0; j < sales[i].length; j++) {
                if (i == (targetId - 1)) {
                    System.out.printf("請輸入%s在產品%c的業績: ", saleNames[i], ('A' + j));
                    sales[i][j] = Integer.valueOf(scanner.nextLine());
                } else {
                    continue;
                }
            }
        }
    }

    static void productPerformanceGraph(int[] products) {
        int total = 0;
        for (int product : products) {
            total += product;
        }

        System.out.println("每一產品佔總銷售業績百分比(一個*為1%)");
        for (int i = 0; i < products.length; i++) {
            int percent = (int) Math.round((products[i] / (float) total) * 100);
            System.out.printf("產品 %c: ", 'A' + i);
            showLine(percent);
        }
    }

    static void showLine(int len) {
        for (int i = 0; i < len; i++) {
            System.out.print('*');
        }
        System.out.println();
    }
}