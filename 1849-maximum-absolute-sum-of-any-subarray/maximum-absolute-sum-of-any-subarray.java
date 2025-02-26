// class Solution {
//     public int maxAbsoluteSum(int[] nums) {
//         int n=nums.length;
//         int max=0;
//         for(int i=0;i<n;i++){
//             int sum=0;
//             for(int j=i;j<n;j++){
//                 sum+=nums[j];
//             max=Math.max(max,Math.abs(sum));
//             }
//         }
//         return max;
//     }
// }
class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n=nums.length;
       int maxSum = 0, minSum = 0, maxEnding = 0, minEnding = 0;
        for(int num:nums){
            maxEnding=Math.max(num,maxEnding+num);
            maxSum=Math.max(maxSum,maxEnding);
            minEnding=Math.min(num,minEnding+num);
            minSum=Math.min(minSum,minEnding); 
           

        }
                return Math.max(maxSum,Math.abs(minSum));
    }
}
