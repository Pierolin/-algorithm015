package algorithm015.Week_06;

public class MinPathSum {
    /**
     * 动态规划
     * TC: O(n^2)
     * SC: O(1)
     */
    public int minPathSum_2(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if ( r == 0 && c == 0) continue;
                if (r == 0) {
                    grid[0][c] = grid[0][c-1] + grid[0][c];
                } else if (c == 0) {
                    grid[r][0] = grid[r-1][0] + grid[r][0];
                } else {
                    grid[r][c] = grid[r][c] + Math.min(grid[r-1][c],grid[r][c-1]);
                }
            }
        }
        return grid[rows-1][cols-1];
    }

    /**
     * 暴力求解
     * TC: O(2^n)
     * SC: O(1)
     */
    int min = 0;
    public int minPathSum(int[][] grid) {
        count(grid, 0, 0, 0);
        return min;
    }

    private void count(int[][] grid, int i, int j, int sum) {
        sum += grid[i][j];
        if (i == grid.length -1 && j==grid[0].length-1) {
            if (min == 0) {
                min = sum;
            } else {
                min = Math.min(sum, min);
            }
            return;
        }

        if(j < grid[0].length-1) {
            count(grid, i, j+1, sum);
        } else {
            count(grid, i + 1, j, sum);
        }

        if (i < grid.length -1) {
            count(grid, i+1, j, sum);
        }
        else {
            count(grid, i, j+1, sum);
        }

    }
}
