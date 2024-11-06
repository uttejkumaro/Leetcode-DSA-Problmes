class Solution {
    public int maxFrequency(int[] nums, long k) {
        int start = 0;
        Arrays.sort(nums);
        for (int end = 0; end < nums.length; ++end) {
            k += nums[end];
            if (k < (long) nums[end] * (end - start + 1))
                k -= nums[start++];
        }

        return nums.length - start;
    }
}