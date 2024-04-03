import java.io.IOException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        System.out.println("請輸入房屋數量: ");
        int number = scan.nextInt();
        house[] houses = new house[number];

        for (int i = 0; i < houses.length; i++) {
            System.out.printf("請問第%d棟房子名稱: ", i + 1);
            String n = scan.next();
            System.out.printf("請問第%d棟房子租金: ", i + 1);
            int r = scan.nextInt();
            houses[i] = new house(n, r);
        }

        int sum = 0;
        double avg = 0;
        for (house house : houses) {
            sum += house.rental;
        }
        avg = (double) sum / houses.length;

        int key = 0;
        do {
            System.out.println("請選擇下列選項: ");
            System.out.println("(1) 列出每一間房屋的名稱及租金");
            System.out.println("(2) 列出價格高於平均的房屋的名稱及租金");
            System.out.println("(3) 列出價格低於平均的房屋的名稱及租金");
            key = scan.nextInt();
            switch (key) {
                case 1:
                    for (int i = 0; i < houses.length; i++) {
                        house house = houses[i];
                        System.out.printf("第%d棟房子%s\n", i + 1, house);
                    }
                    break;
                case 2:
                    for (int i = 0; i < houses.length; i++) {
                        house house = houses[i];
                        if ((double) house.rental > avg) {
                            System.out.println(house);
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < houses.length; i++) {
                        house house = houses[i];
                        if ((double) house.rental < avg) {
                            System.out.println(house);
                        }
                    }
                    break;
                default:
                    System.out.println("請輸入有效的選擇(1,2, 或3)");
                    continue;
            }
        } while (key > 4);
    }
}

class house {
    public String name;
    public int rental;

    public house(String n, int r) {
        name = n;
        rental = r;
    }

    @Override
    public String toString() {
        return String.format("名稱: %s, 租金: %d", name,rental);
    }
}