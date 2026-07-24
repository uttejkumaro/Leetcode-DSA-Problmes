class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int MAX = 2048;

        boolean[][] dp = new boolean[4][MAX];
        dp[0][0] = true;

        boolean[] ans = new boolean[MAX];
        for (int v : nums) {
            ans[v] = true;
        }
        for (int v : nums) {
            for (int c = 2; c >= 0; c--) {
                for (int x = 0; x < MAX; x++) {
                    if (dp[c][x]) {
                        dp[c + 1][x ^ v] = true;
                    }
                }
            }
        }

        for (int x = 0; x < MAX; x++) {
            if (dp[3][x]) {
                ans[x] = true;
            }
        }

        int count = 0;
        for (boolean b : ans) {
            if (b) count++;
        }

        return count;
    }
}