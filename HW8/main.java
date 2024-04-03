public class main {
    public static void main(String[] args) {
        // 58 + 10 * 7 - 7 / (7 - 3) + 60 / 3 * 7
        // 58+70-7/4+20*7
        // (java如不標明為浮點的話，除法通通為正數，小數通通不見，於是上一步的7/4原本是1.75，這裡會變成1)
        // 128-1+140 (128-1.75+140)
        // 267 (266.25)
        float x = 58 + 10 * 7 - 7 / (7 - 3) + 60 / 3 * 7;
        System.out.println("2.1");
        System.out.println("result: " + x + "\n");

        // i初始值為1
        // a=i++ =>先把i賦值給a，i再加1 a=1,i=2
        // b=++i =>先把i加1再賦值給b a=3,i=3
        // c=i-- =>先把i賦值給c，i再減1 a=3,i=2
        // d=--i =>先把i減1再賦值給d a=1,i=1
        int i = 1;
        int a = i++;
        int b = ++i;
        int c = i--;
        int d = --i;
        System.out.println("2.2");
        System.out.println("a= " + a + " " + "b= " + b);
        System.out.println("c= " + c + " " + "d= " + d);
        System.out.println();

        // (8 >> 1) + (25 << 3) - (9 >> 2) * (6 << 1) / (5 >> 1)
        // 4+200-2*12/2
        // 192.0
        double h = (8 >> 1) + (25 << 3) - (9 >> 2) * (6 << 1) / (5 >> 1);

        // (67 << 3 >= 41 >> 1)
        // 536>=20
        // true
        boolean k = (67 << 3 >= 41 >> 1);

        // (91 <= 73)
        // false
        boolean j = (91 <= 73);

        System.out.println("2.3");
        System.out.println("h= " + h);
        System.out.println("k= " + k);
        System.out.println("j= " + j);
    }
}