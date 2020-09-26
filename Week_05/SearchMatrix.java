package algorithm015.Week_05;

public class SearchMatrix {
    /**
     * 半暴力求解
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix_3(int[][] matrix, int target) {
        return false;
    }
    /**
     * 一次二分查找
     * TC: O(log(mn))
     * SC: O(1)
     * 解题关键：
     * 1. 二维数组虚拟为一维数组；
     * 2. 二分后再转为二维数组获取中间值
     *
     */
    public boolean searchMatrix_2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || (matrix.length == 1 && matrix[0].length == 0)) {
            return false;
        }

        int left = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int count = rows * cols;
        int right = count - 1;

        while (left <= right) {
            int middle = (left + right) / 2;
            int middleItem = matrix[middle / cols][middle % cols];
            if (target == middleItem) {
                return true;
            } else if (target > middleItem) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return false;

    }

    /**
     * 二次二分查找
     * TC: O(logm + logn)
     * SC: O(1)
     */
    public boolean searchMatrix_1(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || (matrix.length == 1 && matrix[0].length == 0)) {
            return false;
        }
        int left = 0;
        int right = matrix.length - 1;
        while (left < right) {
            int middel = (left + right) / 2;
            if (target > matrix[middel][matrix[middel].length - 1]) {
                left = middel + 1;
            } else {
                if (target < matrix[middel][0]) {
                    right = middel - 1;
                } else {
                    right = middel;
                    break;
                }
            }
        }
        int[] row = matrix[right];
        left = 0;
        right = row.length - 1;
        while (left < right) {
            int middle = (left + right) / 2;
            if (target > row[middle]) {
                left = middle + 1;
            } else if (target < row[middle]) {
                right = middle - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SearchMatrix searchMatrix = new SearchMatrix();
        int target = 3;
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        System.out.println(searchMatrix.searchMatrix_2(matrix, target));
    }
}
