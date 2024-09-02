class Solution {
    int helper(String word1, String word2, int i, int j, int[][] dp) {
      
        if (i < 0) return j + 1;//If word1  empty,insert all remaining characters of word2
        if (j < 0) return i + 1; 
        if (dp[i][j] != -1) return dp[i][j];
        // If characters match, move diagonally in the DP table
        if (word1.charAt(i) == word2.charAt(j)) {
            return dp[i][j] = helper(word1, word2, i - 1, j - 1, dp);
        }
        // Compute the minimum of the three operations: replace, delete, or insert
        return dp[i][j] = 1 + Math.min(helper(word1, word2, i - 1, j - 1, dp), // Replace
                             Math.min(helper(word1, word2, i - 1, j, dp), // Delete
                                helper(word1, word2, i, j - 1, dp))); // Insert
    }
   public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        // Initialize the DP table with -1
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(word1, word2, m - 1, n - 1, dp);
    }
}