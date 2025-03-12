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
class Solution{
    public int rob(int nums[]){
        int n=nums.length;
        if(n==1) return nums[0];
        int dp[]=new int[n+1];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0], nums[1]);
        for(int i=2;i<n;i++){
            dp[i]=Math.max(dp[i-1],nums[i]+dp[i-2]);
        }
        return dp[n-1];
    }
}