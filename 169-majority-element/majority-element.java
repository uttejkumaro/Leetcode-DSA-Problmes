/*
//t.c:O(nlogn)
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];//middle element is the element which is present more than n/2
        
    }
}
*/
class Solution{
    public int  majorityElement(int[] nums) {
        int c=0;
        int v=0;
        for(int num:nums){
            if(v==0){
                c=num;
            }
            if(c==num){
                v++;
            }
            else{
            v--;}
        }
        return c;
    }

}