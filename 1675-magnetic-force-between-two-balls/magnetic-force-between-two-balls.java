class Solution {
    public int maxDistance(int[] position, int m) {
        // Step 1: Sort the positions array
        Arrays.sort(position);
        
        // Step 2: Define the binary search bounds
        int left = 1; // Minimum possible distance
        int right = position[position.length - 1] - position[0]; // Maximum possible distance
        
        // Step 3: Binary search for the maximum minimum distance
        while (left < right) {
            int mid = (right + left + 1) / 2; // Calculate mid distance
            if (canplace(position, m, mid)) {
                left = mid; // If we can place the balls, try for a larger minimum distance
            } else {
                right = mid - 1; // If we cannot place the balls, reduce the minimum distance
            }
        }
        
        // The answer is in 'left' when left == right
        return left;
    }
    
    // Helper function to check if we can place m balls with at least minDist distance apart
    private boolean canplace(int[] position, int m, int minDist) {
        int count = 1; // Start by placing the first ball at the first position
        int lastposition = position[0]; // The position of the last placed ball
        
        for (int i = 1; i < position.length; i++) {
            // Check if the current position is at least minDist away from the last placed ball
            if (position[i] - lastposition >= minDist) {
                count++; // Place a ball here
                lastposition = position[i]; // Update the last position
                if (count == m) {
                    return true; // Successfully placed all m balls
                }
            }
        }
        
        return false; // Not possible to place all m balls with the given minDist
    }
}
