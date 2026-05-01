// class Solution {
//     public int maxRotateFunction(int[] nums) {
//         int n = nums.length;
//         int max = Integer.MIN_VALUE;

//         for (int k = 0; k < n; k++) {
//             int sum = 0;
//             for (int i = 0; i < n; i++) {
//                 int idx = (i - k + n) % n; // rotated index
//                 sum += i * nums[idx];
//             }
//             max = Math.max(max, sum);
//         }

//         return max;
//     }
// }
class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;

        int sum = 0;
        int f0 = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            f0 += i * nums[i];
        }

        int max = f0;
        int curr = f0;

        for (int k = 1; k < n; k++) {
            curr = curr + sum - n * nums[n - k];
            max = Math.max(max, curr);
        }

        return max;
    }
}