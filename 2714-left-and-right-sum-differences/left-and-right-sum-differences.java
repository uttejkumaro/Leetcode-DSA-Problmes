class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n=nums.length;
        int res[]=new int[n];
        int left[]=new int[n];
        int right[]=new int[n];
        int leftsum=0;
        int rightsum=0;
        for(int i=0;i<n;i++){
            left[i]=leftsum;
            leftsum+=nums[i];
        }
        for(int i=n-1;i>=0;i--){
            right[i]=rightsum;
            rightsum+=nums[i];
            res[i]=Math.abs(right[i]-left[i]);
        }
        return res;

    }
}