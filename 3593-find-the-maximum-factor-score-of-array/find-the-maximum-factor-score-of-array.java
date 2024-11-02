class Solution {    
    long gcd(long a, long b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }    
    
    long lcm(long a, long b) {
        return a * (b / gcd(a, b));
    }    
    
    long gcdarr(int[] nums, int exclude) {
        long result = -1;
        for (int i = 0; i < nums.length; i++) {
            if (i == exclude) continue;
            if (result == -1) result = nums[i];
            else result = gcd(result, nums[i]);
        }
        return result;
    }    
    
    long lcmarr(int[] nums, int exclude) {
        long result = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i == exclude) continue;
            result = lcm(result, nums[i]);
        }
        return result;
    }    
    
    public long maxScore(int[] nums) {
        if (nums.length == 1) return (long) nums[0] * nums[0];
        
        long ilcm = lcmarr(nums, -1);
        long igcd = gcdarr(nums, -1);
        long max = igcd * ilcm;
        
        for (int i = 0; i < nums.length; i++) {
            long gcd = gcdarr(nums, i);
            long lcm = lcmarr(nums, i);
            long curr = gcd * lcm;
            max = Math.max(curr, max);
        }
        
        return max;
    }
}
