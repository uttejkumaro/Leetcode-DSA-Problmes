class Solution {
    int min(int[] nums){
        int min=Integer.MAX_VALUE;
        for(int i =0;i<nums.length;i++){
            min=Math.min(min,nums[i]);
        }
        return min;
    }
    int max(int[] nums){
        int max=Integer.MIN_VALUE;
        for(int i =0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
        }
        return max;
    }
    public int maxDotProduct(int[] nums1, int[] nums2) {
        //one neg and other pos
            if(min(nums1)>0 && max(nums2)<0) return min(nums1)* max(nums2);
        if(min(nums2)>0 && max(nums1)<0) return min(nums2)* max(nums1);
        int n=nums1.length;
        int m=nums2.length;
        int dp[][]=new int[n+1][m+1];
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                int current=nums1[i]*nums2[j]+dp[i+1][j+1];
                dp[i][j]=Math.max(current,Math.max(dp[i][j+1],dp[i+1][j]));
            }
        }
        return dp[0][0];
    }
}