class Solution {
    public int strangePrinter(String s) {
        int n=s.length();
        if(n==0) return 0;
        int dp[][]=new int[n][n];
        for(int i=n-1;i>=0;i--){
            dp[i][i]=1;
            for(int j=i+1;j<n;j++){
                dp[i][j]=dp[i+1][j]+1;
                for(int k=i+1;k<=j;k++){
                    if(s.charAt(i)==s.charAt(k)){
                        dp[i][j]=Math.min(dp[i][j],dp[i][k-1]+dp[k][j]-1);
                    }
                }
            }
        }
        return dp[0][n-1];
        
        
    }
}