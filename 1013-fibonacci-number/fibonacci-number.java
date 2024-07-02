/* using recursuion t.c =T(n-1)+T(n-2)+d=O(2^n);

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
/* 1. Recursive approach of Fibonacci Series

class fibonacciSeries {
    public static int fib(int n){
        if(n <= 1){
            return n;
        }
        return fib(n-1) + fib(n-2);
    }

    public static void main(String[] args) {
        int n = 100;
        System.out.println(fib(n));
    }
}

2. Memoized approach of Fibonacci Series
import java.util.*;

class fibonacciSeries {

    public static Map<Integer, Long> memo = new HashMap<>();

    public static long fib(int n){
        if(n <= 1){
            return n;
        }

        if(memo.containsKey(n)){
            return memo.get(n);
        }

        long fibVal = fib(n-1) + fib(n-2);
        memo.put(n, fibVal);
        return fibVal;
    }


    public static void main(String[] args) {
        int n = 8000;
        System.out.println(fib(n));
    }
}


3. Tabulation approach of Fibonacci Series
class fibonacciSeries {
    public static int fib(int n){
        int f[] = new int[n + 2];

        f[0] = 0;
        f[1] = 1;
        for(int i=2; i<=n; i++){
            f[i] = f[i-1] + f[i-2];
        }

        return f[n];
    }
    public static void main(String[] args) {
        int n = 9;
        System.out.println(fib(n));
    }
}

4. Optimized for the space - O(1)
   time complexity - O(n)

class fibonacciSeries {
    public static int fib(int n){
        int a = 0, b = 1, c;
        if(n == 0){
            return a;
        }
        for(int i=2; i<=n; i++){
            c = a + b;
            a = b;
            b = c;
        }

        return b;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(fib(n));
    }
}

*/