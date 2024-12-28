class Solution {
    public int[] searchRange(int[] nums, int target) {
      int left=findleft(nums,target);
      int right=findright(nums,target);
      return new int[]{left,right};
        
    }
    int findleft(int nums[],int target){
        int idx=-1;
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target) {
                idx=mid;
                right=mid-1;//for left sub array

            }
            else if(nums[mid]>target){
                right=mid-1;
            }
            else{
                left=mid+1;
            }

        }
        return idx;

    }
    //finidng right bound
    int findright(int nums[],int target){
        int idx=-1;
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target) {
                idx=mid;
                left=mid+1;//for right sub array

            }
            else if(nums[mid]>target){
                right=mid-1;
            }
            else{
                left=mid+1;
            }

        }
        return idx;

    }
}