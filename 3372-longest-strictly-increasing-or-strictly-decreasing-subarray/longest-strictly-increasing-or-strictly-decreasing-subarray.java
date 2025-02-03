class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int increaseCount=1,decreaseCount=1,maxlen=1;
        int n=nums.length;
        for(int i=0;i<n-1;i++){
            if(nums[i]<nums[i+1]){
                increaseCount++;
                decreaseCount=1;

            }
            else if(nums[i]>nums[i+1]){
                decreaseCount++;
                increaseCount=1;
            }
            else{
                increaseCount=1;
                decreaseCount=1;
            }
        maxlen=Math.max(maxlen,Math.max(increaseCount,decreaseCount));
        }
        return maxlen;
        
        
    }
}