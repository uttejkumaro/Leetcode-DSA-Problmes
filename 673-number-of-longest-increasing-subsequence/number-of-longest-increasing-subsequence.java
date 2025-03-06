//we can slove useing dp-O(n^2) or else we can also slove usng segment ree or fenwick tree(binary indexed tree)
//dp-variation of lis
class Solution {
    public int findNumberOfLIS(int[] nums) {
        int res=0;
        int n=nums.length;
        int dp[]=new int[n];
        int count[]=new int[n];
        int maxLen=1;
        Arrays.fill(dp,1);
        Arrays.fill(count,1);
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    if(dp[j]+1>dp[i]){
                        dp[i]=dp[j]+1;
                        // System.out.print("dp[i] ->"+dp[i]);
                        count[i]=count[j];
                    }
                    else if(dp[j]+1==dp[i])
                    count[i]+=count[j];
                }
            }
        maxLen=Math.max(maxLen,dp[i]);
        }
          for (int i=0;i<n;i++) {
            if (dp[i]==maxLen) {
                res += count[i];
            }
        }
        return res;   
    }
}