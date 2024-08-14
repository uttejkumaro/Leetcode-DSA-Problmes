class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int low=0;
        int high=nums[nums.length-1]-nums[0];
        while(low<high){
            int mid=low+(high-low)/2;
            if(countPairs(nums,mid)>=k){
                high=mid;
            }
            else{
                low=mid+1;
            }
        }
        return low;        
    }
    int countPairs(int nums[],int target){
        int count=0,left=0;
        for(int right=0;right<nums.length;right++){
            while(nums[right]-nums[left]>target){
                left++;
            }
            count+=right-left;
        }
        return count;
    }
}