class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1){
            return nums[0];
            }
        if(n==2){
            return Math.max(nums[0],nums[1]);
        }
        return Math.max(robMax(nums,1,n-1),robMax(nums,0,n-2));             
    }
    int robMax(int nums[],int start,int end){
        if(start==end){
            return nums[start];
        }
        int dp[]=new int[end-start+1];
        dp[0]=nums[start];
        dp[1]=Math.max(nums[start],nums[1+start]);
        for(int i=2;i<dp.length;i++){
            dp[i]=Math.max(nums[i+start]+dp[i-2],dp[i-1]);
        }
        return dp[dp.length-1];

    }
}