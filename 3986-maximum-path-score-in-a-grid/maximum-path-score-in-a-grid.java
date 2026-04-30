import java.util.*;

class Solution {
    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;

        int[][][] dp = new int[m][n][k + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        int res = dfs(0, 0, 0, k, grid, dp);
        return res < 0 ? -1 : res;
    }

    int dfs(int i, int j, int cost, int k, int[][] grid, int[][][] dp) {
        int m = grid.length, n = grid[0].length;

        if (i >= m || j >= n) return -1000000;

        int newCost = cost + (grid[i][j] == 0 ? 0 : 1);

        if (newCost > k) return -1000000;

        if (i == m - 1 && j == n - 1) {
            return grid[i][j];
        }

        if (dp[i][j][cost] != -1) return dp[i][j][cost];

        int down = dfs(i + 1, j, newCost, k, grid, dp);
        int right = dfs(i, j + 1, newCost, k, grid, dp);

        int best = Math.max(down, right);

        if (best < 0) return dp[i][j][cost] = -1000000;

        return dp[i][j][cost] = grid[i][j] + best;
    }
}