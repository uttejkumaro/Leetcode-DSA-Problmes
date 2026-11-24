class Solution {

    public int maxLength(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            long prod = nums[i];
            long hcf = nums[i];
            long lcm = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                prod = prod * nums[j];
                hcf = gcd(hcf, nums[j]);
                lcm = (lcm * nums[j]) / gcd(lcm, nums[j]);
                if (prod > hcf * lcm) {
                    break;
                }
                if (prod == hcf * lcm) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }
        return res;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}