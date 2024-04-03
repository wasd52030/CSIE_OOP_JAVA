// javac -encoding utf-8 Cal.java

import java.util.Scanner;

public class Cal {

	static final Scanner scan = new Scanner(System.in);

	public static void main(String args[]) {

		String formula;
		String[] tokens;

		int result = 0;
		boolean flag = false;

		do {
			formula = scan.nextLine();
			tokens = formula.split(" ");

			try {
				switch (tokens[1].charAt(0)) {
					case '+':
						result = Integer.parseInt(tokens[0]) + Integer.valueOf(tokens[2]);
						System.out.println("運算結果是" + result);
						flag = true;
						break;
					case '-':
						result = Integer.valueOf(tokens[0]) - Integer.valueOf(tokens[2]);
						System.out.println("運算結果是" + result);
						flag = true;
						break;
					case 'x':
						result = Integer.valueOf(tokens[0]) * Integer.valueOf(tokens[2]);
						System.out.println("運算結果是" + result);
						flag = true;
						break;
					case '/':
						result = Integer.valueOf(tokens[0]) / Integer.valueOf(tokens[2]);
						System.out.println("運算結果是" + result);
						flag = true;
						break;
					default:
						System.out.println(tokens[1] + " 是無效的運算符! 無法運算");
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("參數數量不正確");

				System.out.println("請重新輸入算式");
				formula = scan.nextLine();
				tokens = formula.split(" ");
			} catch (NumberFormatException e) {
				System.out.println("此程式不接受小數");

				System.out.println("請重新輸入算式");
				formula = scan.nextLine();
				tokens = formula.split(" ");
			} catch (ArithmeticException e) {
				System.out.println("除數不得為0");

				System.out.println("請重新輸入算式");
				formula = scan.nextLine();
				tokens = formula.split(" ");
			}
		} while (!flag);
	}
}
