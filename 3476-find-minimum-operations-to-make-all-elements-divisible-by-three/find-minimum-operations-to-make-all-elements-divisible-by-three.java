class Solution {
    public int minimumOperations(int[] nums) {
        int n=nums.length;
        int ops=0;
        for(int i:nums){
            ops+=Math.min(i%3,3-i%3);
        }
        return ops;
    }
}