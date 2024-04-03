import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {
        int target = 10000000;
        int investmentAmount = 100000;
        double investmentResult = 0;

        do {
            System.out.printf("投入%d元\n", investmentAmount);

            // 可購股數
            int stock = investmentAmount / 100;
            double interest = 0, totalInterest = 0;
            for (int i = 1; i <= 120; i++) {
                int annulStock = 25 * (stock / 1000);
                if (stock >= 1000) {
                    interest = stock * 1.5;
                    stock += annulStock;
                    totalInterest += interest;
                }
            }
            investmentResult = 100 * stock + totalInterest;
            System.out.printf("10年後持有的總股數為%d股，配息總額為%.1f元\n", stock, totalInterest);
            System.out.printf("總價值:%.1f元\n\n", investmentResult);
            
            if (investmentResult < target) {
                investmentAmount++;
            }
        } while (investmentResult < target);
        System.out.printf("初始投資金額至少需要%d元，十年後總資產才會超過1000萬元\n", investmentAmount);
    }
}