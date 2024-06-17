/*t.c:o(n)
The Math.sqrt method returns a value of type double (e.g., 2.0).
To use this value as an integer, we cast it to int.
class Solution{
public boolean judgeSquareSum(int c) {
    int sqrtC = (int)Math.sqrt(c);
    for (int i = 0; i <= sqrtC; i++) {
        int j = (int)Math.sqrt(c - i * i);
        if (i * i + j * j == c) {
            return true;
        }
    }
    return false;
}
}
*/
//t.c =o(sqrt(c))
class Solution {
    public boolean judgeSquareSum(int c) {
        long a = (int)Math.sqrt(c); // truncate the decimal part
        long b = 0;
        while (b <= a) {
            long sum = b * b + a * a;
            if (sum == c) {
                return true;
            } else if (sum < c) {
                b++;
            } else {
                a--;
            }
        }
        return false;
    }
}
