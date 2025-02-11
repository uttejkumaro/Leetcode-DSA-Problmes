class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int mod=(int)Math.pow(10,9)+7;
        int dp[]=new int[high+1];
        dp[0]=1;
        for(int i=1;i<=high;i++){
            if(i>=zero){
                dp[i]=(dp[i]+dp[i-zero])%mod;
            }
            if(i>=one){
                dp[i]=(dp[i]+dp[i-one])%mod;
            }
        }
        int res=0;
        for(int i=low;i<=high;i++){
            res=(res+dp[i])%mod;

        }
        return res;
        
    }
}