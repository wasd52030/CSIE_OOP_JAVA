// file encode utf8 build command -> javac -encoding utf-8 main.java

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class main {
    public static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        System.out.print("請輸入陣列元素個數: ");
        
        int number = Integer.valueOf(scan.nextLine());
        int[] arr1 = new int[number];
        int[] arr2 = new int[number];

        for (int i = 0; i < arr1.length; i++) {
            System.out.print("陣列1-請輸入資料: ");
            arr1[i] = Integer.valueOf(scan.nextLine());
        }

        for (int i = 0; i < arr2.length; i++) {
            System.out.print("陣列2-請輸入資料: ");
            arr2[i] = Integer.valueOf(scan.nextLine());
        }

        menu(arr1, arr2);
    }

    static void menu(int[] arr1, int[] arr2) {

        int key = 0;

        System.out.println("請選擇下列選項: ");
        System.out.println("(1) 排序陣列");
        System.out.println("(2) 亂序陣列");
        System.out.println("(3) 查詢陣列");
        System.out.println("(4) 離開");
        key = Integer.valueOf(scan.nextLine());

        switch (key) {
            case 1:
                sortArrs(arr1, arr2);
                menu(arr1, arr2);
                break;
            case 2:
                shuffleArrs(arr1, arr2);
                menu(arr1, arr2);
                break;
            case 3:
                System.out.print("請輸入要查找的元素: ");
                key = Integer.valueOf(scan.nextLine());
                int[] result = findArrsElement(arr1, arr2, key);

                System.out.println((result[0] > -1) ? ("查詢的元素在陣列1中的index為" + result[0]) : "查無此元素");
                System.out.println((result[1] > -1) ? ("查詢的元素在陣列2中的index為" + result[1]) : "查無此元素");
                menu(arr1, arr2);
                break;
            case 4:
                return;
            default:
                System.out.println("未定義選項");
                break;
        }
    }

    static void sortArrs(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        System.out.println("陣列1: " + Arrays.toString(arr1));
        System.out.println("陣列2: " + Arrays.toString(arr2));
    }

    static void shuffleArrs(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            int randIndex = (int) (Math.random() * arr1.length);

            int temp = arr1[randIndex];
            arr1[randIndex] = arr1[i];
            arr1[i] = temp;

            temp = arr2[randIndex];
            arr2[randIndex] = arr2[i];
            arr2[i] = temp;
        }

        System.out.println("陣列1: " + Arrays.toString(arr1));
        System.out.println("陣列2: " + Arrays.toString(arr2));
    }

    static int[] findArrsElement(int[] arr1, int[] arr2, int key) {
        int[] result = new int[2];
        result[0] = Arrays.binarySearch(arr1, key);
        result[1] = Arrays.binarySearch(arr2, key);

        return result;
    }
}