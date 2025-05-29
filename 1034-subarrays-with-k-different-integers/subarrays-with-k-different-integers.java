class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostk(nums,k)-atMostk(nums,k-1);
    }
    int atMostk(int nums[],int k){
        Map<Integer,Integer>freq=new HashMap<>();
        int n=nums.length;
        int left=0;
        int res=0;
        for(int right=0;right<n;right++){
            freq.put(nums[right],freq.getOrDefault(nums[right],0)+1);
            if(freq.get(nums[right])==1) k--;
            while(k<0){//shirnk
            freq.put(nums[left],freq.get(nums[left])-1);
            if(freq.get(nums[left])==0)k++;
            left++;
            }
            res+=right-left+1;
        }
        return res;

    }
}