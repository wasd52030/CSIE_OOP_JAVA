import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("請輸家庭中老年人人數: ");
        String Old = buf.readLine();
        int old = Integer.parseInt(Old);

        System.out.print("請輸家庭中青年人人數: ");
        String Young = buf.readLine();
        int young = Integer.parseInt(Young);

        System.out.print("請輸家庭年收入(元): ");
        String Money = buf.readLine();
        float money = Float.parseFloat(Money);

        // 稅額級距
        float taxP = 0;
        if (money > 2000000) {
            taxP = 30 / 100f;
        } else if (money > 1500000 && money <= 2000000) {
            taxP = 20 / 100f;
        } else if (money > 1000000 && money <= 1500000) {
            taxP = 15 / 100f;
        } else {
            taxP = 10 / 100f;
        }

        // 免稅門檻
        float noTaxGate = money / (young + old);
        if (noTaxGate < 15000) {
            taxP = 0;
        }

        //老人減免
        taxP -= old * (4 / 100f);

        System.out.printf("家庭人數組成: 老年人%d人，青年人%d人，總人數%d人\n", old, young, old + young);
        System.out.printf("稅率: %.0f%%\n", (taxP*100));
        System.out.printf("所得稅總額: %.1f\n", (money * taxP));
    }
}