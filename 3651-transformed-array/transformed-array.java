class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n=nums.length;
        int[] res=new int[n];
        for(int i=0;i<n;i++){
            if(nums[i]>=0){
                res[i]=nums[(nums[i]+i)%n];
            }
          
            else{
                  res[i] = nums[((i + nums[i]) % n + n) % n];
            }


        }
        return res;
    }
}