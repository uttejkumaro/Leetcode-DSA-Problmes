class Solution {
    public int findRotateSteps(String ring, String key) {
        int n = ring.length();
        int m = key.length();
        
        // Create a 2D array to store the minimum steps required to spell each character of the key
        int[][] dp = new int[m + 1][n];
        
        // Initialize the dp array with maximum values
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        // Set the initial position of the ring (12:00 direction)
        for (int i = 0; i < n; i++) {
            if (ring.charAt(i) == key.charAt(0)) {
                dp[0][i] = Math.min(i, n - i) + 1;
            }
        }
        
        // Iterate over each character in the key
        for (int i = 1; i < m; i++) {
            // Iterate over each position of the ring
            for (int j = 0; j < n; j++) {
                if (ring.charAt(j) != key.charAt(i)) continue;
                // Iterate over each possible previous position
                for (int k = 0; k < n; k++) {
                    if (dp[i - 1][k] == Integer.MAX_VALUE) continue;
                    // Calculate the steps required to move from the previous position to the current position
                    int steps = Math.min(Math.abs(j - k), n - Math.abs(j - k)) + 1;
                    // Update the minimum steps to reach the current position
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + steps);
                }
            }
        }
        
        // Find the minimum steps required to spell the entire key
        int minSteps = Integer.MAX_VALUE;
        for (int steps : dp[m - 1]) {
            minSteps = Math.min(minSteps, steps);
        }
        
        return minSteps;
    }
}