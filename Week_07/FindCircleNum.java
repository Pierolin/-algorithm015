package algorithm015.Week_07;

public class FindCircleNum {
    /**
     * 方法一：DFS(深度优先)
     * TC: O(n^2)
     * SC: O(n)
     * 解题关键：
     *  1. 递归找某个人的朋友及朋友的朋友的朋友...，所有找到的朋友形成一个朋友圈;
     *  2. 未被找到过的朋友形成新的朋友圈。
     */
    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0 || (M.length == 1 && M[0].length == 0)) return 0;

        int count = 0;
        int[] visited = new int[M.length];

        for (int i = 0; i < M.length; i++) {
            if (visited[0] == 0) {
                count++;
                dfs(M, visited, i);
            }
        }
        return count;
    }

    private void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }
}
