class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        
        // Initialize the first element of res array
        res[0] = 1;
        
        // Calculate left products and store in res
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        
        // Calculate right products and update res
        int rightprd = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= rightprd;
            rightprd *= nums[i];
        }
        
        return res;
    }
}
