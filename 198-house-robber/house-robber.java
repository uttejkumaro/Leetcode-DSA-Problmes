//nl 

// O(n),o(n)

// class Solution {
//     public int rob(int[] nums) {
//         int n = nums.length;
//         if (n == 1) {
//             return nums[0];
//         }
//         int prev2 = nums[0];
//         int prev1 = Math.max(nums[0], nums[1]);
//         for (int i = 2; i < n; i++) {
//             int curr = Math.max(nums[i] + prev2, prev1);
//             prev2 = prev1;
//             prev1 = curr;
//         }
//         return prev1;
//     }
// }
// class Solution{
//     public int rob(int nums[]){
//         int n=nums.length;
//         if(n==1) return nums[0];
//         int dp[]=new int[n+1];
//         dp[0]=nums[0];
//         dp[1]=Math.max(nums[0], nums[1]);
//         for(int i=2;i<n;i++){
//             dp[i]=Math.max(dp[i-1],nums[i]+dp[i-2]);
//         }
//         return dp[n-1];
//     }
// }
class Solution{
    public int rob(int nums[]){
        int n=nums.length;
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        return helper(nums,n-1,dp);
    }
    int helper(int nums[],int n,int dp[]){
        if(n<0) return 0;
        if(dp[n]!=-1) return dp[n];
        int skip=helper(nums,n-1,dp);
        int include=helper(nums,n-2,dp)+nums[n];
        dp[n]=Math.max(skip,include);
        return dp[n];

        
    }
}
