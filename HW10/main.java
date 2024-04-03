import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("請輸入入場成人人數: ");
        String adult = buf.readLine();

        System.out.print("請輸入入場兒童人數: ");
        String children = buf.readLine();

        if (Integer.parseInt(adult) < 1) {
            System.out.println("小孩入場需要大人陪同喔");
        } else if (Integer.parseInt(children) < 1) {
            System.out.printf("此次入場人數: %d個大人\n", Integer.parseInt(adult));
            System.out.printf("門票總金額: %d元\n", Integer.parseInt(adult)*589);      
        } else {
            System.out.printf("此次入場人數: %d個大人\t%d個小孩\n", Integer.parseInt(adult), Integer.parseInt(children));
            System.out.printf("家庭方案優惠門票總金額: %.0f元\n", (Integer.parseInt(adult) * 589 + Integer.parseInt(children) * 369) * 0.8);
        }
    }
}