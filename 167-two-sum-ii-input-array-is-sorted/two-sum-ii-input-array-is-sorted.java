class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;  // Define the length of the array
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {  // Start j from i + 1 to avoid duplicates
                if(numbers[i] + numbers[j] == target) {
                    return new int[]{i + 1, j + 1};  // Return 1-based indices
                }
            }
        }
        return new int[]{-1, -1};  // Return an array indicating no solution found
    }
}
