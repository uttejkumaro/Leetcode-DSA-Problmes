class Solution {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int idx=-1;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                idx=i;
                break;
                
            }
        }
        if(idx==-1) {
            reverse(nums,0,n-1);
            return;
        }
        //swap n-2 with i
        for(int i=n-1;i>idx;i--){
            if(nums[i]>nums[idx]){
                int temp=nums[i];
                nums[i]=nums[idx];
                nums[idx]=temp;
                break;
            }
        }
        reverse(nums,idx+1,n-1);
        
    }
    void reverse(int nums[],int st,int end){
        while(st<end){
            int temp=nums[st];
            nums[st]=nums[end];
            nums[end]=temp;
            st++;
            end--;
        }
    }
}