import java.io.*;

public class Q_3 {
	public static void main(String[] args) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("請輸入半徑：");
		double r = Double.parseDouble(buf.readLine());
		System.out.print("請輸入圓周率(PI)：");
		double pi = Double.parseDouble(buf.readLine());
		Circle c = new Circle(r,pi);
	}
}

class Circle {
	final double pi = 3.14;

	Circle(double r , double pi) {
		
		System.out.println("圓的半徑為:" + r + "，PI = " + pi);
		System.out.println("圓的面積為:" + r*r*pi);
	}
}