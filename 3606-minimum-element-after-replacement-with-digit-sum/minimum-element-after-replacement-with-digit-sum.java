// class Solution {
//     public int minElement(int[] nums) {
//         int n=nums.length;
//         int res[]=new int[n];
//         for(int i=0;i<n;i++){
//             res[i]=sumOfDigits(nums[i]);
//         }
//         int min=Integer.MAX_VALUE;
//          for(int i=0;i<n;i++){
//             min=Math.min(min,res[i]);
//         }
//         return min;
//     } 
//     int sumOfDigits(int num){
//         int sum=0;
//         while(num>0){
//             sum+=num%10;
//             num/=10;
//         }
//         return sum;
//     }
// }
class Solution {
    public int minElement(int[] nums) {

        int min = Integer.MAX_VALUE;

        for(int num : nums) {

            int sum = 0;

            while(num > 0) {

                int rem = num % 10;
                sum = sum + rem;
                num = num / 10;
            }

            min = Math.min(sum, min);
        }

        return min;
    }
}