// file encode utf8 build command -> javac -encoding utf-8 main.java

import java.io.IOException;
import java.util.Scanner;

public class main {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        drink sportDrink = new drink("運動飲料", 25, (int) (Math.random() * 10) + 1);
        drink energyDrink = new drink("能量飲", 80, (int) (Math.random() * 10) + 1);
        drink soda = new drink("汽水", 35, (int) (Math.random() * 10) + 1);
        drink peanutMilk = new drink("花生牛奶", 50, (int) (Math.random() * 10) + 1);

        drink[] bucket = new drink[50];
        int bucketCount = 0;

        System.out.print("請輸入持有金額: ");
        int money = Integer.valueOf(scanner.nextLine());

        String key = "";
        while (!key.equals("N")) {
            System.out.println("(1) " + sportDrink);
            System.out.println("(2) " + energyDrink);
            System.out.println("(3) " + soda);
            System.out.println("(4) " + peanutMilk);
            System.out.print("請選擇要買的類型: ");
            int type = Integer.valueOf(scanner.nextLine());
            System.out.println("請輸入數量");
            int ds = Integer.valueOf(scanner.nextLine());
            drink drink = null;

            switch (type) {
                case 1:
                    drink = getProduct(sportDrink, ds);
                    if (drink != null) {
                        bucket[bucketCount] = drink;

                        sportDrink.setCount(sportDrink.getCount() - drink.getCount());
                        bucketCount++;
                    }
                    break;
                case 2:
                    drink = getProduct(energyDrink, ds);
                    if (drink != null) {
                        bucket[bucketCount] = drink;

                        energyDrink.setCount(energyDrink.getCount() - drink.getCount());
                        bucketCount++;
                    }
                    break;
                case 3:
                    drink = getProduct(soda, ds);
                    if (drink != null) {
                        bucket[bucketCount] = drink;

                        soda.setCount(soda.getCount() - drink.getCount());
                        bucketCount++;
                    }
                    break;
                case 4:
                    drink = getProduct(peanutMilk, ds);
                    if (drink != null) {
                        bucket[bucketCount] = drink;

                        peanutMilk.setCount(peanutMilk.getCount() - drink.getCount());
                        bucketCount++;
                    }
                    break;
                default:
                    break;
            }

            System.out.println("是否還要繼續買(不要請輸入N)?");
            key = scanner.nextLine();
        }

        System.out.println();
        System.out.println("---帳單---");
        int total = getTotal(bucket);
        System.out.println("總共" + total + "元");
        System.out.println("收您" + money + "元");
        System.out.println(trade(total, money));
    }

    static drink getProduct(drink drink, int count) {
        String key = "";

        if (drink.getCount() < 1) {
            System.out.println("已售完！");
            return null;
        } else if (count > drink.getCount()) {
            System.out.printf(
                    "目前僅能供應%d瓶，請問能接受只買%d瓶嗎(不要請輸入N)？\n",
                    drink.getCount(),
                    drink.getCount());
            key = scanner.nextLine();
            if (!key.equals("N")) {
                return new drink(drink.getName(), drink.getPrice(), drink.getCount());
            } else {
                return null;
            }
        }

        return new drink(drink.getName(), drink.getPrice(), count);
    }

    static int getTotal(drink[] bucket) {
        int sum = 0;
        for (drink drink : bucket) {
            if (drink == null) {
                break;
            }

            System.out.println(drink);
            sum += drink.getPrice() * drink.getCount();
        }

        return sum;
    }

    static String trade(int total, int money) {
        int result = money - total;
        System.out.println("需要找您" + result + "元");
        String msg = "";
        StringBuilder strBuild = new StringBuilder(msg);

        if (result < 0) {
            return "不夠錢";
        } else if (result == 0) {
            return "完全付清";
        } else {
            int[] u = new int[] { 1000, 500, 100, 50, 10, 5, 1 };
            strBuild.append("找您");
            for (int i = 0; i < u.length; i++) {
                int count = result / u[i];
                if (count > 0) {
                    strBuild.append(count);
                    if (count >= 100) {
                        strBuild.append("張");
                    } else {
                        strBuild.append("枚");
                    }
                    strBuild.append(u[i]);
                    strBuild.append("元");
                    strBuild.append("，");
                }
                result %= u[i];
            }
            strBuild.setLength(strBuild.length() - 1);
        }

        return strBuild.toString();

    }
}

class drink {
    private String name;
    private int price, count;

    public drink(String name, int price, int count) {
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int c) {
        count = c;
    }

    @Override
    public String toString() {
        return String.format("%s, 價格: %d, 數量: %d", name, price, count);
    }
}