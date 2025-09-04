class Solution {
   boolean canSplit(int mid, int k, int nums[]) {
    int count = 1;        // start with one subarray
    int currentSum = 0;   // sum of the current subarray

    for (int num : nums) {
        // if adding this num exceeds mid, cut here
        if (currentSum + num > mid) {
            count++;          // we need a new subarray
            currentSum = 0;   // reset sum
        }
        currentSum += num;    // add current element

        if (count > k) return false; // too many subarrays
    }

    return true; // we managed with <= k subarrays
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