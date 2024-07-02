
class Solution {
    public int maxSubArray(int[] nums) {
        //kadanes algo is sum<o then sum=0;
        int maxi=nums[0],sum=0;
        for(int i=0;i<nums.length;i++){
            sum=sum+nums[i];
            //max=math.max(sum,maxi)
            if(sum>maxi){
                maxi=sum;
            }
            if(sum<0){
                sum=0;
            }
        }
        return maxi;      
        
    }
}