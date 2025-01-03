class Solution {
    public int waysToSplitArray(int[] nums) {
        long n=nums.length;
        long sum=0;
        for(int i:nums){
            sum+=i;
        }
        long remSum=sum;
       long  lsum=0;
       
       long split=0;
        for(int i=0;i<n-1;i++){
            lsum+=nums[i];
            remSum=remSum-nums[i];
            //long currSum=lsum+nums[i];
            if(lsum>=remSum){
                split++;
            }


        }
        return (int)split;


        
    }
}