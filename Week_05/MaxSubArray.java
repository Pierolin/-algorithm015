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

    /**
     * 分治 + 递归
     */
    public int maxSubArray_3(int[] nums) {
       return calculateByRange(nums, 0, nums.length - 1);
    }

    private int calculateByRange(int[] nums, int start, int end) {
        // terminator
        if (start == end) {
            return nums[start];
        }

        int center = (start + end) / 2;

        // calculate left max
        int maxLeft = calculateByRange(nums, start, center);

        // calculate right max
        int maxRight = calculateByRange(nums, center + 1, end);

        // calculate cross center max
        int maxCenterLeft = nums[center];
        int sumCenterLeft = 0;
        for (int i = center; i >= start; i--) {
            sumCenterLeft += nums[i];
            maxCenterLeft = Math.max(maxCenterLeft, sumCenterLeft);
        }

        int maxCenterRight = nums[center + 1];
        int sumCenterRight = 0;
        for (int i = center + 1; i <= end; i++) {
            sumCenterRight += nums[i];
            maxCenterRight = Math.max(maxCenterRight, sumCenterRight);
        }

        int maxCrossCenter = maxCenterLeft + maxCenterRight;

        return Math.max(maxCrossCenter, Math.max(maxLeft, maxRight));
    }


    public static void main(String[] args) {
        MaxSubArray maxSubArray = new MaxSubArray();
        int[] nums = {2,0,3,-2};
        int max = maxSubArray.maxSubArray_3(nums);
        System.out.println(max);
    }
}
