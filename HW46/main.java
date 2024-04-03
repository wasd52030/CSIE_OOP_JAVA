// file encode utf8 build command -> javac -encoding utf-8 main.java

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;
import java.util.stream.Collectors;

public class main {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        var orders = new ArrayList<Order>();
        menu(orders);
    }

    static void menu(ArrayList<Order> order) {
        System.out.println("請選擇");
        System.out.println("1. 新增訂單");
        System.out.println("2. 總銷售表");
        System.out.println("3. 離開系統");
        int key = Integer.valueOf(scan.nextLine());

        switch (key) {
            case 1:
                add(order);
                menu(order);
                break;
            case 2:
                salesTable(order);
                menu(order);
                break;
            case 3:
                return;
            default:
                System.out.println("未定義選項，請重新選擇");
                menu(order);
                break;
        }
    }

    static void add(ArrayList<Order> order) {
        System.out.println("A.汽水");
        System.out.println("B.科學麵");
        System.out.println("C.麵包");
        System.out.println("D.蘋果");
        System.out.println("E.口香糖");
        System.out.println("F.冰棒");
        System.out.println("G.泡麵");
        System.out.println("H.米");
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

    static void salesTable(ArrayList<Order> order) {
        var sales = order.stream().collect(Collectors.groupingBy(k -> k.getItemId()));
        System.out.println("商品代號\t商品數量");
        for (var s : sales.entrySet()) {
            var sum = s.getValue().stream()
                    .map(i -> i.getNumber())
                    .reduce(0, (past, curr) -> past + curr);
            System.out.printf("%s\t\t%d\n", s.getKey(), sum);
        }
    }
}

class Order {
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
