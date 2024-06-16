class Solution {
    public double myPow(double x, int n) {
        // Base case: any number to the power of 0 is 1
        if (n == 0) {
            return 1;
        }

        // Handle negative exponents
        if (n < 0) {
            // Special case for Integer.MIN_VALUE
            if (n == Integer.MIN_VALUE) {
                // Increment n by 1 to avoid overflow and handle it recursively
                // Use Integer.MAX_VALUE for recursion, then multiply by x once more
                n = Integer.MAX_VALUE;
                x = 1 / x;
                return myPow(x, n) * x;
            }
            // For other negative values of n
            x = 1 / x;
            n = -n;
        }

        // Recursive case: split the exponent
        double half = myPow(x, n / 2);

        // Combine results based on whether n is even or odd
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}
/*
class Solution {
    public double myPow(double x, int n) {
        double ans=Math.pow(x,n);
        return ans;
    }
}
*/