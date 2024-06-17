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
