package algorithm015.Week_06;

import java.util.Arrays;

public class CoinChange {
    /**
     * 动态规划
     * TC: O(mn)
     * SC: O(n)
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i < amount + 1; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                }
            }
        }

        return dp[amount] < amount + 1 ? dp[amount] : -1;
    }
}
