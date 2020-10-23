package algorithm015.Week_08;

import java.util.Set;
import java.util.TreeSet;

/**
 * 300. 最长上升子序列
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 */
public class LengthOfLIS {
    /**
     * 暴力动态规划 + 二分查找
     * TC: O(nlogn)
     * SC: O(n)
     * 解题思路
     * 1. 状态定义：tails[k] 的值代表 长度为 k+1 子序列 的尾部元素值;
     * 2. 转移方程： 设 res 为 tails 当前长度，代表直到当前的最长上升子序列长度。设 j∈[0,res)，考虑每轮遍历 nums[k] 时，通过二分法遍历 [0,res)列表区间，找出 nums[k] 的大小分界点，会出现两种情况：
     * 区间中存在 tails[i]>nums[k]： 将第一个满足 tails[i]>nums[k] 执行 tails[i]=nums[k]t；因为更小的 nums[k] 后更可能接一个比它大的数字（前面分析过）。
     * 区间中不存在 tails[i]>nums[k]： 意味着 nums[k] 可以接在前面所有长度的子序列之后，因此肯定是接到最长的后面（长度为 res ），新子序列长度为 res+1。
     */
    public int lengthOfLIS_1(int[] nums) {
        int[] tails = new int[nums.length];
        int max = 0;
        for (int num : nums) {
            int i = 0;
            int j = max;
            while (i < j) {
                int m = (i + j) / 2;
                if (tails[m] < num) {
                    i = m + 1;
                } else {
                    j = m;
                }
            }
            tails[i] = num;
            if (max == j) max++;
        }
        return max;
    }

    /**
     * 暴力动态规划
     * TC: O(n^2)
     * SC: O(n)
     * 解题思路
     * 1.
     */

    public int lengthOfLIS_2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int max = 0;
        int[] dp = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /**
     * TreeSet
     */
    public int lengthOfLIS_3(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Integer c = set.ceiling(nums[i]);
            if (c != null) set.remove(c);
            set.add(nums[i]);
        }
        return set.size();
    }

    /**
     * 暴力循环
     */
    public int lengthOfLIS_4(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int longest = 1;

        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            int leftLong = 0;
            int rightLong = 0;

            for (int l = i - 1; l > -1; l--) {
                if (nums[l] < temp) {
                    leftLong++;
                    temp = nums[l];
                }
            }

            temp = nums[i];
            for (int r = i + 1; r < nums.length; r++) {
                if (nums[r] > temp) {
                    rightLong++;
                    temp = nums[r];
                }
            }
            longest = Math.max(1 + leftLong + rightLong, longest);
        }
        return longest;
    }


}
