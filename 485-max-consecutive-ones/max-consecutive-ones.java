class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int currentCount = 0;
        int n = nums.length;
       for(int i=0;i<n;i++){
        if(nums[i]==1){
            currentCount++;
            maxCount=Math.max(currentCount,maxCount);

        } 
        else{
            currentCount=0;

        }
       }
        return maxCount;
       
    }
}