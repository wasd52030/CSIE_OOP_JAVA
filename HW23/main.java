// file encode utf8 build command -> javac -encoding utf-8 main.java

import java.io.IOException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int[] deck = new int[52];

        int cardCount = 0;
        String key = "";

        for (int i = 0; i < deck.length; i++) {
            deck[i] = i;
        }

        for (int i = 0; i < deck.length; i++) {
            int temp = deck[i];
            int randomIndex = (int) (Math.random() * 52);
            deck[i] = deck[randomIndex];
            deck[randomIndex] = temp;
        }

        while (cardCount < deck.length && !key.equals("N")) {
            int temp = 0;
            for (int i = cardCount; i < cardCount + 4; i++) {
                int card = deck[i];
                String face = "", suit = "";

                switch (card / 13) {
                    case 0:
                        face = "黑桃";
                        break;
                    case 1:
                        face = "紅桃";
                        break;
                    case 2:
                        face = "方塊";
                        break;
                    case 3:
                        face = "梅花";
                        break;
                    default:
                        break;
                }

                switch (card % 13) {
                    case 0:
                        suit = "Ace";
                        break;
                    case 1:
                        suit = "2";
                        break;
                    case 2:
                        suit = "3";
                        break;
                    case 3:
                        suit = "4";
                        break;
                    case 4:
                        suit = "5";
                        break;
                    case 5:
                        suit = "6";
                        break;
                    case 6:
                        suit = "7";
                        break;
                    case 7:
                        suit = "8";
                        break;
                    case 8:
                        suit = "9";
                        break;
                    case 9:
                        suit = "10";
                        break;
                    case 10:
                        suit = "Jack";
                        break;
                    case 11:
                        suit = "Queen";
                        break;
                    case 12:
                        suit = "King";
                        break;
                    default:
                        break;
                }

                System.out.print(face + "-" + suit + " ");

                temp = i;
            }
            cardCount = temp + 1;
            System.out.println();
            System.out.println("要繼續發牌嗎(結束請輸入N)？");
            key = scan.nextLine();
            if (cardCount == deck.length) {
                System.out.println("牌組沒牌了！");
            }
        }

    }
}