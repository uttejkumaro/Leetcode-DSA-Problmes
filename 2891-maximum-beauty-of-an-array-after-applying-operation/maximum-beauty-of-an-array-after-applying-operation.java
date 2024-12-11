class Solution {
    public int maximumBeauty(int[] nums, int k) {
        int count=0;
        int n=nums.length;
        Arrays.sort(nums);
        int j=0;
        
        for(int i=0;i<n;i++){
            while(j<n && nums[j]-nums[i]<=2*k){//(nums[i]+k<nums[j]-k
                j++;
            }
            count=Math.max(j-i,count);


        }
        return count;
        
    }
}