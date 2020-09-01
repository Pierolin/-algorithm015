package algorithm015.Week_02;

import java.util.Arrays;

public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 处理边界问题
        if (nums.length == 0 || k < 1) return new int[]{};

        int len = nums.length - k + 1;
        int[] maxes = new int[len];
        for (int i = 0; i < len; i++) {
            if (i > 0) {
                // 进入窗口的新元素比前一组的最大值还大或相等时，那么这个新元素一定是该窗口最大的元素
                if (nums[i + k - 1] >= maxes[i - 1]) {
                    maxes[i] = nums[i + k - 1];
                    continue;
                }
                // 进入窗口的新元素比前一组的元素且离开窗口元素不是前一窗口最大元素，那么前一窗口的最大原素就是本窗口的最大元素
                if (nums[i + k - 1] < maxes[i - 1] && maxes[i - 1] > nums[i - 1]) {
                    maxes[i] = maxes[i - 1];
                    continue;
                }
            }

            // 获取当前窗口的最大元素
            int max = nums[i];
            for (int j = 1; j < k; j++) {
                if (nums[i + j] > max) max = nums[i + j];
            }
            maxes[i] = max;
        }
        return maxes;
    }

    public static void main(String[] args) {
        MaxSlidingWindow maxSlidingWindow = new MaxSlidingWindow();
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] maxes = maxSlidingWindow.maxSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(maxes));

    }
}
