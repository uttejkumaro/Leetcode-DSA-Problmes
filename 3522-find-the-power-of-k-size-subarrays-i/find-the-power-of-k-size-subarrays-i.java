class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n= nums.length;
        int[] arr = new int[n-k+1];
        for(int i =0;i<n-k+1;i++){
            int max=nums[i];
            int flag=0;
            for(int j=i+1;j<i+k;j++){
                max=Math.max(max,nums[j]);
                if(nums[j]!=nums[j-1]+1){
                    flag=1;
                    break;
                }
            }
            arr[i]=(flag==0)?max:-1;
        }
        return arr;
        
    }
}