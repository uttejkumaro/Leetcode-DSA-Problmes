class Solution {
    public int lengthOfLIS(int[] nums) {
       int n=nums.length;
       int memo[][]=new int[n][n+1];
       for(int []row:memo){
        Arrays.fill(row,-1);
       }
       return helper(0,-1,n,nums,memo);
    }
    int helper(int idx,int prevIdx,int n,int nums[],int memo[][]){
        if(idx==n) return 0;
        int prev=prevIdx+1;//-1 is inavlid indexing
        if(memo[idx][prev]!=-1) return memo[idx][prev];
        int exclude=helper(idx+1,prevIdx,n,nums,memo);
        int include=0;
        int result=0;
        if(prevIdx==-1 || nums[idx]>nums[prevIdx]){
            include=1+helper(idx+1,idx,n,nums,memo);
        }
            result= Math.max(include,exclude);
            return memo[idx][prev]=result;
    }
}
//memo
/*
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
*/
/*
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int maxLength = 0;
        
        for (int i = 0; i < nums.length; i++) {
            int maxVal = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxVal = Math.max(maxVal, dp[j] + 1);
                }
            }
            dp[i] = maxVal;
            maxLength = Math.max(maxLength, dp[i]);
        }
        
        return maxLength;
    }
}
*/