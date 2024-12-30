// class Solution {
//     public boolean search(int[] nums, int target) {
//         for(int i=0;i<nums.length;i++){
//             if(nums[i]==target){
//                 return true;
//             }
//         }
//         return false;
//     }
// }
class Solution {
   public boolean search(int[] nums, int target) {
    int low=0,high=nums.length-1;
    while(low<=high){
        int mid=low+(high-low)/2;
        if(nums[mid]==target) return true;
        //duplicates hanle
        if(nums[low]==nums[mid] && nums[mid]==nums[high]){
            low++;
            high--;
            continue;
        }
        if(nums[low]<=nums[mid]){// Left half is sorted
            if(nums[low]<=target && target<=nums[mid]) high=mid-1;
            else low=mid+1;
        }
            else {
                if(nums[mid]<=target && target<=nums[high]) low=mid+1;
                else high=mid-1;
            }
        }

    
    return false;
    

   
   }
}