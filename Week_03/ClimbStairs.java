package algorithm015.Week_03;

public class ClimbStairs {
    public int climbStairs(int n) {
        /**
         * 方法一： 动态规划
         * TC: O(n)
         * SC: O(1)
         */
        if (n < 3) return n;
        int fn2 = 1;
        int fn1 = 2;
        int fn = 0;
        for (int i = 3; i <= n; i++) {
            fn = fn1 + fn2;
            fn2 = fn;
            fn1 = fn2;
        }
        return fn;
        /**
         * 方法二： 动态规划
         * TC: O(n)
         * SC: O(n)
         */
        /*
        if (n < 3) return n;
        int[] arr = new int[n + 1];
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
        */

        /**
         * 方法三：递归法
         * TC: O(n)
         * SC: O(n)
         */
        /*
        if (n < 3) return n;
        int[] cache = new int[n + 1];
        cache[1] = 1;
        cache[2] = 2;
        return calculate(n, cache);
        */
    }

    /**
     * 方法三：递归法
     *
     * @param i
     * @param cache
     * @return
     */
    private int calculate(int i, int[] cache) {
        if (cache[i] > 0) return cache[i];
        cache[i] = calculate(i - 1, cache) + calculate(i - 2, cache);
        return cache[i];
    }
}
