public class hw6{
    public static void main(String[] args){
        String title="靜思夜";
        String str1="床前明月光";
        String str2="疑是地上霜";
        String str3="舉頭望明月";
        String str4="低頭思故鄉";
        String author="李白";
        System.out.println(
            "\u005b"+title+"\u005d"+"\n"+
            "\t"+str1+","+"\n"+
            "\t\t"+str2+"\u3002"+"\n"+
            "\t\t\t"+str3+"\uff0c"+"\n"+
            "\t\t\t\t"+str4+"\u201b"+"\n"+
            "\t\t\t\t\t"+"\u002f"+"\u0027"+author+"\u0027"+"\u002f"
        );
    }
}