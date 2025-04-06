class Solution {
    int helper(int i,int j,int nums[],int dp[][]){
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int max=0;
        for(int k=i;k<=j;k++){
            int cost=nums[i-1]*nums[k]*nums[j+1]+helper(i,k-1,nums,dp)+helper(k+1,j,nums,dp);
            max=Math.max(max,cost);
        }
        return dp[i][j]=max;

    }
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int balloons[]=new int[n+2];
        balloons[0]=1;
        balloons[n+1]=1;
        for(int i=1;i<=n;i++){
            balloons[i]=nums[i-1];

        }
        int dp[][]=new int[n+2][n+2];
        for(int row[]:dp) Arrays.fill(row,-1);
        return helper(1,n,balloons,dp);
        
    }
}