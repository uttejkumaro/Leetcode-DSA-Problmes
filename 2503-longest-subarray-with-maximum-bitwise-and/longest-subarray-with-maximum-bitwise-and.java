class Solution {
    public int longestSubarray(int[] nums) {
        //Arrays.sort(nums);
        
        int n=nums.length;
        if(n==1) return 1;
        int max=nums[0];
        for(int i=1;i<n;i++){
            if(nums[i]>max){
                max=nums[i];
            }
                      
        }
        //int i=0;
        int  curr=0;
        int maxlen=0;
        for(int i=0;i<n;i++){
            if(nums[i]==max) curr++;
            else curr=0;
            maxlen=Math.max(curr,maxlen);

        }
        return maxlen;
        

        
    }
}