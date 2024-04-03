import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("請輸入學生的姓名: ");
        String name = buf.readLine();

        System.out.print("請輸入學生的座號: ");
        int number = Integer.parseInt(buf.readLine());

        if (number < 1) {
            System.out.print("輸入資料有誤");
        } else if (number > 60) {
            System.out.printf("%s同學不在3年A班中\n",name);
        } else {
            switch (number % 3) {
                case 0:
                    System.out.printf("%s同學在第三組", name);
                    break;
                case 1:
                    System.out.printf("%s同學在第一組", name);
                    break;
                case 2:
                    System.out.printf("%s同學在第二組", name);
                    break;
                default:
                    break;
            }
        }
    }
}