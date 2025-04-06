class Solution {
    int helper(int i,int j,int n,int dp[][],int cuts[]){
        if(i>j) return 0;
        int min=Integer.MAX_VALUE;
        if(dp[i][j]!=-1) return dp[i][j];
        for(int idx=i;idx<=j;idx++){
           int  cost=cuts[j+1]-cuts[i-1]+helper(idx+1,j,n,dp,cuts)+helper(i,idx-1,n,dp,cuts);
           min=Math.min(cost,min);
        }
        return dp[i][j]=min;
    }
    public int minCost(int n, int[] cuts) {
        int m=cuts.length;
        int newCuts[]=new int[cuts.length+2];
        newCuts[0]=0;
        newCuts[m+1]=n;
        for(int i=1;i<newCuts.length-1;i++){
            newCuts[i]=cuts[i-1];
        }
        Arrays.sort(newCuts);
        int dp[][]=new int [m+2][m+2];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }

        return helper(1,m,n,dp,newCuts);
        
    }
}