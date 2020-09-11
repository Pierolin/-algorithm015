package algorithm015.Week_03;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        /**
         * 方法一：HashMap
         * TC: O(n)
         * SC: O(n)
         */
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            int difference = target - nums[i];
            if (map.containsKey(difference)) {
                return new int[]{map.get(difference), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;

        /**
         * 方法二：双循环
         * TC: O(n^2)
         * SC: 0(1)
         */
        /*
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
        */
    }
}
