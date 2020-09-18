package algorithm015.Week_04;

import java.util.*;

public class PermuteUnique {
    /**
     * DFS搜索回溯
     * TC: O(n*n!)
     * SC: O(n)
     * 关键思路：
     * 1. 为了便于判断重复，要先进行排序，使相同的数字都相邻;
     * 2. 判断重复的条件:
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) return result;

        Arrays.sort(nums);
        boolean[] selected = new boolean[nums.length];
        Deque<Integer> element = new ArrayDeque<>();
        backTrack(result, nums, selected, element);
        return result;
    }

    private void backTrack(List<List<Integer>> result, int[] nums, boolean[] selected, Deque element) {
        if (element.size() == nums.length) {
            result.add(new ArrayList(element));
            //System.out.println("element size: " + element.size());
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (selected[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && selected[i - 1] == false) continue;
            element.addLast(nums[i]);
            selected[i] = true;
            backTrack(result, nums, selected, element);
            element.removeLast();
            System.out.println("element size: " + element.size());
            selected[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        PermuteUnique solution = new PermuteUnique();
        List<List<Integer>> lists = solution.permuteUnique(nums);
        System.out.println(lists);
    }
}
