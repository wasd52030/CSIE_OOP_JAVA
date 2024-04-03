// 所附class檔能執行到變數b的運算與執行

public class main {
    public static void main(String[] args) {
        // 請問 a 的輸出結果是否與計算機的輸出結果一樣?不同的話，請詳述原因。
        // 計算機結果與java執行結果不同
        // 原因為java在進行除法時如果除數是int的話結果會被轉整int，小數部分通通不見
        double a = 100 / 71 * 47 + 18 - 7 - 51 * 87 / 5 + 41 * 2 / 75 + 100;
        System.out.println("1.a");
        System.out.println("calculator result: -709.109483568075");
        System.out.println("java result: " + a + "\n");

        // 請問 b c 值是否不同?有的話，請詳述原因。
        // b c結果不同
        // 原因跟剛才一樣，java在進行除法時如果除數是int的話結果會被轉整int，小數部分通通不見
        float b = 100 / 47 * 47;
        System.out.println("1.b");
        System.out.println("calculator result: 100");
        System.out.println("java result: " + b);

        // 整數預設為int，浮點預設為double
        // 導致下面的程式會出現下面的編譯錯誤
        // Type mismatch: cannot convert from double to float
        // float c = 100 / 47.0 * 47.0;
        // System.out.println("1.c");
        // System.out.println("calculator result: 100");
        // System.out.println("java result: " + c + "\n");
    }
}