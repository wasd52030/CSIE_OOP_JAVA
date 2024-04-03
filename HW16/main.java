import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        int total = -1;
        do {
            System.out.print("請輸入貸款金額(大於等於0): ");
            total = Integer.parseInt(buf.readLine());
            if (total < 0) {
                System.out.println("貸款金額不得小於0，請重新輸入");
            }
        } while (total < 0);

        int year = -1;
        do {
            System.out.print("請輸入貸款年數(至少1年): ");
            year = Integer.parseInt(buf.readLine());
            if (total < 0) {
                System.out.println("貸款年數不得小於1年");
            }
        } while (year < 1);

        int x = total / year;
        for (int i = 1; i <= year; i++) {
            double finalMoney = x + (total * (1.5 / 100));
            System.out.printf("%d年後需還款本加利%.2f元(本金為%d元、利息為%.2f元)\n", i, finalMoney, x, total* (1.5/100));        
            total -= x;
        }
    }
}