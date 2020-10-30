package algorithm015.Week_04;

/**
 * 122. 买卖股票的最佳时机 II
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class MaxProfit {
    /**
     * 方法一：贪心算法
     * TC: O(n)
     * SC: O(1)
     * 解题思路：
     * 1. 每天都可进行交易，[i-1] 代表昨天，[i] 代表今天;
     * 2. 只要今天比昨天的价格高，昨天就可买入 -prices[i-1]，今天就可卖出 +price[i]，这样即可达到利润最大化。
     */
    public int maxProfit_1(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            // 只要今天比较昨天价高，就可执行低吸高抛交易策略
            if (prices[i] - prices[i - 1] > 0) {
                // 低吸买入昨天
                profit = profit - prices[i - 1];
                // 高抛卖出今天
                profit = profit + prices[i];

                // 以上两句可简化为如下一句：
                //profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }

    /**
     * 方法二：迭代判断
     * TC: O(n)
     * SC: O(1)
     * 解题思路：
     * 1. 通过如下 2 个因素遵循低买高卖的交易原则来决定当天的买卖。
     * 1) 当天的买卖状态;
     * 2) 当天的价格与明天的价格高低比较。
     * 2. 最后一天如果手上还持有股票要卖出。
     */
    public int maxProfit_2(int[] prices) {
        int profit = 0;
        boolean hasStock = false;

        for (int i = 0; i < prices.length - 1; i++) {
            if (!hasStock) {
                if (prices[i] < prices[i + 1]) {
                    profit -= prices[i];
                    hasStock = true;
                }
            } else {
                if (prices[i] > prices[i + 1]) {
                    profit += prices[i];
                    hasStock = false;
                }
            }
        }

        if (hasStock) profit += prices[prices.length - 1];
        return profit;
    }
}
