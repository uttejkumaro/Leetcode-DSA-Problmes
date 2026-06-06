// class Solution {
//     public int[] leftRightDifference(int[] nums) {
//         int n=nums.length;
//         int res[]=new int[n];
//         int left[]=new int[n];
//         int right[]=new int[n];
//         int leftsum=0;
//         int rightsum=0;
//         for(int i=0;i<n;i++){
//             left[i]=leftsum;
//             leftsum+=nums[i];
//         }
//         for(int i=n-1;i>=0;i--){
//             right[i]=rightsum;
//             rightsum+=nums[i];
//             res[i]=Math.abs(right[i]-left[i]);
//         }
//         return res;

//     }
// }
class Solution {
    public int[] leftRightDifference(int[] nums) {
        int leftSum = 0;
        int rightSum = 0;
        
        // Calculate the total sum of the array first
        for (int num : nums) {
            rightSum += num;
        }
        
        int[] ans = new int[nums.length];
        
        // Compute differences on the fly
        for (int i = 0; i < nums.length; i++) {
            // Exclude the current element from the right side sum
            rightSum -= nums[i]; 
            
            // Calculate absolute difference
            ans[i] = Math.abs(leftSum - rightSum); 
            
            // Include the current element into the left side sum for the next index
            leftSum += nums[i]; 
        }
        
        return ans;
    }
}