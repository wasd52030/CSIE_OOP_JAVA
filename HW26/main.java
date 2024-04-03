// file encode utf8 build command -> javac -encoding utf-8 main.java

import java.io.IOException;
import java.util.Scanner;

public class main {

    public static void main(String[] args) throws IOException {
        int[] arr = new int[1], arr1 = new int[1], arr2 = new int[1];
        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < 2; i++) {
            System.out.printf("請輸入第%d個陣列個數: ", i + 1);
            int length = Integer.valueOf(scan.nextLine());
            if (length == 0) {
                if (i == 0) {
                    arr1 = new int[] { 2, 61, 43, 9 };
                    continue;
                } else if (i == 1) {
                    arr2 = new int[] { 2, 61, 43, 9 };
                    break;
                }
            } else {
                if (i == 0) {
                    arr1 = new int[length];
                } else if (i == 1) {
                    arr2 = new int[length];
                }
            }

            for (int j = 0; j < length; j++) {
                System.out.printf("第%d個數字: ", j + 1);
                if (i == 0) {
                    arr1[j] = Integer.valueOf(scan.nextLine());
                } else if (i == 1) {
                    arr2[j] = Integer.valueOf(scan.nextLine());
                }
            }
        }

        arr = new int[arr1.length + arr2.length];
        array_merge(arr, arr1, arr2);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void array_merge(int dstArr[], int arr1[], int arr2[]) {
        for (int i = 0; i < arr1.length; i++) {
            dstArr[i] = arr1[i];
        }

        for (int i = 0; i < arr2.length; i++) {
            dstArr[arr1.length + i] = arr2[i];
        }
    }
}