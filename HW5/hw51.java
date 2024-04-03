public class hw51{
    public static void main(String[] args){
        int var=111;
        System.out.println("跑计 var "+ var);

        // intいㄏノ计穦祇ネ絪亩岿粇
        // incompatible types: possible lossy conversion from double to int
        // 惠眏锣Θint絪亩硄筁ぃ筁计场だ场ぃǎ
        // var=(int)333.3;
        var =333.3;
        System.out.println("跑计 var "+ var); 

        var=5;
        System.out.println("跑计 var "+ var); 

        // intいㄏノ计穦祇ネ絪亩岿粇
        // incompatible types: possible lossy conversion from double to int
        // 磅︽挡狦穦痙俱计场だ计场だ场ぃǎ
        // 惠眏锣Θint絪亩硄筁ぃ筁计场だ场ぃǎ
        // var=(int)7.654321;
        var=7.654321;
        System.out.println("跑计 var "+ var); 
    }
}