class Solution {
    boolean canSplit(int mid,int k,int nums[]){
        int count=1;
        int currentSum=0;
        for(int num:nums){
            if(currentSum+num>mid){
                count++;
                currentSum=0;
            }
            currentSum+=num;
            if(count>k) return false;
           
        }
        return true;
    }
    public int splitArray(int[] nums, int k) {
        int n=nums.length;
        int sum=0,max=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            max=Math.max(max,nums[i]);
        }
        int low=max;
        int high=sum;
        int ans=sum;
        while(low<=high){
                int mid=low+(high-low)/2;
                if(canSplit(mid,k,nums)){
                    ans=mid;
                    high=mid-1;
                }
                else low=mid+1;
                
        }
        return ans;
    }
}
/**
Why it works (Greedy proof)

We always add as many elements as possible into the current subarray until exceeding mid.

Once exceeded, we cut there and start a new subarray.

This ensures minimum number of subarrays for the given mid.

If this greedy strategy requires more than k subarrays, then no other splitting will succeed with that mid.
In short:
This function checks if a given maximum allowed subarray sum (mid) is feasible with at most k splits. */