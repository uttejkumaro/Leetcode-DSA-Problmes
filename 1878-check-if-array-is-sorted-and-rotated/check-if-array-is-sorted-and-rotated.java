class Solution {
    public boolean check(int[] nums) {
        int count=0;
        for(int i=1; i<nums.length; i++){
            if(nums[i-1]>nums[i]){
                count++;//only one element satissfies whwere it is broken
            }
        }
        if(nums[nums.length-1]>nums[0]){
            count++;//fora sortd array
        }
        if(count>1){
            return false;
        }
        return true;
    }
}