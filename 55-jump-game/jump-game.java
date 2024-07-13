class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        if (n==0)return false;
        int far=0;
        for(int i=0;i<n;i++){
            if (i >far) return false ;
            far=Math.max(far,nums[i]+i);
            if(far>=n-1){
                return true;
            }
        }
        return false;
        
    }
}