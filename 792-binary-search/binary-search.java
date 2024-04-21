class Solution {
    public int search(int[] nums, int target) {
        int high,low,mid;
        high=nums.length-1;
        low=0;
       
        while(low<=high){
             mid=low+(high-low)/2;
            if (nums[mid]==target){
                return mid ;
            }
            else if(nums[mid] < target){
                   low=mid+1;
                }
             else{
                    high=mid-1;
                  
                }
               
            
            
        }
        return -1; 
    }
}