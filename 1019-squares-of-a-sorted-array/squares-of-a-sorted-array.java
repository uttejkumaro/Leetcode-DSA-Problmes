/* t.c nlogn 
class Solution {
    public int[] sortedSquares(int[] nums) {
        for (int i=0;i<nums.length;i++){
            nums[i]=nums[i]*nums[i];

        }
        Arrays.sort(nums);
        return nums;
}
    }*/
    class Solution {
    public int[] sortedSquares(int[] nums) {
        int n=nums.length;
        int idx=n-1;
        int right=n-1;
        int left=0;
        int []res=new int[n];
        while(left<=right){
            int leftsqr=nums[left]*nums[left];
            int rightsqr=nums[right]*nums[right];
            if(leftsqr>rightsqr){
                res[idx--]=leftsqr;
                left++;
            }
            else{
                res[idx--]=rightsqr;
                right--;
            }
        }
        return res;
        }
    }