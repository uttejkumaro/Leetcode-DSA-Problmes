class Solution {
    public int maxAscendingSum(int[] nums) {
        int n=nums.length;
        int sum=nums[0];
        int maxSum=sum;
        for(int i=1;i<n;i++){
            if(nums[i]>nums[i-1]){
                sum+=nums[i];
            }
            else{
                maxSum=Math.max(sum,maxSum);
                sum=nums[i];
            }
        }
        return Math.max(maxSum,sum);
        
    }
}