package algorithm015.Week_09;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 120. 三角形最小路径和
 * https://leetcode-cn.com/problems/triangle/
 */
public class MinimumTotal {

    /**
     * 方法一：动态规划
     */
    public int minimumTotal_1(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()];
        List<Integer> lastRow = triangle.get(triangle.size() - 1);
        for (int i = 0; i < lastRow.size(); i++) {
            dp[i] = lastRow.get(i);
        }

        for (int row = triangle.size() - 2; row > -1; row--) {
            List<Integer> list = triangle.get(row);
            for (int col = 0; col < list.size(); col++) {
                dp[col] = Math.min(dp[col], dp[col + 1]) + list.get(col);
            }
        }
        return dp[0];
    }

    /**
     * 方法二：递归 + 缓存
     * TC: O(n^2)
     * SC: O(n^2)
     * 解题思路：
     * 1. 使用缓存，从而避免重复计算;
     * 2. 自底向顶计算出到每个点的最小值并保存到缓存;
     * 3. 某点到达底线的最小什为：f(i, j) = min(f(i + 1, j), f(i + 1, j + 1)) + triangle[i][j]
     */
    public int minimumTotal_2(List<List<Integer>> triangle) {
        Integer[][] cache = new Integer[triangle.size()][triangle.size()];
        return calculate(0, 0, triangle, cache);

    }

    private Integer calculate(int row, int col, List<List<Integer>> triangle, Integer[][] cache) {
        if (row == triangle.size()) {
            return 0;
        }
        if (cache[row][col] == null) {
            cache[row][col] = Math.min(calculate(row + 1, col, triangle, cache), calculate(row + 1, col + 1, triangle, cache)) + triangle.get(row).get(col);
        }
        return cache[row][col];
    }
}
