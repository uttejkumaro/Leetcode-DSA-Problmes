class Solution {    
    int[] drow = {0, -1, 0, 1};
    int[] dcol = {-1, 0, 1, 0};
    void dfs(int i, int j, int n, int m, boolean[][] vis, int[][] grid) {
        vis[i][j] = true;

        for (int k = 0; k < 4; k++) {
            int row = i + drow[k];
            int col = j + dcol[k];

            if (row >= 0 && col >= 0 && row < n && col < m && !vis[row][col] && grid[row][col] == 1) {
                dfs(row, col, n, m, vis, grid);
            }
        }
    }

    int find_islands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    dfs(i, j, n, m, vis, grid);
                    cnt++;
                }
            }
        }

        if (cnt > 1 || cnt == 0) {
            return 0;
        }
        cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    cnt++;
                }
            }
        }
        if (cnt == 1) {
            return 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                } else {
                    continue;
                }

                vis = new boolean[n][m];
                int cnt1 = 0;

                for (int k = 0; k < n; k++) {
                    for (int l = 0; l < m; l++) {
                        if (grid[k][l] == 1 && !vis[k][l]) {
                            dfs(k, l, n, m, vis, grid);
                            cnt1++;
                        }

                        if (cnt1 >= 2) {
                            return 1;
                        }
                    }
                }

                grid[i][j] = 1;
            }
        }

        return 2;
    }

    public int minDays(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        return find_islands(grid);
    }
}