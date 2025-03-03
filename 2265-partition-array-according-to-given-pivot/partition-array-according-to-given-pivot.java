// class Solution {
//     public int[] pivotArray(int[] nums, int pivot) {
//         // int n=nums.length;
//         // int[] res=new int[n];
//        ArrayList<Integer>before=new ArrayList<>();
//        ArrayList<Integer>equal=new ArrayList<>();
//        ArrayList<Integer>after=new ArrayList<>();
//        for(int i:nums){
//         if(i<pivot) before.add(i);
//         else if(i>pivot)after.add(i);
//         else equal.add(i);
//        }
//        int idx=0;
//        for(int i:before){
//         nums[idx++]=i;
//        }
//        for(int i:equal){
//         nums[idx++]=i;
//        }for(int i:after){
//         nums[idx++]=i;
//        }
//         return nums;
      
        
//     }
// }
class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n=nums.length;
        int[] res=new int[n];
        int idx=0;
        for(int i=0;i<n;i++){
            if(nums[i]<pivot) res[idx++]=nums[i];            
        }
        for(int i=0;i<n;i++){
            if(nums[i]==pivot) res[idx++]=nums[i];            
        }
        for(int i=0;i<n;i++){
            if(nums[i]>pivot) res[idx++]=nums[i];            
        }
        return res;
    }
}