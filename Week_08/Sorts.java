package algorithm015.Week_08;

import java.util.Arrays;

public class Sorts {
    /**
     * Selection Sort 选择排序
     * 简介：把最小的排最前面
     */
    public int[] selectionSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[minIndex] > nums[j]) {
                    minIndex = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }
        return nums;
    }

    /**
     * Insertion Sort 插入排序
     * 简介：把当前值插到前面已排好序的相应位置
     */
    public int[] insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            int j = i;
            while (j > 0 && nums[j - 1] > current) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = current;
        }
        return nums;
    }

    /**
     * Bubble Sort 冒泡排序
     * 简介：比较大小，把最大的放到最后。
     */
     public int[] bubbleSort(int[] nums) {
         for (int i = 0; i < nums.length - 1; i++) {
             for (int j = 0; j < nums.length - i - 1 ; j++) {
                    if (nums[j] > nums[j + 1]) {
                        int temp = nums[j];
                        nums[j] = nums[j + 1];
                        nums[j + 1] = temp;
                    }
             }
         }
         return nums;
     }




    public static void main(String[] args) {
        Sorts sorts = new Sorts();
        int[] nums = {5, 2, 3, 9, 4, 6, 8, 7, 1};
        System.out.println(Arrays.toString(nums));
        //System.out.println(Arrays.toString(sorts.selectionSort(nums)));
//        System.out.println(Arrays.toString(sorts.insertionSort(nums)));
        System.out.println(Arrays.toString(sorts.bubbleSort(nums)));
    }
}
