package algorithm015.Week_05;

public class Rob {
    public int rob(int[] nums) {
        /**
         * 1. 定义子问题
         * 2. 写出子问题的递推关系
         * 3. 确定 dp 数组的计算顺序
         * 4. 空间优化 (可选)
         */
        // 子问题：
        // f(k) = 偷 [0...k) 房间中的最大金额

        // 递推关系
        // f(0) = 0
        // f(1) = nums[0]
        // f(k) = max{f(k-1), nums[k-1] + f(k-2)}
/*

        if (nums.length == 0) return 0;
        if (nums.length == 1) return  nums[0];

        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int k = 2; k <= nums.length; k++) {
            dp[k] = Math.max(dp[k - 1], nums[k - 1] + dp[k - 2]);
        }

        return dp[nums.length];
*/
        if (nums.length == 0) return 0;
        if (nums.length == 1) return  nums[0];

        int previous = 0;
        int current = nums[0];
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(current, nums[i] + previous);
            previous = current;
            current = max;
        }
        return max;

    }
}
