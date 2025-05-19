class Solution {
    int helper(int prices[],int n,int idx,int buy,int cap,int dp[][][]){
        
        if(idx==n || cap==0) return 0;
        int profit=0;
        if(dp[idx][buy][cap]!=-1) return dp[idx][buy][cap];
        if(buy==0) {
                profit=Math.max(-prices[idx]+helper(prices,n,idx+1,1,cap,dp),
                                    0+helper(prices,n,idx+1,0,cap,dp));
        }
        if(buy==1) {
                profit=Math.max(prices[idx]+helper(prices,n,idx+1,0,cap-1,dp),
                                    0+helper(prices,n,idx+1,1,cap,dp));
        }
        return dp[idx][buy][cap]=profit;
    }
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int dp[][][]=new int[n][2][k+1];
        for (int[][] matrix : dp) {
        for (int[] row : matrix) {
            Arrays.fill(row, -1);
            }
        }

        return helper(prices,n,0,0,k,dp);
        
    }
}