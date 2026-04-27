import java.util.*;

class Solution {
    public boolean hasValidPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        // directions: up, down, left, right
        int[][] move = {{-1,0},{1,0},{0,-1},{0,1}};

        int[][] dirs = {
            {},
            {2,3},
            {0,1},
            {2,1},
            {3,1},
            {2,0},
            {3,0}
        };

        int[] opp = {1,0,3,2};

        boolean[][] vis = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{0,0});
        vis[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            if (x == m - 1 && y == n - 1) return true;

            for (int d : dirs[grid[x][y]]) {
                int nx = x + move[d][0];
                int ny = y + move[d][1];

                if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                if (vis[nx][ny]) continue;

                // check reverse connection
                for (int nd : dirs[grid[nx][ny]]) {
                    if (nd == opp[d]) {
                        vis[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                        break;
                    }
                }
            }
        }

        return false;
    }
}