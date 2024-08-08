// //memozation
// class Solution {
//     private  boolean canPartition(int nums[],int target,int index,Boolean memo[][]){
//         if(target==0){
//             return  true;
//         }
//         if(index<0 ||target<0){
//             return false;
//         }
//         if(memo[index][target]!=null){
//             return memo[index][target];
//         }
//         boolean include = canPartition(nums,target-nums[index],index-1,memo);
//         boolean exclude = canPartition(nums,target,index-1,memo);
//         memo[index][target]=include || exclude;
//         return memo[index][target];


//     }
//     public boolean canPartition(int[] nums) {
//         int n=nums.length;
//         int sum=0;
//         for(int i:nums){
//             sum+=i;
//         }
//         if(sum%2!=0){
//             return false;
//         }
//         int target=sum/2;
//         Boolean memo[][]=new Boolean[nums.length][target+1];;
//         return canPartition(nums,target,nums.length-1,memo); 
        
//     }
// }
 //tabulation
class Solution {
   
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int i:nums){
            sum+=i;
        }
        if(sum%2!=0){
            return false;
        }
        int target=sum/2;
        boolean dp[][]=new boolean[nums.length+1][target+1];;
        for(int i=0;i<nums.length;i++){
            dp[i][0]=true;
        }
        for(int i=1;i<=nums.length;i++){
            for(int j=1;j<=target;j++){
                if(nums[i-1]<=j){
                    dp[i][j]=dp[i-1][j] || dp[i-1][j-nums[i-1]];
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[nums.length][target];
    }
}