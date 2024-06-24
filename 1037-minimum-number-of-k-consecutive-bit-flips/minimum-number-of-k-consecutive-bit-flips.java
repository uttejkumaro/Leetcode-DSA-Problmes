public class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int[] flips = new int[n]; // To track where flips start and end
        int flipCount = 0; // Number of flips affecting the current position
        int result = 0; // Number of K-bit flips performed
        
        for (int i = 0; i < n; i++) {
            if (i >= k) {
                flipCount ^= flips[i - k];
            }
            
            // If the current bit is 0 (considering flipCount), we need to flip
            if ((nums[i] ^ flipCount) == 0) {
                // If we can't flip because it would go out of bounds, return -1
                if (i + k > n) {
                    return -1;
                }
                // Perform a flip
                result++;
                flipCount ^= 1;
                flips[i] = 1; // Mark a flip starting at the current position
            }
        }
        
        return result;
    }
}
