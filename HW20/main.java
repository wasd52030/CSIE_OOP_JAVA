// file encode utf8 build command -> javac -encoding utf-8 main.java
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class main {

    public static <T> T[] getArray(Class<T> classType, int size) {
        return (T[]) Array.newInstance(classType, size);
    }

    public static <T> void printArray(T[] arr) {
        System.out.println(Arrays.toString(arr));
        System.out.println(arr.getClass().getSimpleName());
    }

    public static <T extends Comparable<T>> void findMinAndMax(T[] arr) {
        T min = arr[0], max = arr[0];
        for (T item : arr) {
            if (item.compareTo(max) > 0) {
                max = item;
            }

            if (item.compareTo(min) < 0) {
                min = item;
            }
        }

        System.out.println("陣列中的最大值為: " + max);
        System.out.println("陣列中的最小值為: " + min);
    }

    public static void main(String[] args) throws IOException {
        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("請輸入資料個數: ");
            int n = scan.nextInt();

            System.out.println("請輸入陣列型態: 1.int 2.double 3.char 4.long");
            int select = scan.nextInt();
            switch (select) {
                case 1:
                    var Iarr = getArray(Integer.class, n);
                    for (int i = 0; i < Iarr.length; i++) {
                        System.out.print("請輸入陣列資料: ");
                        Iarr[i] = scan.nextInt();
                    }
                    printArray(Iarr);
                    findMinAndMax(Iarr);
                    break;
                case 2:
                    var Darr = getArray(Double.class, n);
                    for (int i = 0; i < Darr.length; i++) {
                        System.out.print("請輸入陣列資料: ");
                        Darr[i] = scan.nextDouble();
                    }
                    printArray(Darr);
                    findMinAndMax(Darr);
                    break;
                case 3:
                    var Carr = getArray(Character.class, n);
                    for (int i = 0; i < Carr.length; i++) {
                        System.out.print("請輸入陣列資料: ");
                        Carr[i] = scan.next().charAt(0);
                    }
                    printArray(Carr);
                    findMinAndMax(Carr);
                    break;
                case 4:
                    var Larr = getArray(Long.class, n);
                    for (int i = 0; i < Larr.length; i++) {
                        System.out.print("請輸入陣列資料: ");
                        Larr[i] = scan.nextLong();
                    }
                    printArray(Larr);
                    findMinAndMax(Larr);
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}