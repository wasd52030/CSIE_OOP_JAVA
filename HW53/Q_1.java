import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_1 {
	public static void main(String arg[]) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("請輸入半徑：");
		double r = Double.parseDouble(buf.readLine());
		// Circle.pi=5;
		Circle c = new Circle(r);
	}
}
class Circle {
	// 在java中如需宣告常數(const)要使用final修飾
	final static double pi = 3.14;

	Circle(double r) {
		System.out.println("圓的面積為:" + r*r*pi);
	}
}