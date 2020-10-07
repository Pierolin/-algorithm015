package algorithm015.Week_06;

import java.util.Arrays;

public class Rob2 {
    public int rob2(int[] nums) {
        int max = 0;
        int max1 = rob(Arrays.copyOfRange(nums, 0, nums.length - 1));
        int max2 = rob(Arrays.copyOfRange(nums, 1, nums.length));
        return Math.max(max1, max2);
    }

    private int rob(int[] nums) {
        int max = 0;
        int previous = 0;
        int current = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(nums[i] + previous, current);
            previous = current;
            current = max;
        }

        return max;
    }
}
