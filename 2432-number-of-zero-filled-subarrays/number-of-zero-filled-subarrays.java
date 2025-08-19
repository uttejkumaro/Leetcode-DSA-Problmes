class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long count=0;
        long curr=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                curr++;
                count+=curr;
            }
            else curr=0;
        }
        return count;
    }
}