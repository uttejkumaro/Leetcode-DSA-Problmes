//t.c:O(nlogn)
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];//middle element is the element which is present more than n/2
        
    }
}