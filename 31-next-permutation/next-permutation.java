class Solution {
    public void nextPermutation(int[] nums) {
        int idx=-1;
        int n=nums.length;
        for(int i=n-1;i>=1;i--){
            if(nums[i]>nums[i-1]){
                idx=i-1;
                break;
            }
        }
        if(idx==-1){
            int i=0,j=n-1;
            while(i<j){
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                i++;
                j--;
            }
            return;
        }
        else{
            for(int i=n-1;i>idx;i--){
                if(nums[i]>nums[idx]){
                    int temp =nums[idx];
                    nums[idx]=nums[i];
                    nums[i]=temp;
                    break;

                }
            }
        }
        int i=idx+1,j=n-1;
        while(i<j){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++;
            j--;
        }
        return;
    }
}