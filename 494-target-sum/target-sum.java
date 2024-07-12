// same like subset sum
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
        if(Math.abs(target)>sum ||  (sum+target)%2!=0){
            return 0;
        }
        int subsum=(sum+target)/2;
        int  dp[] =new int[subsum+1];
        dp[0]=1;
        for(int num:nums){
            for(int j=subsum;j>=num;j--){
                dp[j]+=dp[j-num];
            }
        }


        return dp[subsum];
    }
}