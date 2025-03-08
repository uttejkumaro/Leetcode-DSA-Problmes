class Solution {
    public int minOperations(int[] nums, int[] numsDivide) {
        Arrays.sort(nums);
        int div=numsDivide[0];
        for(int num:numsDivide){
            div=gcd(div,num);
        };
        
        for(int i=0;i<nums.length;i++){
            if(div%nums[i]==0){
               return i;

            }
        }
        return -1;

        
    }
    int gcd(int a,int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
}
/**
Since nums is sorted, the smallest valid divisor appears earliest.
Deleting all previous elements (i elements) ensures nums[i] is now the smallest and valid. */