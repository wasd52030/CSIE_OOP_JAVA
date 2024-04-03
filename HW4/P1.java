public class P1{
    public static void main(String[] args){
        // 1.String與Char輸出結果不同
        //  - String輸出結果：String = 88
        //  - Char輸出結果：Char = X
        // 字元(char)輸出時會依照所支援的字元集做對應的輸出，而字串是由許多字元組成的陣列
        String a="88";
        char b=88;
        System.out.println("String = "+a);
        System.out.println("Char = "+b);

        // 2
        //  - String輸出結果：a = 881
        //  - Char輸出結果：b = Y
        //  - 當string與int相加時會將int併到字串裡面
        //  - 當char與int相加時會將char的值+1再對應回字元集
        a=a+1;
        b=(char)(b+1);
        System.out.println("a = "+a);
        System.out.println("b = "+b);
    }
}