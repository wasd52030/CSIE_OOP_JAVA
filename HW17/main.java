import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        int total = -1;
        do {
            System.out.print("請輸入初始投資金額(大於等於100000): ");
            total = Integer.parseInt(buf.readLine());
            if (total < 100000) {
                System.out.println("初始投資金額不得小於0，請重新輸入");
            }
        } while (total < 100000);

        // 可購股數
        int stock = total / 100;
        // 退還金額
        float back = total % 100;
        System.out.printf("退還%.1f元\n",back);

        double interest = stock * 1.5, totalInterest = 0;
        for (int i = 1; i <= 120; i++) {
            int annulStock = 25 * (stock / 1000);
            System.out.printf("第%d個月，持有%d股(%d張)，配息: %.1f元，配股: %d股\n", i, stock, stock / 1000, interest, annulStock);       
            if (stock >= 1000) {
                stock += annulStock;
                interest = stock * 1.5;
                totalInterest += interest;
            }
        }
        System.out.printf("10年後持有的總股數為%d股，配息總額為%.1f元\n", stock, totalInterest);
        System.out.printf("總價值:%.1f元\n", 100 * stock + totalInterest);
    }
}