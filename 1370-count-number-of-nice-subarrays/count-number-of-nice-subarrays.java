class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        int prefixSum = 0;
        int count = 0;
        
        // Initialize the map with prefix sum 0 having one count
        prefixSumCount.put(0, 1);
        
        for (int num : nums) {
            // Update the prefix sum (1 for odd, 0 for even)
            prefixSum += (num % 2 == 1) ? 1 : 0;
            
            // If there's a prefix sum that is (prefixSum - k), it means there's a subarray with exactly k odd numbers
            if (prefixSumCount.containsKey(prefixSum - k)) {
                count += prefixSumCount.get(prefixSum - k);
            }
            
            // Update the map with the current prefix sum count
            prefixSumCount.put(prefixSum, prefixSumCount.getOrDefault(prefixSum, 0) + 1);
        }
        
        return count;
    }
}