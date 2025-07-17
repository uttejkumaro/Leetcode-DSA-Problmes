class Solution {
    public int cherryPickup(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int dp[][][]=new int[n][m][m];
        for(int  row[][]:dp){
            for(int d[]:row){
                Arrays.fill(d,-1);
            }
        }
        return helper(grid,n,m,0,0,m-1,dp);
    }
    int helper(int[][] grid,int n,int m,int i ,int j1,int j2,int[][][]dp){
            if(j1<0 || j2<0|| j1>=m || j2>=m) return (int)-1e9;
            if(i==n-1) {
                if(j1==j2) return grid[i][j1];
                else return grid[i][j1]+grid[i][j2];
            }
            if(dp[i][j1][j2]!=-1) return dp[i][j1][j2];
            int maxi=Integer.MIN_VALUE;
            for(int d=-1;d<=1;d++){
                for(int j=-1;j<=1;j++){
                    int ans=0;
                    if(j1==j2){
                        ans=grid[i][j1]+helper(grid,n,m,i+1,j1+d,j2+j,dp);
                    }
                    else {
                        ans=grid[i][j1]+grid[i][j2]+helper(grid,n,m,i+1,j1+d,j2+j,dp);

                    }
                        maxi=Math.max(maxi,ans);
                }
            }
            return dp[i][j1][j2]=maxi;
    }
}