class NumArray {
    int pref[];
    public NumArray(int[] nums) {
        int n=nums.length;
        pref =new int[n];
        pref[0]=nums[0];
        for(int row=0;row<n;row++){
            if(row>0)
            pref[row]=pref[row-1]+nums[row];
        }
    }
    
    public int sumRange(int left, int right) {
        if(left==0) return pref[right];
        return pref[right]-pref[left-1];
        
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */