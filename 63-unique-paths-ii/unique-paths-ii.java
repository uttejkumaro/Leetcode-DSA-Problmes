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