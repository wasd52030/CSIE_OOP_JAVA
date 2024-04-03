import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("請輸入購物預算: ");
        int number = Integer.parseInt(buf.readLine());
        int total = 0;
        char key = 'Y';

        while (key == 'Y') {
            System.out.println("1.沙發：7,000 元/個");
            System.out.println("2.椅子：499 元/個");
            System.out.println("3.桌子：759 元/個");
            System.out.println("4.玻璃杯：58 元/個");

            System.out.print("請選擇要買的物品: ");
            char item = buf.readLine().charAt(0);

            System.out.print("請選擇要買的數量: ");
            int itemNumber = Integer.parseInt(buf.readLine());

            if (itemNumber < 1) {
                System.out.println("數量不得小於1，請重新輸入");
                continue;
            }

            switch (item) {
                case '1':
                    total += 7000 * itemNumber;
                    break;
                case '2':
                    total += 499 * itemNumber;
                    break;
                case '3':
                    total += 759 * itemNumber;
                    break;
                case '4':
                    total += 58 * itemNumber;
                    break;
                default:
                    System.out.println("查無此商品");
                    break;
            }

            System.out.print("還需要購買物品嗎?");
            key = buf.readLine().charAt(0);
            System.out.println(key);
        }
        
        System.out.printf("預算%d元\n", number);
        System.out.printf("購物%d元\n", total);
        if (total > number) {
            System.out.printf("超出預算%d元\n", total - number);
        } else {
            System.out.printf("剩下預算%d元\n", number - total);
        }
    }
}