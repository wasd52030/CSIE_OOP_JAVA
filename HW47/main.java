// file encode utf8 build command -> javac -encoding utf-8 main.java

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class main {
    private static final Scanner scan = new Scanner(System.in);
    private static Map<String, Integer> sales = Order.itemMap.entrySet()
            .stream()
            .collect(Collectors.toMap(k -> k.getKey(), v -> 0));

    public static void main(String[] args) throws IOException {
        var orders = new ArrayList<Order>();
        menu(orders);
    }

    static void menu(ArrayList<Order> order) {
        System.out.println("請選擇");
        System.out.println("1. 新增訂單");
        System.out.println("2. 修改訂單");
        System.out.println("3. 所有訂單");
        System.out.println("4. 總銷售表");
        System.out.println("5. 銷售人氣圖");
        System.out.println("6. 離開系統");
        int key = Integer.valueOf(scan.nextLine());

        switch (key) {
            case 1:
                add(order);
                menu(order);
                break;
            case 2:
                System.out.println("請輸入要修改的訂單編號");
                key = Integer.valueOf(scan.nextLine());
                order = update(order, key);
                menu(order);
                break;
            case 3:
                getOrderList(order);
                menu(order);
                break;
            case 4:
                salesTable(order);
                menu(order);
                break;
            case 5:
                salesPopularityGraph(order);
                menu(order);
                break;
            case 6:
                return;
            default:
                System.out.println("未定義選項，請重新選擇");
                menu(order);
                break;
        }
    }

    static void add(ArrayList<Order> order) {
        for (var i : Order.itemMap.entrySet()) {
            System.out.printf("%s.%s\n", i.getKey(), i.getValue());
        }
        System.out.print("請選擇要買的商品: ");
        String itemid = scan.nextLine();

        System.out.print("請輸入數量: ");
        int n = Integer.valueOf(scan.nextLine());

        if (order.size() == 0) {
            order.add(new Order(1, itemid, n));
        } else {
            int id = order.stream().max(Comparator.comparing(Order::getId)).get().getId();
            order.add(new Order(id + 1, itemid, n));
        }
    }

    static ArrayList<Order> update(ArrayList<Order> order, int id) {

        if (order.stream().filter(i -> i.getId() == id).count() < 1) {
            System.out.println("找不到這筆訂單");
            return order;
        }

        for (var i : Order.itemMap.entrySet()) {
            System.out.printf("%s.%s\n", i.getKey(), i.getValue());
        }
        System.out.print("請選擇要買的商品: ");
        String itemid = scan.nextLine();

        System.out.print("請輸入數量: ");
        int n = Integer.valueOf(scan.nextLine());

        return order.stream().map(p -> {
            if (p.getId() == id) {
                return new Order(id, itemid, n);
            }
            return p;
        }).collect(Collectors.toCollection(ArrayList::new));

    }

    static void getOrderList(ArrayList<Order> orders) {
        orders.forEach(i -> System.out.println(i));
    }

    static void salesTable(ArrayList<Order> order) {
        order.stream()
                .collect(Collectors.groupingBy(k -> k.getItemId()))
                .forEach((itemid, orders) -> {
                    sales.merge(
                            itemid,
                            orders.stream()
                                    .mapToInt(Order::getNumber)
                                    .sum(),
                            Integer::sum);
                });

        System.out.println("商品代號\t商品數量");
        sales.forEach((itemId, sum) -> System.out.printf("%s\t\t%d\n", itemId, sum));
    }

    static void salesPopularityGraph(ArrayList<Order> orders) {
        var total = orders.stream().mapToInt(Order::getNumber).sum();

        orders.stream()
                .collect(Collectors.groupingBy(Order::getItemId))
                .forEach((itemId, itemList) -> {
                    sales.merge(
                            itemId,
                            itemList.stream()
                                    .mapToInt(Order::getNumber)
                                    .sum(),
                            Integer::sum);
                });

        System.out.println("------------- [銷售人氣圖] -------------");
        sales.forEach((itemId, saleTotal) -> {
            int percent = (int) Math.round((saleTotal / (float) total) * 100);
            System.out.printf("%s.%s:%4s\n", itemId, Order.itemMap.get(itemId), "*".repeat(percent));
        });
    }
}

class Order {
    public static final HashMap<String, String> itemMap = new HashMap<>() {
        {
            put("A", "汽水");
            put("B", "科學麵");
            put("C", "麵包");
            put("D", "蘋果");
            put("E", "口香糖");
            put("F", "冰棒");
            put("G", "泡麵");
            put("H", "米");
        }
    };

    private static final Scanner scan = new Scanner(System.in);

    private int id, number;
    private String itemId;
    private final Date buytime = new Date();
    private SimpleDateFormat ft = new SimpleDateFormat("YYYY/MM/dd hh:mm:ss");

    public Order() {
    };

    public Order(int id, String itemid, int number) {
        setId(id);
        setItemId(itemid);
        setNumber(number);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        char i = itemId.charAt(0);
        while (!(i >= 'A' && i <= 'H')) {
            System.out.println("商品代號只有A-H！");
            System.out.print("請重新輸入: ");
            itemId = scan.nextLine();
            i = itemId.charAt(0);
        }
        this.itemId = itemId;
    }

    public void setNumber(int number) {
        while (!(number >= 1 && number <= 1000)) {
            System.out.println("數量必介於1-1000！");
            System.out.print("請重新輸入: ");
            number = Integer.valueOf(scan.nextLine());
        }
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public Date getBuytime() {
        return buytime;
    }

    @Override
    public String toString() {
        return String.format("id: %d,itemid: %s,number: %d,date: %s", id, itemId, number, ft.format(buytime));
    }
}
