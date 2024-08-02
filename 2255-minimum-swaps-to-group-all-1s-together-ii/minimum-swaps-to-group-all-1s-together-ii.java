class Solution {
    public int minSwaps(int[] nums) {
        int n=nums.length;
        int total1=0;
        for(int i=0;i<n;i++){
            if(nums[i]==1) total1++;
        }
        if(total1==0 || total1==n) return 0;//0 swaps\
        int max1=0;//max 1 in wind
        int  curr1=0;
        int arr[] =new int[2*n];
        for(int i=0;i<n;i++){
            arr[i]=nums[i];
            arr[i+n]=nums[i];//for handling  circular 
        }
        for(int i=0;i<total1;i++) {
            curr1+=arr[i];
            }
        max1=curr1;
        for(int i=total1;i<2*n;i++){
            curr1+=arr[i]-arr[i-total1];
            max1=Math.max(curr1,max1);
        }
        return total1-max1;
    }
}