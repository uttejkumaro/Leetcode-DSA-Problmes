class Solution {
    public int longestPalindromeSubseq(String s) {
        String s2=new StringBuilder(s).reverse().toString();
        return lcs(s,s2);
    }
    int lcs(String s,String s1){
        int n=s.length();
        int m=s1.length();
        final int dp[][]=new int [n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1)==s1.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
            }
        }
        return dp[n][m];
    }
}