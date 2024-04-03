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

        int playerScore = 0; // 玩家分數
        int bankerScore = 0; // 莊家分數
        boolean turnState = true;
        while (!key.equals("N")) {
            if (cardCount == deck.length) {
                cardCount = 0;

                for (int i = 0; i < deck.length; i++) {
                    deck[i] = i;
                }

                for (int i = 0; i < deck.length; i++) {
                    int temp = deck[i];
                    int randomIndex = (int) (Math.random() * 52);
                    deck[i] = deck[randomIndex];
                    deck[randomIndex] = temp;
                }
            }

            System.out.println((turnState ? "玩家" : "莊家") + "回合");
            if (!turnState && bankerScore < 17) {
                System.out.println("莊家分數小於17，自動要牌");
            } else {
                System.out.println("輸入y發牌，結算輸入n");
                key = scan.nextLine();
            }

            if (key.equals("y") || (!turnState && bankerScore < 17)) {
                int card = deck[cardCount];
                int suitScore = card % 13;
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

                switch (suitScore) {
                    // A
                    case 0:
                        suit = "A";
                        if (turnState) {
                            if (playerScore + suitScore > 21) {
                                playerScore += 1;
                            } else {
                                playerScore += 11;
                            }
                        } else {
                            if (bankerScore + suitScore > 21) {
                                bankerScore += 1;
                            } else {
                                bankerScore += 11;
                            }
                        }
                        break;
                    // 2
                    case 1:
                        suit = "A";
                        if (turnState) {
                            playerScore += 2;
                        } else {
                            bankerScore += 2;
                        }
                        break;
                    // 3
                    case 2:
                        suit = "3";
                        if (turnState) {
                            playerScore += 3;
                        } else {
                            bankerScore += 3;
                        }
                        break;
                    // 4
                    case 3:
                        suit = "4";
                        if (turnState) {
                            playerScore += 4;
                        } else {
                            bankerScore += 4;
                        }
                        break;
                    // 5
                    case 4:
                        suit = "5";
                        if (turnState) {
                            playerScore += 5;
                        } else {
                            bankerScore += 5;
                        }
                        break;
                    // 6
                    case 5:
                        suit = "6";
                        if (turnState) {
                            playerScore += 6;
                        } else {
                            bankerScore += 6;
                        }
                        break;
                    // 7
                    case 6:
                        suit = "7";
                        if (turnState) {
                            playerScore += 7;
                        } else {
                            bankerScore += 7;
                        }
                        break;
                    // 8
                    case 7:
                        suit = "8";
                        if (turnState) {
                            playerScore += 8;
                        } else {
                            bankerScore += 8;
                        }
                        break;
                    // 9
                    case 8:
                        suit = "9";
                        if (turnState) {
                            playerScore += 9;
                        } else {
                            bankerScore += 9;
                        }
                        break;
                    // 10
                    case 9:
                        suit = "10";
                        if (turnState) {
                            playerScore += 10;
                        } else {
                            bankerScore += 10;
                        }
                        break;
                    // J
                    case 10:
                        suit = "J";
                        if (turnState) {
                            playerScore += 10;
                        } else {
                            bankerScore += 10;
                        }
                        break;
                    // Q
                    case 11:
                        suit = "Q";
                        if (turnState) {
                            playerScore += 10;
                        } else {
                            bankerScore += 10;
                        }
                        break;
                    // K
                    case 12:
                        suit = "K";
                        if (turnState) {
                            playerScore += 10;
                        } else {
                            bankerScore += 10;
                        }
                        break;
                    default:
                        break;
                }
                cardCount++;

                System.out.println("抽中了" + face + "-" + suit + "\n");
            } else if (key.equals("n")) {
                System.out.println("玩家總點數: " + playerScore);
                System.out.println("莊家總點數: " + bankerScore);
                if (playerScore > 21) {
                    System.out.println("玩家輸了");
                } else if (bankerScore > 21) {
                    System.out.println("莊家輸了");
                } else {
                    if (playerScore > bankerScore) {
                        System.out.println("玩家贏了");
                    } else {
                        System.out.println("莊家贏了");
                    }
                }
                System.out.println("要繼續下一輪嗎(結束請輸入N)？");
                key = scan.nextLine();
                if (!key.equals("N")) {
                    playerScore = 0;
                    bankerScore = 0;
                    turnState = true;
                    continue;
                }
            } else {
                System.out.println("不明指令");
                System.out.println("輸入y繼續發牌，結算輸入n");
            }

            turnState = !turnState;
        }
    }
}