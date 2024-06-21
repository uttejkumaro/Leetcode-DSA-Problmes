class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int totalSatisfied = 0;
        
        // Calculate the total number of satisfied customers without using the secret technique.
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                totalSatisfied += customers[i];
            }
        }
        
        // Calculate the number of customers that can be potentially satisfied by using the technique
        int additionalSatisfied = 0;
        for (int i = 0; i < X; i++) {
            if (grumpy[i] == 1) {
                additionalSatisfied += customers[i];
            }
        }
        
        int maxAdditionalSatisfied = additionalSatisfied;
        
        // Sliding window to calculate the maximum additional satisfied customers in any window of size X
        for (int i = X; i < customers.length; i++) {
            if (grumpy[i - X] == 1) {
                additionalSatisfied -= customers[i - X];
            }
            if (grumpy[i] == 1) {
                additionalSatisfied += customers[i];
            }
            maxAdditionalSatisfied = Math.max(maxAdditionalSatisfied, additionalSatisfied);
        }
        
        return totalSatisfied + maxAdditionalSatisfied;
    }

}
