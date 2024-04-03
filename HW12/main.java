import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("請輸房間人數: ");
        String People = buf.readLine();
        int people = Integer.parseInt(People);

        System.out.print("請輸房間自然光線強度: ");
        String Lux = buf.readLine();
        int lux = Integer.parseInt(Lux);

        String quality1 = "", quality2 = "", action = "";
        if (lux > 700) {
            quality1 = "佳";
            quality2 = "足夠";
        } else if (lux > 300 && lux <= 700) {
            quality1 = "普通";
            quality2 = "足夠";
        } else if (lux < 300) {
            quality1 = "不佳";
            quality2 = "不足";
        }

        if (people > 0 && quality2.equals("足夠")) {
            action = "關閉照明";
        } else if (people > 0 && quality2.equals("不足")) {
            action = "打開照明";
        } else if (people < 0 && quality2.equals("足夠")) {
            action = "關閉照明";
        } else if (people < 0 && quality2.equals("不足")) {
            action = "打開照明";
        }

        System.out.println("[房間]");
        System.out.printf("人數:%d人\n", people);
        System.out.printf("光線強度: %dLux(%s)\n", lux,quality1);
        System.out.printf("光線品質: %s\n", quality2);
        System.out.printf("動作: %s\n", action);
    }
}