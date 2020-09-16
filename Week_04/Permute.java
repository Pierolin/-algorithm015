package algorithm015.Week_04;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) return result;

        Deque<Integer> element = new ArrayDeque();
        boolean[] selecteds = new boolean[nums.length];
        backTrack(result, nums, element, selecteds);

        return result;
    }

    private void backTrack(List<List<Integer>> result, int[] nums, Deque<Integer> element, boolean[] selecteds) {
        if (element.size() == nums.length) {
            result.add(new ArrayList<>(element));
        }

        for (int i = 0; i < nums.length; i++) {
            if (selecteds[i]) continue;
            element.addLast(nums[i]);
            selecteds[i] = true;
            backTrack(result, nums, element, selecteds);
            element.removeLast();
            selecteds[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Permute solution = new Permute();
        List<List<Integer>> lists = solution.permute(nums);
        System.out.println(lists);
    }

}
