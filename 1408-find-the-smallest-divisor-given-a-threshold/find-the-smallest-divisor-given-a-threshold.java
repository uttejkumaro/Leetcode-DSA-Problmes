class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int max=0;
        for(int i:nums)max=Math.max(i,max);
       
        int min=1,maxi=max;
        int ans=maxi;
        while(min<=maxi){
            int mid=min+(maxi-min)/2;
            if(divide(mid,threshold,nums)){
                ans=mid;
                maxi=mid-1;
            }
            else min=mid+1;
        }
        return min;     
    }
    boolean divide(int mid,int threshold,int[] nums){
        int sum=0;
       for(int i=0;i<nums.length;i++){
        sum+=(int)Math.ceil((double)nums[i]/mid);
       }
       return sum<=threshold;

    }
}