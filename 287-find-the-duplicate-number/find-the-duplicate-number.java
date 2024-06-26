/* class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(nums[i]==nums[i+1]){
                return nums[i];
            }
        }
        return -1;
        
    }
} */
class Solution {
    public int findDuplicate(int[] nums) {
        HashSet<Integer>set=new HashSet<>();
        for(int i:nums){
            if(set.contains(i)){
                return i;
            }
            set.add(i);
        }
        return -1;
    }
}