// file encode utf8 build command -> javac -encoding utf-8 main.java

import java.io.IOException;
import java.util.Scanner;
import java.util.stream.IntStream;

public class main {
    public static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        System.out.print("請輸入陣列元素個數: ");
        int key = 0;
        int begin = 0, end = 0;
        int number = Integer.valueOf(scan.nextLine());
        int[] arr = new int[number];

        for (int i = 0; i < arr.length; i++) {
            System.out.print("請輸入資料: ");
            arr[i] = Integer.valueOf(scan.nextLine());
        }

        System.out.println("請選擇下列選項: ");
        System.out.println("(1) 顯示陣列全部內容");
        System.out.println("(2) 顯示指定起始值起陣列內容");
        System.out.println("(3) 顯示指定起始範圍陣列內容");
        key = Integer.valueOf(scan.nextLine());
        switch (key) {
            case 1:
                showArray(arr);
                break;
            case 2:
                System.out.print("請輸入起始值: ");
                begin = Integer.valueOf(scan.nextLine());
                showArray(arr, begin);
                break;
            case 3:
                System.out.print("請輸入起始值: ");
                begin = Integer.valueOf(scan.nextLine());
                System.out.print("請輸入終止值: ");
                end = Integer.valueOf(scan.nextLine());
                showArray(arr, begin, end);
                break;
            default:
                System.out.println("未定義選項");
                break;
        }
    }

    static void showArray(int[] arr) {
        IntStream.of(arr).forEach(i -> System.out.print(i + " "));
        System.out.println();
    }

    static void showArray(int[] arr, int begin) {
        for (int i = begin; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    static void showArray(int[] arr, int begin, int end) {
        for (int i = begin; i < end; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}