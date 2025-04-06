class Solution {
    int helper(int arr[],int k,int i,int dp[]){
        int n=arr.length;
        if(i==n) return 0;
        if(dp[i]!=-1) return dp[i];
        int len=0;
        int maxAns=0;
        int max=0;
        for(int j=i;j<Math.min(i+k,n);j++){
            len++;
            max=Math.max(max,arr[j]);
            int sum=len*max+helper(arr,k,j+1,dp);
            maxAns=Math.max(sum,maxAns);
        }
         return dp[i]=maxAns;

    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n=arr.length;
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        return helper(arr,k,0,dp);
        
    }
}