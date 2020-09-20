package algorithm015.Week_04;

public class IsPerfectSquare {
    /**
     * 二分查询
     * TC: O(logn)
     * SC: O(1)
     * 关键思路：
     * 1.
     */
    public boolean isPerfectSquare(int num) {
        if (num < 2) return true;

        long left = 2;
        long right = num / 2;
        long middle, square;

        while (left <= right) {
            middle = (left + right) / 2;
            square = middle * middle;

            if (square == num) return true;
            if (square > num) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return false;
    }
}
