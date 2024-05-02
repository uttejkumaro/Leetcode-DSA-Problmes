class Solution {
    public int findMaxK(int[] nums) {
        Arrays.sort(nums);
        int ans=-1;
        int low=0;
        int high= nums.length-1;
        while(low<high){

            int sum= nums[low]+nums[high];
            if(sum==0){
                ans= nums[high];
                break;
            }else if (sum<0){
                low++;
            }else{
                high--;
            }
        }
        return ans;
    }
}