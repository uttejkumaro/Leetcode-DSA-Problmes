/* //memo
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid[0].length;
        int n=obstacleGrid.length;
        int dp[][]=new int [n][m];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return helper(n-1,m-1,dp,obstacleGrid);        
    }
    int helper(int i,int j,int dp[][],int obstacleGrid[][]){
        if(i<0 || j<0 )return 0;
        if(i>=0 &&  j>=0 && obstacleGrid[i][j]==1 )return 0;
         if(i==0 &&  j==0 )return 1;
        if(dp[i][j] !=-1)  return dp[i][j]; //memozation 
        int left=helper( i,j-1, dp,obstacleGrid);
        int up=helper( i-1,j, dp, obstacleGrid);
        return dp[i][j]=left+up;       
    }
}
*/
/* 
// tabulation
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid[0].length;
        int n = obstacleGrid.length;
        int dp[][] = new int[n][m];
        
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        return helper(n, m, dp, obstacleGrid);        
    }
    
    int helper(int n, int m, int dp[][], int obstacleGrid[][]) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else {
                    int up = 0, left = 0;
                    if (i > 0) {
                        up = dp[i-1][j];
                    }
                    if (j > 0) {
                        left = dp[i][j-1];
                    }
                    dp[i][j] = up + left;
                }
            }
        }  
        return dp[n-1][m-1];    
    }
}
*/
//space optimisation
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[] prev = new int[m];
        
        for (int i = 0; i < n; i++) {
            int[] curr = new int[m];
            for (int j = 0; j < m; j++) {
                if (obstacleGrid[i][j] == 1) {
                    curr[j] = 0;
                } else if (i == 0 && j == 0) {
                    curr[j] = 1;
                } else {
                    int up = 0, left = 0;
                    if (i > 0) {
                        up = prev[j];
                    }
                    if (j > 0) {
                        left = curr[j - 1];
                    }
                    curr[j] = up + left;
                }
            }
            prev = curr;
        }   
        
        return prev[m - 1];     
    }
}
