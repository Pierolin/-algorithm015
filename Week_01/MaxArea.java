package algorithm015.Week_01;

public class MaxArea {
    public int maxArea(int[] height) {
        /**
         * 方法一：双指针
         *
         */
        int max = 0;
        for (int i = 0, j = height.length - 1; i < j; ) {
            int minHeight = height[i] < height[j] ? height[i++] : height[j--];
            max = Math.max(max, (j - i -1) * minHeight);
        }
        return max;

       /* int i = 0;
        int j = height.length - 1;
        while (i < j) {
            int area = (j - i) * Math.min(height[i], height[j]);
            if (area > max) max = area;
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
        */

        /**
         * 方法二：双循环暴力解法
         * TC: O(n^2)
         * SC: O(1)
         */
        /*
        int max = 0;
        int length = height.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                int area = Integer.min(height[i], height[j]) * (j - i);
                max = area > max ? area : max;
            }
        }
        return max;*/
    }
}
