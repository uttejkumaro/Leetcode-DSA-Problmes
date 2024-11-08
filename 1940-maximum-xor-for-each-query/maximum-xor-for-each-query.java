class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int []res=new int[nums.length];
        int max=(int)Math.pow(2,maximumBit)-1;
        int xor=0;
        for(int i=0;i<nums.length;i++){
            xor^=nums[i];
        }
        for(int i=0;i<nums.length;i++){
            res[i]=xor^max;
            xor=xor^nums[nums.length-i-1];
        }
        return res;        
    }
}