class Solution {
    public double myPow(double x, int n) {
        // Base case
        if (n == 0) {
            return 1;
        }

        // Handle negative exponents
        if (n < 0) {
            // Special case for Integer.MIN_VALUE
            if (n == Integer.MIN_VALUE) {
                // Increment n to avoid overflow and adjust the result accordingly
                x = 1 / x;
                return myPow(x, Integer.MAX_VALUE) * x;
            }
            x = 1 / x;
            n = -n;
        }

        // Recursive case
        double half = myPow(x, n / 2);

        // If n is even
        if (n % 2 == 0) {
            return half * half;
        } else {
            // If n is odd
            return half * half * x;
        }
    }
}
