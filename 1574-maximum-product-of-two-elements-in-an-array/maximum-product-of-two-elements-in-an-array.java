// class Solution {
//     public int maxProduct(int[] nums) {
//         int n=nums.length;
//         int max=0;
//         for(int i=0;i<n;i++){
//             for(int j=0;j<n;j++){
//                 if(i!=j)
//                 max=Math.max(max,(nums[i]-1)*(nums[j]-1));
//             }
//         }
//         return max;
//     }
// }
class Solution {
        public int maxProduct(int[] nums) {
            int n=nums.length;
            int max1=0;
            int max2=0;
            for(int i=0;i<n;i++){
                if(nums[i]>=max1){
                    max2=max1;
                    max1=nums[i];
                }
                else if(nums[i]>max2)max2=nums[i];
            }
            return (max1-1)*(max2-1);
    }
}