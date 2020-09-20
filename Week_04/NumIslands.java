package algorithm015.Week_04;

public class NumIslands {
    public int numIslands(char[][] grid) {
        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    num++;
                    setZero(grid, i, j);
                }
            }

        }
        return num;
    }

    private void setZero(char[][] grid, int i, int j) {

        if (i > 0 && grid[i - 1][j] == '1') {
            grid[i - 1][j] = '0';
            setZero(grid, i - 1, j);
        }
        if (j > 0 && grid[i][j - 1] == '1') {
            grid[i - 1][j] = '0';
            setZero(grid, i, j - 1);
        }
        if (j < grid[0].length - 1 && grid[i][j + 1] == '1') {
            grid[i][j + 1] = '0';
            setZero(grid, i, j + 1);
        }
        if (i < grid.length - 1 && grid[i + 1][j] == '1') {
            grid[i + 1][j] = 0;
            setZero(grid, i + 1, j);
        }
    }
}
