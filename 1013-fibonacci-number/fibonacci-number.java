/*
class Solution {
    public int fib(int n) {
        if (n==0|| n==1){
            return n;
        }
       
       return fib(n-1)+fib(n-2);
            
        
    }
}
*/
class Solution {
    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        
        int a = 0;
        int b = 1;
        int c = 0; // Initial value
        
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        
        return c;
    }
}
