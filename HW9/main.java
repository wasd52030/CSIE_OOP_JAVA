import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {
    public static void main(String[] args) throws IOException {
        final double AU = 149597871;

        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("請輸入金星到太陽的天文單位: ");
        String Venus = buf.readLine();

        System.out.print("請輸入火星到太陽的天文單位: ");
        String Mars = buf.readLine();

        System.out.print("請輸入海王星到太陽的天文單位: ");
        String Neptune = buf.readLine();

        System.out.printf("金星到太陽的距離為: %.2f公里\n",Double.parseDouble(Venus) * AU);
        System.out.printf("火星到太陽的距離為: %.2f公里\n",Double.parseDouble(Mars) * AU);
        System.out.printf("海王星到太陽的距離為: %.2f公里\n",Double.parseDouble(Neptune) * AU);
    }
}