class Solution {
    public int tribonacci(int n) {
        int a = 0, b = 1, c = 1;
        
        if (n == 0) {
            return a;
        }
        
        if (n == 1 || n == 2) {
            return n == 1 ? b : c;
        }
        
        for (int i = 3; i <= n; i++) {
            int next = a + b + c;
            a = b;
            b = c;
            c = next;
        }
        
        return c;
    }
}
