class Solution {
    public int findGCD(int[] nums) {
        int max=nums[0],min=nums[0];
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max) max=nums[i];
            if(nums[i]<min) min=nums[i];
        }
        return gcd(min,max);
        
    }
    int gcd(int a,int b){
        if(a==0) return b;
        else{
            return gcd(b%a,a);
        }
    }
}