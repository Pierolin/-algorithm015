package algorithm015.Week_04;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    /**
     * 排序法
     * TC: O(n(logn)
     * SC: O(1)
     * 关键思路：
     * 1. 排序后相同的数一定会靠在一起;
     * 2. 排序后的数组下标为 nums.length/2 的一定是那个多数元素。
     */
    public int majorityElement_1(int[] nums) {
        Arrays.sort(nums);
        int middle = nums.length / 2;
        return nums[middle];
    }

    /**
     * 哈希表
     * TC: O(n)
     * SC: O(n)
     * 关键思路：
     * 1. 用哈希表来快速统计每个元素出现的次数;
     * 2. 边统计边检查统计的次数是否已超过半数，如无超过半数可以马上停止返回结果。
     */
    public int majorityElement_2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
            if (map.get(num) > nums.length / 2) {
                return num;
            }
        }
        throw new IllegalArgumentException("The array \"nums\" is invalid.");
    }
}
