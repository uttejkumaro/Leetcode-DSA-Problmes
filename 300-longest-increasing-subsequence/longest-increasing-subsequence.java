class Solution {
    public int lengthOfLIS(int[] nums) {
        //memo
        int []dp=new int[nums.length];
        //first pointer
        for(int i=1;i<nums.length;i++){
            //second pointer
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    if(dp[j]+1>dp[i]){
                        dp[i]=dp[j]+1;
                    }
                }
            }
            
        }
        int maxidx=0;
        for(int i=0;i<dp.length;i++){
            if(dp[i]>dp[maxidx]){
                maxidx=i;
            }
        }
        return dp[maxidx]+1;
        
    }
}