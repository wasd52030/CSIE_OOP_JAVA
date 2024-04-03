// javac -encoding utf-8 Cal.java
public class Cal {
	public static void main(String args[]) {

		int result = 0;
		try {
			switch (args[1].charAt(0)) {
				case '+':
					result = Integer.parseInt(args[0]) + Integer.parseInt(args[2]);
					System.out.println("運算結果是" + result);
					break;
				case '-':
					result = Integer.parseInt(args[0]) - Integer.parseInt(args[2]);
					System.out.println("運算結果是" + result);
					break;
				case 'x':
					result = Integer.parseInt(args[0]) * Integer.parseInt(args[2]);
					System.out.println("運算結果是" + result);
					break;
				case '/':
					result = Integer.parseInt(args[0]) / Integer.parseInt(args[2]);
					System.out.println("運算結果是" + result);
					break;
				default:
					System.out.println(args[1] + " 是無效的運算符! 無法運算");
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("參數數量不正確");
		} catch (NumberFormatException e) {
			System.out.println("此程式不接受小數");
		} catch (ArithmeticException e) {
			System.out.println("除數不得為0");
		}
	}
}
