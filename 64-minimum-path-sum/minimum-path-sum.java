
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return minCal(m - 1, n - 1, grid, dp);
    }

    int minCal(int i, int j, int[][] grid, int[][] dp) {
        if (i == 0 && j == 0) {
            return grid[i][j];
        }
        if (i < 0 || j < 0) {
            return Integer.MAX_VALUE;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int up = Integer.MAX_VALUE;
        if (i > 0) {
            up = grid[i][j] + minCal(i - 1, j, grid, dp);
        }

        int left = Integer.MAX_VALUE;
        if (j > 0) {
            left = grid[i][j] + minCal(i, j - 1, grid, dp);
        }

        dp[i][j] = Math.min(up, left);
        return dp[i][j];
    }
}