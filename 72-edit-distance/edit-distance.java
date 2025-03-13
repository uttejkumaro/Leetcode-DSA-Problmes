// class Solution {
//     int helper(String word1, String word2, int i, int j, int[][] dp) {
      
//         if (i < 0) return j + 1;//If word1  empty,insert all remaining characters of word2
//         if (j < 0) return i + 1; 
//         if (dp[i][j] != -1) return dp[i][j];
//         // If characters match, move diagonally in the DP table
//         if (word1.charAt(i) == word2.charAt(j)) {
//             return dp[i][j] = helper(word1, word2, i - 1, j - 1, dp);
//         }
//         // Compute the minimum of the three operations: replace, delete, or insert
//         return dp[i][j] = 1 + Math.min(helper(word1, word2, i - 1, j - 1, dp), // Replace
//                              Math.min(helper(word1, word2, i - 1, j, dp), // Delete
//                                 helper(word1, word2, i, j - 1, dp))); // Insert
//     }
//    public int minDistance(String word1, String word2) {
//         int m = word1.length();
//         int n = word2.length();
//         int[][] dp = new int[m + 1][n + 1];

//         // Initialize the DP table with -1
//         for (int[] row : dp) {
//             Arrays.fill(row, -1);
//         }
//         return helper(word1, word2, m - 1, n - 1, dp);
//     }
// }
class Solution {
    private int helper(int idx1,int n,String word1,int idx2,int m,String word2,int memo[][]){
        if(idx1==n){
            return m-idx2;
        }
        else if(idx2==m){
            return n-idx1;
        }
        if(memo[idx1][idx2]!=-1) return memo[idx1][idx2];
        int result=-1;
        if(word1.charAt(idx1)==word2.charAt(idx2)){
            result=helper(idx1+1,n,word1,idx2+1,m,word2,memo);
        }
        else{
           result=1+Math.min(Math.min(helper(idx1+1,n,word1,idx2+1,m,word2,memo),
            helper(idx1+1,n,word1,idx2,m,word2,memo)),
            helper(idx1,n,word1,idx2+1,m,word2,memo));
        }
        return memo[idx1][idx2]=result;

    }
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int memo[][]=new int[n][m];
        for(int row[]:memo){
            Arrays.fill(row,-1);
        }
        return helper(0,n,word1,0,m,word2,memo);

            }
}