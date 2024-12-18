
//t.c:O(nlogn)
// class Solution {
//     public int majorityElement(int[] nums) {
//         Arrays.sort(nums);
//         return nums[nums.length/2];//middle element is the element which is present more than n/2
        
//     }
// }

class Solution{
    public int  majorityElement(int[] nums) {
        int n=nums.length;
        int c=0;
        int v=0;
        for(int num:nums){
            if(c==0) v=num;
            c+=(v==num)?1:-1;

            
        }
        c=0;
        for(int num:nums){
            if(v==num) c++;
        }
        return (c>=n/2)?v:-1;
    }

}