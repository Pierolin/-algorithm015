package algorithm015.Week_05;

import java.util.ArrayList;
import java.util.List;

public class MaxSubArray {
    /**
     * 解题关键：
     * 1. 只要和是负数，就重新开始计数
     */
    public int maxSubArray(int[] nums) {
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

    public static void main(String[] args) {
        MaxSubArray maxSubArray = new MaxSubArray();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int max = maxSubArray.maxSubArray(nums);
        System.out.println(max);
    }
}
