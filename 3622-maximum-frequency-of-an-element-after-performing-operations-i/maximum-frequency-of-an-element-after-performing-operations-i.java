class Solution {
    public int maxFrequency(int[] nums, int k, int maxOps) {
        Arrays.sort(nums);
        int maxFreq = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();
        // Step 1: Count frequency of each unique number
        int startIndex = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != nums[startIndex]) {
                int count = i - startIndex;
                freqMap.put(nums[startIndex], count);
                maxFreq = Math.max(maxFreq, count);
                startIndex = i;
            }
        }
        // handle last group
        int lastCount = nums.length - startIndex;
        freqMap.put(nums[startIndex], lastCount);
        maxFreq = Math.max(maxFreq, lastCount);
        // Step 2: Try every possible target value within range [min(nums), max(nums)]
        for (int target = nums[0]; target <= nums[nums.length - 1]; target++) {
            // find the range [target - k, target + k] using binary search
            int leftIndex = leftBound(nums, target - k);
            int rightIndex = rightBound(nums, target + k);
            // how many numbers can be converted to 'target' (within ±k)
            int totalCoverable = rightIndex - leftIndex + 1;
            int achievable;
            if (freqMap.containsKey(target)) {
                // already have some numbers == target
                int already = freqMap.get(target);
                achievable = Math.min(totalCoverable, already + maxOps);
            } else {
                // no element equals target initially
                achievable = Math.min(totalCoverable, maxOps);
            }
            maxFreq = Math.max(maxFreq, achievable);
        }
        return maxFreq;
    }

    // Find first index where nums[idx] >= value
    private int leftBound(int[] nums, int value) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < value) left = mid + 1;
            else right = mid;
        }
        return left;
    }

    // Find last index where nums[idx] <= value
    private int rightBound(int[] nums, int value) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (nums[mid] > value) right = mid - 1;
            else left = mid;
        }
        return left;
    }    
}
