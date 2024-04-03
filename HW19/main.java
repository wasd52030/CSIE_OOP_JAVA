// file encode utf8 build command -> javac -encoding utf-8 main.java
import java.io.IOException;

public class main {

    public static <T> void pirntArray(String msg, T[] arr) {
        System.out.println(msg);
        for (T t : arr) {
            System.out.print(t + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        Integer[] arr1 = new Integer[] { 5, 12, 50, 23451, 1594753268 };
        Float[] arr2 = new Float[] { 0.123f, 2.037f, 15432.51f, 5632.1f };
        Character[] arr3 = new Character[] { 'x', 'Y', 'Z' };

        pirntArray("陣列1: ", arr1);
        pirntArray("陣列2: ", arr2);
        pirntArray("陣列3: ", arr3);
    }
}