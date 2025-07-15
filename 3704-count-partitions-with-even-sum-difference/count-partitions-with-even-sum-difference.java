class Solution {
    public int countPartitions(int[] nums) {
         int n = nums.length;
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int count = 0;
        int prefixSum = 0;
        for (int i = 0; i < n - 1; i++) {
            prefixSum += nums[i];
            int suffixSum = totalSum - prefixSum;
            if ((prefixSum % 2) == (suffixSum % 2)) {
                count++;
            }
        }

        return count;
    }
}