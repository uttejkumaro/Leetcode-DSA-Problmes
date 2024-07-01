// xor will give 0 for identical nums .so the approch is xor all nums and distict will be return 
class Solution {
    public int singleNumber(int[] nums) {
        int res=nums[0];
        for(int i=1;i<nums.length;i++){
            res=res^nums[i];

        }
        return res;
    }
}