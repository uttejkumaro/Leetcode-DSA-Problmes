class Solution {
    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        long[] dp = new long[n];
        long count = 0;
        for (int j = 0; j < n; j++) {
            dp[j] = points[0][j];
        }

        for (int i = 1; i < m; i++) {
            long[] left = new long[n];
            long[] right = new long[n];

            // Fill the left array
            left[0] = dp[0];
            for (int j = 1; j < n; j++) {
                left[j] = Math.max(left[j - 1], dp[j] + j);
            }

            right[n - 1] = dp[n - 1] - (n - 1);
            for (int j = n - 2; j >= 0; j--) {
                right[j] = Math.max(right[j + 1], dp[j] - j);
            }
            for (int j = 0; j < n; j++) {
                dp[j] = points[i][j] + Math.max(left[j] - j, right[j] + j);
            }
        }
        for (int j = 0; j < n; j++) {
            count = Math.max(count, dp[j]);
        }

        return count;
    }
}
