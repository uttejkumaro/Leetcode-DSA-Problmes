class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m =text1.length();
        int n=text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }

            }

        }
        return dp[m][n];
        
    }
}
/*
i = 1 (text1[0] = 'a'):
j = 1 (text2[0] = 'a'):
Since text1[0] == text2[0], dp[1][1] = dp[0][0] + 1 = 1
j = 2 (text2[1] = 'c'):
Since text1[0] != text2[1], dp[1][2] = max(dp[0][2], dp[1][1]) = max(0, 1) = 1
j = 3 (text2[2] = 'e'):
Since text1[0] != text2[2], dp[1][3] = max(dp[0][3], dp[1][2]) = max(0, 1) = 1

dp = [
  [0, 0, 0, 0],
  [0, 1, 1, 1],
  [0, 0, 0, 0],
  [0, 0, 0, 0],
  [0, 0, 0, 0],
  [0, 0, 0, 0]
]
dp = [
  [0, 0, 0, 0],
  [0, 1, 1, 1],
  [0, 1, 1, 1],
  [0, 1, 2, 2],
  [0, 1, 2, 2],
  [0, 1, 2, 3]
]
*/