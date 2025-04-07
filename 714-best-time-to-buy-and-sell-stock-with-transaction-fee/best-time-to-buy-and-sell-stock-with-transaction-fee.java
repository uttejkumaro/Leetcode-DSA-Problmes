class Solution {
    int helper(int prices[],int fee,int dp[][],int idx,int buy){
        //buy-0
        //after buy or sell we can subtact fee
        int n=dp.length;
        if(idx>=n) return 0;
        if(dp[idx][buy]!=-1) return dp[idx][buy];
        int profit=0;
        if(buy==0){
            profit=Math.max(-prices[idx]+helper(prices,fee,dp,idx+1,1),
                                0+helper(prices,fee,dp,idx+1,0));
        }
        else{
            profit=Math.max(prices[idx]-fee+helper(prices,fee,dp,idx+1,0),
                                    0+helper(prices,fee,dp,idx+1,1));
        }
        return dp[idx][buy]=profit;
    }
    public int maxProfit(int[] prices, int fee) {
        int n=prices.length;
        int dp[][]=new int[n][2];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return helper(prices,fee,dp,0,0);
        
    }
}