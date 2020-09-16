package algorithm015.Week_04;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        boolean hasStock = false;
        int profit = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            if (!hasStock) {
                if (prices[i] < prices[i + 1]) {
                    profit = profit - prices[i];
                    hasStock = true;
                }
            } else {
                if (prices[i] > prices[i + 1]) {
                    profit = profit + prices[i];
                    hasStock = false;
                }
            }
        }

        if (hasStock) {
            profit = profit + prices[prices.length - 1];
        }
        return profit;
    }
}
