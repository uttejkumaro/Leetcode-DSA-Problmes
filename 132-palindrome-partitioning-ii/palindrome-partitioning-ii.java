class Solution {
    boolean ispali(int i, int j, String s) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
            return false;
            }
        }
        return true;
    }

    int helper(int i, int n, String s,int dp[]) {
        if (i == n)
            return 0;
            if(dp[i]!=-1) return dp[i];
        int min = (int) 1e9;
        for (int j = i; j < n; j++) {
            if (ispali(i, j, s)) {
                int cost = 1 + helper(j + 1, n, s,dp);
                min = Math.min(min, cost);
            }
        }
        return dp[i]=min;
    }

    public int minCut(String s) {
        int n = s.length();
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        return helper(0, n, s,dp) - 1;//we will subtact 1 because it is ocndsderng end also particinong e.g ab as we req 1 it gives 2 afret b also it add 1 partinone 

    }
}