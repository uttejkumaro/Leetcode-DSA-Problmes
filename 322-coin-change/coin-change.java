//greedy not work it will givw wrong ans e.g:1 6 5 9 amount=11 by greedy=9+1+1 3 wrong
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount==0){
            return 0;
        }
        int dp[]=new int[amount+1];
        for(int i=1;i<=amount;i++){
            dp[i]=Integer.MAX_VALUE;
            for(int coin:coins){
                if(coin<=i && dp[i-coin]!=Integer.MAX_VALUE){
                    dp[i]=Math.min(dp[i],1+dp[i-coin]);
                }
            }
        }
        return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];

        
    }
}