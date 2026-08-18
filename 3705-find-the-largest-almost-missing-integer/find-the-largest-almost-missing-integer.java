class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        int[] f = new int[51];

        for (int x : nums)
            f[x]++;

        if (k == 1) {
            int ans = -1;
            for (int x : nums)
                if (f[x] == 1)
                    ans = Math.max(ans, x);
            return ans;
        }

        if (k == n) {
            int ans = 0;
            for (int x : nums)
                ans = Math.max(ans, x);
            return ans;
        }

        int a = f[nums[0]] == 1 ? nums[0] : -1;
        int b = f[nums[n - 1]] == 1 ? nums[n - 1] : -1;

        return Math.max(a, b);
    }
}