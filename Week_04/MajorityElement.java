package algorithm015.Week_04;

import java.util.Arrays;

public class MajorityElement {
    public int majorityElement(int[] nums){
        Arrays.sort(nums);
        int middle = nums.length/2;
        return nums[middle];
    }
}
