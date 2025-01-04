// class Solution {
//     public int findPeakElement(int[] nums) {
//         int n=nums.length;

//         for(int i=1;i<n-1;i++){
//             if(nums[i]<nums[i-1] && nums[i]>nums[i+1]){
//                 return nums[i];
//             }
//         }
//         return  nums[i];
        
//     }
// }
class Solution{
    public int findPeakElement(int[] nums) {
        int n=nums.length;
        if(n==1) return 0;
        if(nums[0]>nums[1]) return 0;
        if(nums[n-1]>nums[n-2]) return n-1;
        int mid=0,low=1,high=n-2;
        while(low<=high){
            mid=low+(high-low)/2;
            if(nums[mid]>nums[mid+1] && nums[mid]>nums[mid-1]) return  mid;
            else if(nums[mid]>nums[mid-1]){
                //peak will be in left 
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return -1;
    }

}
//class Solution {
//     public int findPeakElement(int[] nums) {
//         int start = 0;
//         int end = nums.length - 1;
//         while(start < end){
//             int mid = start + (end-start)/2;
//             if(nums[mid]<nums[mid+1]){
//                 start = mid+1;
//             }else{
//                 end = mid;
//             }
//         }
//         return start;
//     }
// }