package algorithm015.Week_03;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        /**
         * 方法一：HashMap
         * TC: O(n)
         * SC: O(n)
         * 解题关键：
         * 1. 使用 HashMap 存访问过的数及下标;
         */

        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[]{map.get(diff),i};
            }
            else {
                map.put(nums[i],i);
            }
        }
        return new int[2];

        /**
         * 方法二：暴力双循环
         * TC: O(n^2)
         * SC: 0(1)
         */
        /*
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i,j};
                }
            }
        }
         return new int[2];
        */
    }
}
