package algorithm015.Week_05;

import java.util.ArrayList;
import java.util.List;

public class MaxSubArray {
    /**
     * 动态规划
     * TC: O(n)
     * SC: O(1)
     * 解题关键：
     * 1. 只要和是负数，就重新开始计数
     */
    public int maxSubArray_2(int[] nums) {
        int max = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    /**
     * 暴力双循环穷举
     * TC: O(n^2)
     * SC: O(n)
     * 解题关键：
     * 1. 穷举每一种连续子系列，比较它们的和取得最大值
     */
    public int maxSubArray_1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int max = nums[0];

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                max = Math.max(max, sum);
            }
        }

        return max;
    }


    public static void main(String[] args) {
        MaxSubArray maxSubArray = new MaxSubArray();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int max = maxSubArray.maxSubArray_2(nums);
        System.out.println(max);
    }
}
