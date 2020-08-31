package algorithm015.Week_02;

import java.util.Arrays;
import java.util.HashMap;

public class Intersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        // 方法一：哈希表

        // 将长度短的数组换到前面。
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }

        // 创建 HashMap 记录 nums1 中每个元素出现的次数。
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int i = 0;
        int[] result = new int[nums1.length];

        // 遍历数组 nums2 中元素，在 HashMap 中个数大于 0 则记录。
        for (int num : nums2) {
            if (map.getOrDefault(num, 0) > 0) {
                result[i] = num;
                map.put(num, map.get(num)-1);
                i++;
            }
        }

        // 遍历完成返回重复元素长度的结果数组。
        return Arrays.copyOfRange(result, 0, i);

        // 方法二：排序
        /*
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len1 = nums1.length, len2 = nums2.length;
        int[] result = new int[len1 > len2 ? len2 : len1];
        int i = 0, j = 0, n = 0;
        while (i < len1 && j <  len2) {
            if (nums1[i] == nums2[j]) {
                result[n] = nums1[i];
                n++;
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            }
        }
        return Arrays.copyOfRange(result, 0, n);
        */
    }

    public static void main(String[] args) {
        Intersect intersect = new Intersect();
        int[] nums1 = new int[]{1, 2, 2, 1};
        int[] nums2 = new int[]{2, 2};
        int[] result = intersect.intersect(nums1, nums2);
        System.out.println(Arrays.toString(result));
    }
}
