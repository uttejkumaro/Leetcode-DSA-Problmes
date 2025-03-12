/*class Solution {
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
*/
// class Solution {
//     public int rob(int[] nums) {
//         int n=nums.length;
//         if(n==1){
//             return nums[0];
//             }
//               int lSkip[]=new int [n];//last house
//               int fSkip[]=new int [n];//first house
//             for(int i=0;i<n-1;i++){
//                  lSkip[i]=nums[i];
//                  fSkip[i]=nums[i+1];
//             }
//             int lootLskip=helper(lSkip);
//             int lootFskip=helper(fSkip);
//             return Math.max(lootLskip,lootFskip);
            
//     }
//       public int helper(int[] nums) {
//         int n=nums.length;
//         if(n==1){
//             return nums[0];
//         }
//         int []dp=new int[n];
//         //memoize firts two values
//         dp[0]=nums[0];
//         dp[1]=Math.max(nums[0],nums[1]);
//         for(int i=2;i<n;i++){
//             dp[i]=Math.max(nums[i]+dp[i-2],dp[i-1]);//imp logic

//         }
//         return dp[n-1];
        
//     }


// }
class Solution{
    int rob(int nums[]){
        int n=nums.length;
        if(n==1) return nums[0];
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        int includeFirstHome=helper(nums,n-1,dp,0);
        Arrays.fill(dp,-1);
        int excludeFirstHome=helper(nums,n,dp,1);
        return Math.max(includeFirstHome,excludeFirstHome);
    }
    int helper(int nums[],int n,int dp[],int i){
        if(i>=n) return 0;
        if(dp[i]!=-1) return dp[i];
        int stealCurrentHouse=helper(nums,n,dp,i+2)+nums[i];
        int skipCurrentHouse=helper(nums,n,dp,i+1);
        return dp[i]=Math.max(stealCurrentHouse,skipCurrentHouse);

    }
}