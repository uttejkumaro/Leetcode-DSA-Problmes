class Solution {
    long mod = 1000000007;
    // Function to perform modular exponentiation
    long power(long x, long y) {
        if (y == 0) return 1;  // Base case: x^0 = 1
        long ans = power(x, y / 2);  // Recursive step: divide the problem
        ans = (ans * ans) % mod;  // Combine the results
        if (y % 2 != 0) ans = (ans * x) % mod;  // Adjust for odd exponents
        return ans;
    }
    // Function to count good numbers
    public int countGoodNumbers(long n) {
        long odd = n / 2;  // Number of odd positions
        long even = n / 2 + n % 2;  // Number of even positions
        return (int)((power(5, even) * power(4, odd)) % mod);  // Calculate and return result
    }
}
