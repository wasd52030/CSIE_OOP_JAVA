public class hw52{
    public static void main(String[] args){
        // 在Java程式中，如果在浮點數型態中宣告整數的話會補一個小數位為0，可以透過System.out.printf函數以熟悉的c語言格式來整理
        float var=111;
        System.out.println("變數 var 的值為"+ var);
        System.out.printf("變數 var 的值為%.0f\n", var);

        // 在Java程式中，『浮點數數字』，預設型態是double
        // double塞到float一樣會出現error
        // incompatible types: possible lossy conversion from double to float
        // 需強轉成float才能編譯通過
        // var =(float)333.3;
        // float與double差異在於float可以保證在小數點後6位是精確的，而double可以到保證小數點後15位
        var =333.3;
        System.out.println("變數 var 的值為"+ var); 

        var=5;
        System.out.println("變數 var 的值為"+ var); 
        System.out.printf("變數 var 的值為%.0f\n", var);

        // 在Java程式中，『浮點數數字』，預設型態是double
        // double塞到float一樣會出現error
        // incompatible types: possible lossy conversion from double to float
        // 需強轉成float才能編譯通過
        // var=(float)7.654321;
        // float與double差異在於float可以保證在小數點後6位是精確的，而double可以到保證小數點後15位
        var=7.654321;
        System.out.println("變數 var 的值為"+ var); 
    }
}